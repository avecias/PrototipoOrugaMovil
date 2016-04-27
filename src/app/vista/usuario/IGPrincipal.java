
package app.vista.usuario;

import app.controlador.control.Archivo;
import app.controlador.control.Reporte;
import java.io.File;


public class IGPrincipal extends javax.swing.JFrame {

    private File lecturas;
    
    public IGPrincipal() {
        initComponents();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuJoystick = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prototipo de Robot Oruga Movil");

        jMenu1.setText("Archivo");

        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        menuReporte.setText("Generar Reporte");
        menuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteActionPerformed(evt);
            }
        });
        jMenu1.add(menuReporte);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Control");

        menuJoystick.setText("Joystick");
        menuJoystick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJoystickActionPerformed(evt);
            }
        });
        jMenu2.add(menuJoystick);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuJoystickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJoystickActionPerformed
        // TODO add your handling code here:
        Joystick j = new Joystick();
        j.setVisible(true);
    }//GEN-LAST:event_menuJoystickActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // Salir de toda la aplicacion
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        // TODO add your handling code here:
        lecturas = Archivo.leer();
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void menuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteActionPerformed
        // TODO add your handling code here:
        Reporte.generar(lecturas);
    }//GEN-LAST:event_menuReporteActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IGPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuJoystick;
    private javax.swing.JMenuItem menuReporte;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}