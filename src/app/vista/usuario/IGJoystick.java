package app.vista.usuario;

import app.controlador.control.Movimiento;
import app.modelo.comunicacion.serial.ConexionSerial;
import javax.swing.ImageIcon;

public class IGJoystick extends javax.swing.JFrame {

    Movimiento movimiento;
    private IGPrincipal principal;
    
    public IGJoystick(ConexionSerial conexionSerial, IGPrincipal principal) {
        this.principal = principal;
        initComponents();
        setIconImage(new ImageIcon("src/app/imagenes/icono.jpg").getImage());
        movimiento = new Movimiento();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAdelante = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        botonDetener = new javax.swing.JButton();
        botonDerechaAdelante = new javax.swing.JButton();
        botonDerechaAtras = new javax.swing.JButton();
        botonIzquierdaAdelante = new javax.swing.JButton();
        botonIzquierdaAtras = new javax.swing.JButton();
        botonGiroIzquierda = new javax.swing.JButton();
        botonGiroDerecha = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Joystick");
        setFocusCycleRoot(false);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                haber(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                cerrar(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boton(evt);
            }
        });

        botonAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/adelante.png"))); // NOI18N
        botonAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdelanteActionPerformed(evt);
            }
        });

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/atras.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonDetener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/parar.png"))); // NOI18N
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });

        botonDerechaAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/derechaAdelante.png"))); // NOI18N
        botonDerechaAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDerechaAdelanteActionPerformed(evt);
            }
        });

        botonDerechaAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/derechaAtras.png"))); // NOI18N
        botonDerechaAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDerechaAtrasActionPerformed(evt);
            }
        });

        botonIzquierdaAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/izquierdaAdelante.png"))); // NOI18N
        botonIzquierdaAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIzquierdaAdelanteActionPerformed(evt);
            }
        });

        botonIzquierdaAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/izquierdaAtras.png"))); // NOI18N
        botonIzquierdaAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIzquierdaAtrasActionPerformed(evt);
            }
        });

        botonGiroIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/giroDerecha.png"))); // NOI18N
        botonGiroIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGiroIzquierdaActionPerformed(evt);
            }
        });

        botonGiroDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/giroIzquierda.png"))); // NOI18N
        botonGiroDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGiroDerechaActionPerformed(evt);
            }
        });

        jButton1.setText("Desconectar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Control para la manipulacion inambrica de movil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGiroIzquierda, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonIzquierdaAtras)
                                    .addComponent(botonIzquierdaAdelante))
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(botonAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(botonDetener))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonDerechaAtras)
                            .addComponent(botonDerechaAdelante)
                            .addComponent(botonGiroDerecha))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonAdelante, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addComponent(botonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botonDetener))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(botonDerechaAdelante)
                            .addGap(21, 21, 21)
                            .addComponent(botonDerechaAtras)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(botonIzquierdaAdelante)
                        .addGap(26, 26, 26)
                        .addComponent(botonIzquierdaAtras)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGiroDerecha)
                            .addComponent(botonGiroIzquierda))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(94, 94, 94))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void haber(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_haber
        // Validar este movimiento
    }//GEN-LAST:event_haber

    private void botonAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdelanteActionPerformed
        // TODO add your handling code here:
        movimiento.adelante();
    }//GEN-LAST:event_botonAdelanteActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        movimiento.atras();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonDerechaAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDerechaAdelanteActionPerformed
        // TODO add your handling code here:
        movimiento.derechaAdelante();
    }//GEN-LAST:event_botonDerechaAdelanteActionPerformed

    private void botonDerechaAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDerechaAtrasActionPerformed
        // TODO add your handling code here:
        movimiento.derechaAtras();
    }//GEN-LAST:event_botonDerechaAtrasActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        // TODO add your handling code here:
        movimiento.parar();
    }//GEN-LAST:event_botonDetenerActionPerformed

    private void botonIzquierdaAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIzquierdaAdelanteActionPerformed
        // TODO add your handling code here:
        movimiento.izquierdaAdelante();
    }//GEN-LAST:event_botonIzquierdaAdelanteActionPerformed

    private void botonIzquierdaAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIzquierdaAtrasActionPerformed
        // TODO add your handling code here:
        movimiento.izquierdaAtras();
    }//GEN-LAST:event_botonIzquierdaAtrasActionPerformed

    private void botonGiroDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGiroDerechaActionPerformed
        // TODO add your handling code here:
        movimiento.giroDerecha();
    }//GEN-LAST:event_botonGiroDerechaActionPerformed

    private void botonGiroIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGiroIzquierdaActionPerformed
        // TODO add your handling code here:
        movimiento.giroIzquierda();
    }//GEN-LAST:event_botonGiroIzquierdaActionPerformed

    private void boton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boton
        // Presionar algun boto
        System.out.println("Tecla");
    }//GEN-LAST:event_boton

    private void cerrar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrar
        // TODO add your handling code here:
        principal.setVisible(true);
    }//GEN-LAST:event_cerrar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonDerechaAdelante;
    private javax.swing.JButton botonDerechaAtras;
    private javax.swing.JButton botonDetener;
    private javax.swing.JButton botonGiroDerecha;
    private javax.swing.JButton botonGiroIzquierda;
    private javax.swing.JButton botonIzquierdaAdelante;
    private javax.swing.JButton botonIzquierdaAtras;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
