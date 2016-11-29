/*
Controlador para graficar
 */
package app.controlador.grafica;

import app.controlado.sesion.Sesion;
import app.modelo.convertidor.Calibrar;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.SensoresConvercion;
import app.modelo.entidades.Trama;
import app.modelo.graficaxy.GraficaXYs;
import app.vista.graficas.IGSensores;
import app.vista.usuario.IGPrincipal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Graficar {
    
    private GraficaXYs graficaXY;
    
    public void hacer(IGPrincipal principal,Sesion sesion, JTable tabla){
        //Checar si algun archivo cragado
        if(sesion.getArchivosCargados().isEmpty()){
            JOptionPane.showMessageDialog(principal, "Ningun archivo cargado");
            return;
        }
        //Checar si se esta seleccionando algun elemento en la tabla
        if(tabla.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(principal, "Seleccione un elemeto de la tabla", "Ningun elemento seleccionado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Pasar a graficar
        ArchivosCargado archivo = sesion.getArchivosCargados().get(tabla.getSelectedRow());
        graficaXY = new GraficaXYs(archivo.getLectura());
        Calibrar calibrar = new Calibrar();
        SensoresConvercion sensores = calibrar.hacer(archivo);
        new IGSensores(graficaXY,sensores).setVisible(true);
        // new IGGraficasXYSensores(sesion.getArchivosCargados().get(tabla.getSelectedRow()).getNombre(), graficaXY).setVisible(true);
    }
    
}
