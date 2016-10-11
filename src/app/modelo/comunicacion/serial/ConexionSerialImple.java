package app.modelo.comunicacion.serial;

import app.modelo.entidades.Parametro;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ConexionSerialImple implements ConexionSerial, SerialPortEventListener {

    private SerialPort serialPort;
    private Parametro parametros;
    private String mensaje;
    private String mensajeAux;

    public ConexionSerialImple() {
    }

    public ConexionSerialImple(Parametro parametros) {
        this.parametros = parametros;
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    @Override
    public void abrir() throws SerialPortException {
        //Hacer conexion al puerto COM
        mensajeAux = "";
        serialPort = new SerialPort(parametros.getPuerto());
        serialPort.openPort();
        serialPort.setParams(parametros.getBaudios(), parametros.getDatos(), parametros.getParo(), parametros.getParidad());
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
        serialPort.addEventListener(this, SerialPort.MASK_RXCHAR);
    }

    @Override
    public void cerrar() throws SerialPortException {
        serialPort.closePort();
    }

    @Override
    public void escribirMensaje(String mensaje) throws SerialPortException {
        serialPort.writeBytes(mensaje.getBytes());
    }

    @Override
    public String leerMensaje() throws SerialPortException {
        return mensaje;
    }

    @Override
    public boolean estaAbierto() {
        return serialPort != null;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                String receivedData = serialPort.readString(event.getEventValue());
                //System.out.println("Received response: " + receivedData);
                if(receivedData.contains("\n")){
                    mensaje = mensajeAux + receivedData;
                    mensajeAux = "";
                }
                else{
                    mensajeAux += receivedData;
                }
            } catch (SerialPortException ex) {
                System.out.println("Error in receiving string from COM-port: " + ex);
            }
        }
    }

    public static Object[] puertosDisponibles() {
        return SerialPortList.getPortNames();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            @SuppressWarnings("SleepWhileInLoop")
            public void run() {
                ConexionSerialImple serial = new ConexionSerialImple(new Parametro("COM5", 9600, 8, 1, 0));
                try {
                    serial.abrir();
                    Thread.sleep(2000);
                    while (true) {
                        Thread.sleep(200);
                        System.out.print(serial.mensaje);
                    }
                } catch (SerialPortException | InterruptedException ex) {
                    Logger.getLogger(ConexionSerialImple.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
