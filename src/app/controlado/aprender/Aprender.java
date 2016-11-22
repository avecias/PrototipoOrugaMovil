/*
Acciones para el aprendizaje
 */
package app.controlado.aprender;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.Clase;
import app.modelo.entidades.Fusion;
import app.modelo.ia.kmeans.Kmeans;
import app.modelo.ia.kmeans.Kmeans3D;
import app.vista.graficas.IGVerAprendizaje;
import app.vista.usuario.IGFusionar;
import java.util.ArrayList;
import java.util.List;
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

    public void verAprendizaje(Sesion sesion, JMenuItem menuResultado) {
        // Bajar lo datos para la sesion
        List<Clase[]> fusionados = sesion.getFusionados();
        List<Clase[]> fusionadosClasificados = new ArrayList<>();
        if (sesion.getFusion().getFusion1().length == Fusion.DOS_DIMENSIONES) {
            Kmeans kmeans1 = new Kmeans(fusionados.get(0)[0].getPuntos(), sesion.getFusion().getK1());
            Clase[] clasificacion1 = kmeans1.calcular();
            fusionadosClasificados.add(clasificacion1);
        } else {
            Kmeans3D kmeans1 = new Kmeans3D(fusionados.get(0)[0].getPuntos(), sesion.getFusion().getK1());
            Clase[] clasificacion1 = kmeans1.calcular();
            fusionadosClasificados.add(clasificacion1);
        }
        if (sesion.getFusion().getFusion2().length == Fusion.DOS_DIMENSIONES) {
            Kmeans kmeans2 = new Kmeans(fusionados.get(1)[0].getPuntos(), sesion.getFusion().getK2());
            Clase[] clasificacion2 = kmeans2.calcular();
            fusionadosClasificados.add(clasificacion2);
        } else {
            Kmeans3D kmeans2 = new Kmeans3D(fusionados.get(1)[0].getPuntos(), sesion.getFusion().getK2());
            Clase[] clasificacion2 = kmeans2.calcular();
            fusionadosClasificados.add(clasificacion2);
        }
        if (sesion.getFusion().getFusion3().length == Fusion.DOS_DIMENSIONES) {
            Kmeans kmeans3 = new Kmeans(fusionados.get(2)[0].getPuntos(), sesion.getFusion().getK3());
            Clase[] clasificacion3 = kmeans3.calcular();
            fusionadosClasificados.add(clasificacion3);
        } else {
            Kmeans3D kmeans3 = new Kmeans3D(fusionados.get(2)[0].getPuntos(), sesion.getFusion().getK3());
            Clase[] clasificacion3 = kmeans3.calcular();
            fusionadosClasificados.add(clasificacion3);
        }
        sesion.setFusionadosClasificados(fusionadosClasificados);
        new IGVerAprendizaje(sesion, fusionadosClasificados, fusionados).setVisible(true);
        menuResultado.setEnabled(true);
    }
}
