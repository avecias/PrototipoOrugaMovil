
package app.controlador.control;

import app.controlador.control.sesion.Sesion;
import app.vista.usuario.IGJoystick;
import app.vista.usuario.IGParametros;
import app.vista.usuario.IGPrincipal;

public class UsarControl {

    public static void hacer(Sesion sesion, IGPrincipal principal) {
        if(sesion.getConexionSerial().estaAbierto()){
            //si la conexion al puerto esta abierta continua al joystick directamente
            new IGJoystick(sesion.getConexionSerial(),principal).setVisible(true);
            principal.setVisible(false);
        }
        else{
            //No hay conexion, pedir parametros
            new IGParametros(sesion,principal).setVisible(true);
            principal.setVisible(false);
        }
    }

    public static void comprobado(Sesion sesion, IGPrincipal principal, IGParametros iGParametros) {
        iGParametros.setVisible(false);
        new IGJoystick(sesion.getConexionSerial(),principal).setVisible(true);
    }
}
