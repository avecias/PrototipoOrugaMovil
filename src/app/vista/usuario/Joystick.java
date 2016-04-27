package app.vista.usuario;

import app.controlador.control.Movimiento;
import java.awt.Color;

public class Joystick extends javax.swing.JFrame {

    private final Movimiento movimiento;
    private Integer baudios, bits, paro, parida;
    private String COMM;

    public Joystick() {
        initComponents();
        movimiento = new Movimiento();
        inicializar();
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
        panelParametros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBaudios = new javax.swing.JComboBox();
        comboDatos = new javax.swing.JComboBox();
        comboParo = new javax.swing.JComboBox();
        comboParidad = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboCOMM = new javax.swing.JComboBox();
        estado = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuConectar = new javax.swing.JMenuItem();
        menuDesconectar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Joystick");
        setFocusCycleRoot(false);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                haber(evt);
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

        panelParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel1.setText("Baudios:");

        jLabel2.setText("Bits de Datos:");

        jLabel3.setText("Paridad");

        jLabel4.setText("Bit de paro: ");

        comboBaudios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "110", "300", "600", "1200", "4800", "9600", "14400", "19200", "38400", "57600", "115200", "128000", "256000" }));
        comboBaudios.setSelectedIndex(5);
        comboBaudios.setToolTipText("");

        comboDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "6", "7", "8" }));
        comboDatos.setSelectedIndex(3);

        comboParo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "1.5" }));

        comboParidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ninguna", "impar", "par", "marca", "spacio" }));

        jLabel6.setText("COMM");

        javax.swing.GroupLayout panelParametrosLayout = new javax.swing.GroupLayout(panelParametros);
        panelParametros.setLayout(panelParametrosLayout);
        panelParametrosLayout.setHorizontalGroup(
            panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBaudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboCOMM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelParametrosLayout.createSequentialGroup()
                        .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelParametrosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54)
                                .addComponent(comboParidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelParametrosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(comboParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelParametrosLayout.setVerticalGroup(
            panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBaudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboParidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCOMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        estado.setText("Desconectado");

        menuArchivo.setText("Archivo");

        menuConectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/icon_usb.gif"))); // NOI18N
        menuConectar.setText("Conectar");
        menuConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConectarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuConectar);

        menuDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/stop32.png"))); // NOI18N
        menuDesconectar.setText("Desconectar");
        menuDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDesconectarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuDesconectar);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/imagenes/exit.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        menu.add(menuArchivo);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonIzquierdaAtras)
                            .addComponent(botonIzquierdaAdelante))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(botonDetener))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(botonAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonDerechaAtras)
                            .addComponent(botonDerechaAdelante)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(botonGiroIzquierda)
                        .addGap(10, 10, 10)
                        .addComponent(panelParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botonGiroDerecha)))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addComponent(estado)
                .addGap(370, 370, 370))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(botonIzquierdaAdelante)
                .addGap(26, 26, 26)
                .addComponent(botonIzquierdaAtras)
                .addGap(26, 26, 26)
                .addComponent(botonGiroIzquierda)
                .addGap(13, 13, 13)
                .addComponent(estado))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonAdelante, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(botonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonDetener))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(panelParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(botonDerechaAdelante)
                        .addGap(21, 21, 21)
                        .addComponent(botonDerechaAtras)
                        .addGap(19, 19, 19)
                        .addComponent(botonGiroDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void haber(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_haber
        // TODO add your handling code here:
        if (evt.getWheelRotation() < 0) {
            System.out.println("arriba");
            movimiento.adelante();
        } else {
            System.out.println("abajo");
            movimiento.atras();
        }
    }//GEN-LAST:event_haber

    private void menuConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConectarActionPerformed
        // TODO add your handling code here:
        if (comboCOMM.getComponentCount() > 0) {
            COMM = String.valueOf(comboCOMM.getSelectedItem());
            baudios = Integer.valueOf(String.valueOf(comboBaudios.getSelectedItem()));
            bits = Integer.valueOf(String.valueOf(comboDatos.getSelectedItem()));
            paro = Integer.valueOf(String.valueOf(comboParo.getSelectedItem()));
            parida = comboParidad.getSelectedIndex();
            if (movimiento.conectar(COMM, baudios, bits, paro, parida)) {
                habilitar(true);
                estado.setText("Conectado");
            } else {
                estado.setForeground(Color.red);
                estado.setText("Error al conectar");
            }
        } else {
            estado.setText("No hay puertos COM");
        }
    }//GEN-LAST:event_menuConectarActionPerformed

    private void menuDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDesconectarActionPerformed
        // TODO add your handling code here:
        if (movimiento.desconectar()) {
            estado.setText("Desconectado");
            habilitar(false);
        } else {
            estado.setForeground(Color.red);
            estado.setText("Error al desconectar");
        }
    }//GEN-LAST:event_menuDesconectarActionPerformed

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
    private javax.swing.JComboBox comboBaudios;
    private javax.swing.JComboBox comboCOMM;
    private javax.swing.JComboBox comboDatos;
    private javax.swing.JComboBox comboParidad;
    private javax.swing.JComboBox comboParo;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuConectar;
    private javax.swing.JMenuItem menuDesconectar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelParametros;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        //Inicializa todo en la ventana del joystick
        movimiento.puertosDisponibles(comboCOMM);
        menuDesconectar.setEnabled(false);
        botonAdelante.setEnabled(false);
        botonAtras.setEnabled(false);
        botonDerechaAdelante.setEnabled(false);
        botonDerechaAtras.setEnabled(false);
        botonDetener.setEnabled(false);
        botonGiroDerecha.setEnabled(false);
        botonGiroIzquierda.setEnabled(false);
        botonIzquierdaAdelante.setEnabled(false);
        botonIzquierdaAtras.setEnabled(false);
    }

    private void habilitar(boolean b) {
        menuConectar.setEnabled(!b);
        menuDesconectar.setEnabled(b);
        botonAdelante.setEnabled(b);
        botonAtras.setEnabled(b);
        botonDerechaAdelante.setEnabled(b);
        botonDerechaAtras.setEnabled(b);
        botonDetener.setEnabled(b);
        botonGiroDerecha.setEnabled(b);
        botonGiroIzquierda.setEnabled(b);
        botonIzquierdaAdelante.setEnabled(b);
        botonIzquierdaAtras.setEnabled(b);
    }
}
