package app.controlador.controlmovil;

import app.controlado.sesion.Sesion;
import app.modelo.comunicacion.serial.ConexionSerialImple;
import app.modelo.entidades.Parametro;
import app.vista.usuario.IGJoystick;
import app.vista.usuario.IGParametros;
import app.vista.usuario.IGPrincipal;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class UsarControl {

    public static void hacer(Sesion sesion, IGPrincipal principal) {
        if (ConexionSerialImple.puertosDisponibles().length != 0) {
            if (sesion.getConexionSerial().estaAbierto()) {
                //si la conexion al puerto esta abierta continua al joystick directamente
                new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
                principal.setVisible(false);
            } else {
                //No hay conexion, pedir parametros
                new IGParametros(sesion, principal).setVisible(true);
                principal.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(principal, "Error no se encontraron puertos COM disponibles", "Puertos COM no disponibles", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void comprobado(Sesion sesion, IGPrincipal principal, IGParametros iGParametros) {
        iGParametros.setVisible(false);
        new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
    }

    public static void conectarYUsar(Sesion sesion, Parametro parametro, IGPrincipal principal) {
        //Se establecen el objeto parametro en la sesion y en el objeto de la comunicacion
        sesion.setParametros(parametro);
        sesion.getConexionSerial().setParametros(parametro);
        try {
            sesion.getConexionSerial().abrir();
            new IGJoystick(sesion.getConexionSerial(), principal).setVisible(true);
        } catch (SerialPortException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el puerto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
