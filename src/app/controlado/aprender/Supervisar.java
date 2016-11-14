/*
Supervisar previamente para poder aprender
 */
package app.controlado.aprender;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

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
}
