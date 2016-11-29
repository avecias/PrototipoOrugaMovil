/*
Ver el archivo de la ruta
 */
package app.controlador.archivo;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Lectura;
import app.modelo.entidades.Trama;
import app.vista.usuario.IGPrincipal;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class VerRuta {

    private final int DERECHA_ADELANTE = 1;
    private final int ATRAS_DERECHA = 2;
    private final int ATRAS_IZQUIERDA = 3;
    private final int IZQUIERDA_ADELANTE = 8;
    private final int ADELANTE = 9;
    private final int ATRAS = 6;
    private final int DETENER = 0;
    private final int GIRO_DERECHA = 5;
    private final int GIRO_IZQUIERDA = ':';
    private final String ARCHIVO = "ruta.txt";

    public void leerArchivo(IGPrincipal principal,Sesion sesion, JTable tabla) {
        PrintWriter pw = null;
        try {
            //Checar si algun archivo cragado
            if(sesion.getArchivosCargados().isEmpty()){
                JOptionPane.showMessageDialog(principal, "Ningun archivo cargado");
                return;
            }   //Checar si se esta seleccionando algun elemento en la tabla
            if(tabla.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(principal, "Seleccione un elemeto de la tabla", "Ningun elemento seleccionado", JOptionPane.ERROR_MESSAGE);
                return;
            }   //Pasar a graficar
            ArchivosCargado archivo = sesion.getArchivosCargados().get(tabla.getSelectedRow());
            List<Trama> tramas = archivo.getLectura().getTramas();
            pw = new PrintWriter(ARCHIVO);
            for (int i = 0; i < tramas.size(); i++) {
                int valor = tramas.get(i).getEncoder();
                switch (valor) {
                    case DERECHA_ADELANTE:
                        pw.println(i + ". DERECHA_ADELANTE");
                        break;
                    case IZQUIERDA_ADELANTE:
                        pw.println(i + ". IZQUIERDA_ADELANTE");
                        break;
                    case ADELANTE:
                        pw.println(i + ". ADELANTE");
                        break;
                    case ATRAS:
                        pw.println(i + ". ATRAS");
                        break;
                    case DETENER:
                        pw.println(i + ". DETENER");
                        break;
                    case GIRO_DERECHA:
                        pw.println(i + ". GIRO_DERECHA");
                        break;
                    case GIRO_IZQUIERDA:
                        pw.println(i + ". GIRO_IZQUIERDA");
                        break;
                    case ATRAS_DERECHA:
                        pw.println(i + ". ATRAS_DERECHA");
                        break;
                    case ATRAS_IZQUIERDA:
                        pw.println(i + ". ATRAS_IZQUIERDA");
                        break;
                    default:
                        pw.println(i + ". Nada");
                        break;
                }
            }
            pw.close();
            Desktop.getDesktop().open(new File(ARCHIVO));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerRuta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerRuta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
}
