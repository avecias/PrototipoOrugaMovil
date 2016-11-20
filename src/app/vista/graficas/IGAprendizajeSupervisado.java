/*
Clase para la visualizacion de la fusion de datos para su visualizacion y clasificacion supervisada
 */
package app.vista.graficas;

import app.controlado.aprender.Supervisar;
import app.modelo.entidades.Clase;
import java.util.List;

public class IGAprendizajeSupervisado extends javax.swing.JFrame {

    private final Supervisar supervisar;
    
    public IGAprendizajeSupervisado() {
        initComponents();
        supervisar = new Supervisar();
    }

    public IGAprendizajeSupervisado(List<Clase[]> fusionados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        MenuAceptar = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aprendizaje Supervisado");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        tabPanel.addTab("Clasificacion1", panel1);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        tabPanel.addTab("Clasificacion2", panel2);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        tabPanel.addTab("Clasificacion3", panel3);

        menuArchivo.setText("Archivo");

        MenuAceptar.setText("Aceptar");
        MenuAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAceptarActionPerformed(evt);
            }
        });
        menuArchivo.add(MenuAceptar);

        menu.add(menuArchivo);

        menuEdit.setText("Edit");
        menu.add(menuEdit);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAceptarActionPerformed
        // Agregar k para la supervision
        supervisar.hacer(tabPanel);
    }//GEN-LAST:event_MenuAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAceptar;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
