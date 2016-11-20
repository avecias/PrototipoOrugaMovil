/*
Supervisar previamente para poder aprender
 */
package app.controlado.aprender;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Clase;
import app.modelo.entidades.Fusion;
import app.vista.graficas.IGAprendizajeSupervisado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Supervisar {
    
    public void hacer(JTabbedPane tabPanel){
        // Supervisar agregando un valo de k menas a cada grafica
        tabPanel.setSelectedIndex(0);
        System.out.println(JOptionPane.showConfirmDialog(null, "Valor"));
        tabPanel.setSelectedIndex(1);
        System.out.println(JOptionPane.showConfirmDialog(null, "Valor"));
        tabPanel.setSelectedIndex(2);
        System.out.println(JOptionPane.showConfirmDialog(null, "Valor"));
    }
    
    public void mostrar(Sesion sesion, JTable tabla){
        // Mostrar el resultado de la combinacion de sensores
         // Guardar los datos fucionados en la session
        if (sesion.getArchivosCargados().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun archivo cargado");
            return;
        }
        //Checar si se esta seleccionando algun elemento en la tabla
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemeto de la tabla", "Ningun elemento seleccionado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Pasar a la interfaz grafica del clasificador
        ArchivosCargado archivo = sesion.getArchivosCargados().get(tabla.getSelectedRow());
        Fusion fusion = sesion.getFusion();
        List<Clase[]> fusionados = fusionar(archivo,fusion);
        new IGAprendizajeSupervisado(fusionados).setVisible(true);
    }

    private List<Clase[]> fusionar(ArchivosCargado archivo, Fusion fusion) {
        List<Clase[]> fusionados = new ArrayList<>();
        return fusionados;
    }
}
