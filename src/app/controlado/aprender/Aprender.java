/*
Acciones para el aprendizaje
 */
package app.controlado.aprender;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.Fusion;
import app.vista.usuario.IGFusionar;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Aprender {

    public void fusionar(Sesion sesion, JTable tabla, JMenuItem menuClasificar) {
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
        new IGFusionar(sesion, menuClasificar).setVisible(true);
    }

    public void guardarFusion(Sesion sesion, JComboBox<String>[][] comboBoxs, IGFusionar fusionar, JMenuItem menuClasificar) {
        if (!validarLlenado(comboBoxs)) {
            JOptionPane.showMessageDialog(fusionar, "Debe seleccionar al menos dos sensores por clasificacion", "Error falan campos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validarRepetidos(comboBoxs)) {
            JOptionPane.showMessageDialog(fusionar, "No repita sensores por clasificacion es redundante", "Error campos repetidos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Una vez validado las combinaciones se sube a la session el resultado de las combinaciones
        Fusion fusion = combinar(comboBoxs);
        sesion.setFusion(fusion);
        System.out.println(fusion);
        JOptionPane.showMessageDialog(fusionar, "Datos fusionados con exito");
        fusionar.setVisible(false);
        fusionar.dispose();
        menuClasificar.setEnabled(true);
    }

    private boolean validarLlenado(JComboBox<String>[][] comboBoxs) {
        boolean bandera = true;
        int vacio = 0;
        for (JComboBox<String>[] comboBox : comboBoxs) {
            for (JComboBox<String> jComboBox : comboBox) {
                // Examinar que todo tenga al menos dos sensores seleccionados
                if (jComboBox.getSelectedIndex() == 0) {
                    vacio++;
                    if (vacio > 1) {
                        bandera = false;
                        break;
                    }
                }
            }
            vacio = 0;
        }
        return bandera;
    }

    private boolean validarRepetidos(JComboBox<String>[][] comboBoxs) {
        boolean bandera = true;
        for (JComboBox<String>[] comboBox : comboBoxs) {
            if (comboBox[0].getSelectedIndex() == comboBox[1].getSelectedIndex() || comboBox[0].getSelectedIndex() == comboBox[2].getSelectedIndex() || comboBox[1].getSelectedIndex() == comboBox[2].getSelectedIndex()) {
                bandera = false;
                break;
            }
        }
        return bandera;
    }

    private Fusion combinar(JComboBox<String>[][] comboBoxs) {
        Fusion fusion = new Fusion();
        String a = "";
        for (int i = 0; i < 3; i++) {
            if (comboBoxs[0][i].getSelectedIndex() != 0) {
                a += (String) comboBoxs[0][i].getSelectedItem() + ",";
            }
        }
        fusion.setFusion1(a.split(","));
        a = "";
        for (int i = 0; i < 3; i++) {
            if (comboBoxs[1][i].getSelectedIndex() != 0) {
                a += (String) comboBoxs[1][i].getSelectedItem() + ",";
            }
        }
        fusion.setFusion2(a.split(","));
        a = "";
        for (int i = 0; i < 3; i++) {
            if (comboBoxs[2][i].getSelectedIndex() != 0) {
                a += (String) comboBoxs[2][i].getSelectedItem() + ",";
            }
        }
        fusion.setFusion3(a.split(","));
        return fusion;
    }
}
