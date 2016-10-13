/*
Controlador para mover el movil (no es conveniente que se estatico)
 */
package app.controlador.controlmovil;

import app.modelo.comunicacion.serial.ConexionSerialImple;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class MoverMovil {

    private final ConexionSerialImple conexionSerial;

    public MoverMovil(ConexionSerialImple conexionSerial) {
        this.conexionSerial = conexionSerial;
    }

    public void adelante() {
        mover("9");
    }

    public void atras() {
        mover("6");
    }

    public void derechaAdelante() {
        mover("1");
    }

    public void derechaAtras() {
        mover("2");
    }

    public void parar() {
        mover("0");
    }

    public void izquierdaAdelante() {
        mover("8");
    }

    public void izquierdaAtras() {
        mover("7");
    }

    public void giroDerecha() {
        mover("5");
    }

    public void giroIzquierda() {
        mover(":");
    }

    public void autoExploracion() {
        try {
            mover("A");
            conexionSerial.cerrar();
        } catch (SerialPortException ex) {
            System.err.println("Error al cerrar la conexion " + ex);
        }
    }

    private void mover(String m) {
        try {
            conexionSerial.escribirMensaje(m);
        } catch (SerialPortException e) {
            System.err.println("No se pudo mandar el movimiento " + e);
            JOptionPane.showMessageDialog(null, "Error al mandar el movimiento\n" + e, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
