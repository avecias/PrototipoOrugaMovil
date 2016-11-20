/*
 Pantalla inicial del software mostrando la carga de varios parametros
y el inicio de la sesion
 */
package app.vista.usuario;

import app.controlado.sesion.Sesion;
import javax.swing.ImageIcon;


public class Slash extends javax.swing.JFrame {

    private class BarraDeEstado extends Thread {
        
        private Slash slash;
        
        public BarraDeEstado(Slash slash){
            this.slash = slash;
        }
        @Override
        public void run() {
            try {
                //El programa esta cargando
                notificacion.setText("Cargando...");
                for (int i = 0; i < 100; i++) {
                    barra.setValue(i);
                    Thread.sleep(5);
                }
                //Sesion iniciada
                Sesion sesion = new Sesion();
                sesion.iniciar();
                notificacion.setText("Sesion iniciada");
                new IGPrincipal(sesion).setVisible(true);
                slash.setVisible(false);
                slash.dispose();
            } catch (InterruptedException e) {
                System.err.println("Error al dormir " + e);
            }
        }

    }

    public Slash() {
        initComponents();
        setIconImage(new ImageIcon("src/app/imagenes/icono.jpg").getImage());
        new BarraDeEstado(this).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagen = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        notificacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargando");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/rover5.jpg"))); // NOI18N

        titulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        titulo.setText("Software Prototipo De Robot Oruga Movil");

        notificacion.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagen)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(titulo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(notificacion)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(25, 25, 25)
                .addComponent(imagen)
                .addGap(18, 18, 18)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Slash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Slash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Slash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Slash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Slash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel notificacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
