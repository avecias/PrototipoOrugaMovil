
package app.controlador.control;

import app.modelo.comunicacion.Serial;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Movimiento {
    
    private Serial dispositivo;

    public Movimiento() {
    }
    
    public void puertosDisponibles(JComboBox COMM){
        Object[] puertosDisponibles = Serial.puertosDisponibles();
        for (Object puertosDisponible : puertosDisponibles) {
            System.out.println(puertosDisponible);
        }
        COMM.setModel(new DefaultComboBoxModel(puertosDisponibles));
    }
    
    public boolean conectar(String COMM, Integer baudios, Integer bits, Integer paro, Integer parida){
        dispositivo = new Serial(COMM, baudios, bits, paro, parida);
        return dispositivo.abrirPuerto();
    }

    public void adelante() {
        dispositivo.escribirMensaje("9");
    }

    public void atras() {
        dispositivo.escribirMensaje("6");
    }

    public void derechaAdelante() {
        dispositivo.escribirMensaje("1");
    }

    public void derechaAtras() {
        dispositivo.escribirMensaje("2");
    }

    public void parar() {
        dispositivo.escribirMensaje("0");
    }

    public void izquierdaAdelante() {
        dispositivo.escribirMensaje("8");
    }

    public void izquierdaAtras() {
        dispositivo.escribirMensaje("7");
    }

    public void giroDerecha() {
        dispositivo.escribirMensaje("5");
    }

    public void giroIzquierda() {
        dispositivo.escribirMensaje(":");
    }

    public boolean desconectar() {
        return dispositivo.cerrarPuerto();
    }
 
}
