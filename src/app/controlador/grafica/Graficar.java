/*
Controlador para graficar
 */
package app.controlador.grafica;

import app.controlado.sesion.Sesion;
import app.modelo.graficaxy.GraficaXY;
import app.vista.graficas.IGGraficasXYSensores;
import app.vista.usuario.IGPrincipal;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Graficar {
    
    private GraficaXY graficaXY;
    
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
        graficaXY = new GraficaXY(sesion.getArchivosCargados().get(tabla.getSelectedRow()).getLectura());
        //new IGGraficasSensores(principal,graficaXY).setVisible(true);
        new IGGraficasXYSensores(sesion.getArchivosCargados().get(tabla.getSelectedRow()).getNombre(), graficaXY).setVisible(true);
    }
}
