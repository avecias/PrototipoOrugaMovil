
package app.modelo.comunicacion;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class Serial {
    
    public static Object[] puertosDisponibles() {
        return SerialPortList.getPortNames();
    }

    private SerialPort serialPort;
    private String mensaje;
    private Integer baudios, bits, paro, parida;
    private String COMM;

    public Serial(String COMM, Integer baudios, Integer bits, Integer paro, Integer parida) {
        this.COMM = COMM;
        this.baudios = baudios;
        this.bits = bits;
        this.paro = paro;
        this.parida = parida;
    }

    public boolean abrirPuerto() {
        try {
            serialPort = new SerialPort(COMM);
            serialPort.openPort();
            serialPort.setParams(baudios, bits, paro, parida);
            return true;
        } catch (SerialPortException ex) {
            System.err.println("Error en conectar al puerto " + ex);
            return false;
        }
    }

    public String leerMensaje() {
        return mensaje;
    }

    public void escribirMensaje(String mensaje) {
        try {
            serialPort.writeBytes(mensaje.getBytes());
        } catch (SerialPortException ex) {
            System.err.println("Error al escribir mensaje " + ex);
        }
    }

    public boolean cerrarPuerto() {
        try {
            serialPort.closePort();
            return true;
        } catch (SerialPortException ex) {
            System.err.println("Error al desconectar " + ex);
            return false;
        }
    }

    public Integer getBaudios() {
        return baudios;
    }

    public void setBaudios(Integer baudios) {
        this.baudios = baudios;
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public Integer getParo() {
        return paro;
    }

    public void setParo(Integer paro) {
        this.paro = paro;
    }

    public Integer getParida() {
        return parida;
    }

    public void setParida(Integer parida) {
        this.parida = parida;
    }

    public String getCOMM() {
        return COMM;
    }

    public void setCOMM(String COMM) {
        this.COMM = COMM;
    }
    
}
