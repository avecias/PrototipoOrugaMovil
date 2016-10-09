/*
Controlador para mover el movil (no es conveniente que se estatico)
 */
package app.controlador.controlmovil;

import app.modelo.comunicacion.serial.ConexionSerialImple;

public class MoverMovil {
    
    private final ConexionSerialImple conexionSerial;

    public MoverMovil(ConexionSerialImple conexionSerial) {
        this.conexionSerial = conexionSerial;
    }
    
    
    public void adelante() {
        conexionSerial.escribirMensaje("9");
    }

    public void atras() {
        conexionSerial.escribirMensaje("6");
    }

    public void derechaAdelante() {
        conexionSerial.escribirMensaje("1");
    }

    public void derechaAtras() {
        conexionSerial.escribirMensaje("2");
    }

    public void parar() {
        conexionSerial.escribirMensaje("0");
    }

    public void izquierdaAdelante() {
        conexionSerial.escribirMensaje("8");
    }

    public void izquierdaAtras() {
        conexionSerial.escribirMensaje("7");
    }

    public void giroDerecha() {
        conexionSerial.escribirMensaje("5");
    }

    public void giroIzquierda() {
        conexionSerial.escribirMensaje(":");
    }
}
