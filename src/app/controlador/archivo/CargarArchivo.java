/*
Control para la carga de los archivo y mostrarlos en la tabla con lo demas resultados
ademas de solicitarle un nombre especial y agregarle un fecha a cada lectura
 */
package app.controlador.archivo;

import app.controlado.sesion.Sesion;
import app.modelo.convertidor.Convertidor;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Lectura;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class CargarArchivo {
    
    public static void hacer(Sesion sesion, JTable tabla, JLabel pieTabla){
        ValidarArchivo validarArchivo = new ValidarArchivo();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione el archivo de las lecturas");
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT","txt"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            //Verificar si es un archivo valido para ser leido
            if(!validarArchivo.hacer(file)){
                JOptionPane.showMessageDialog(null, "El cotenido del archivo no es correcto", "Archivo no valido", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Archivo cargado con exito");
            //Renombrar el archivo
            String reNombre = JOptionPane.showInputDialog("Inserte un nombre al archivo");
            if(reNombre == null){
                JOptionPane.showMessageDialog(null, "El archivo necesita ser renombrado ", "Ningun Nombre", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Convertir el archivo
            Lectura lectura = Convertidor.aLectura(file);
            Date fecha = new Date(new GregorianCalendar().getTimeInMillis());
            SimpleDateFormat formateador = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy 'hora:' hh:mm:ss a", new Locale("ES"));
            //Cargar en la tabla
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            int numero = model.getRowCount() + 1;
            model.addRow(new Object[]{numero,reNombre,formateador.format(fecha),file.getName()});
            tabla.setModel(model);
            //Subir a Sesion
            sesion.getArchivosCargados().add(new ArchivosCargado(numero, reNombre, lectura, fecha));
            //Mostrar el total de archivos
            pieTabla.setText("Total de archivo(s): " + sesion.getArchivosCargados().size());
        }
        else{
            JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo","Ningun Archivo",JOptionPane.ERROR_MESSAGE);
        }
    }
}
