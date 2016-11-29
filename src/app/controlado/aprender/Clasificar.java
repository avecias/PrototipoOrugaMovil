/*
Clase para calificar lo aprendido
 */
package app.controlado.aprender;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Clase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Clasificar {
    
    public void resultado(Sesion sesion, JTable tabla){
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
        List<Clase[]> clasificados = sesion.getFusionadosClasificados();
        List<Clase[]> clasificadosArchivo = new Supervisar().fusionar(archivo, sesion.getFusion());
        List<Clase[]> resultado = clasificacion(clasificados,clasificadosArchivo);
    }

    private List<Clase[]> clasificacion(List<Clase[]> clasificados, List<Clase[]> clasificadosArchivo) {
        List<Clase[]> resultado = new ArrayList<>();
        
        return resultado;
    }

    
}
