package app.controlador.controlmovil;

import app.controlado.sesion.Sesion;
import app.modelo.comunicacion.serial.ConexionSerial;
import app.modelo.entidades.Parametro;
import app.vista.usuario.IGJoystick;
import app.vista.usuario.IGParametros;
import app.vista.usuario.IGPrincipal;
import javax.swing.JOptionPane;

public class UsarControl {

    public static void hacer(Sesion sesion, IGPrincipal principal) {
        if (ConexionSerial.puertosDisponibles().length != 0) {
            if (sesion.getConexionSerial().estaAbierto()) {
                //si la conexion al puerto esta abierta continua al joystick directamente
                new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
                principal.setVisible(false);
            } else {
                //No hay conexion, pedir parametros
                new IGParametros(sesion, principal).setVisible(true);
                principal.setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(principal, "Error no se encontraron puertos COM disponibles", "Puertos COM no disponibles", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void comprobado(Sesion sesion, IGPrincipal principal, IGParametros iGParametros) {
        iGParametros.setVisible(false);
        new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
    }

    public static void conectarYUsar(Sesion sesion, Parametro parametro, IGPrincipal principal) {
        sesion.setParametros(parametro);
        if (sesion.getConexionSerial().abrirPuerto(parametro)) {
            new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error al conectar con el puerto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
