package app.modelo.comunicacion.serial;

import app.modelo.entidades.Parametro;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ConexionSerialImple implements ConexionSerial,SerialPortEventListener {

    private SerialPort serialPort;
    private Parametro parametros;

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
        serialPort = new SerialPort(parametros.getPuerto());
        serialPort.openPort();
        serialPort.setParams(parametros.getBaudios(), parametros.getDatos(), parametros.getParo(), parametros.getParidad());
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
        return serialPort.readString();
    }

    @Override
    public boolean estaAbierto() {
        return serialPort != null;
    }

    public static Object[] puertosDisponibles() {
        return SerialPortList.getPortNames();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConexionSerialImple serial = new ConexionSerialImple(new Parametro("COM5", 9600, 8, 1, 0));
                try {
                    serial.abrir();
                    while (true) {
                        System.out.println(serial.leerMensaje());
                    }
                } catch (SerialPortException ex) {
                    Logger.getLogger(ConexionSerialImple.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
