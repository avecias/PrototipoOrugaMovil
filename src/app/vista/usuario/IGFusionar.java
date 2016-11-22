/*
Subir a la seccion como se fucionan los datos
 */
package app.vista.usuario;

import app.controlado.aprender.Aprender;
import app.controlado.sesion.Sesion;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

public class IGFusionar extends javax.swing.JFrame {

    private final JComboBox<String>[][] comboBoxs;
    private final Aprender aprender;
    private final Sesion sesion;
    JMenuItem menuClasificar;
    
    public IGFusionar(Sesion sesion, JMenuItem menuClasificar) {
        initComponents();
        comboBoxs = new JComboBox[][]{
            {combo1c1,combo2c1,combo3c1},{combo1c2,combo2c2,combo3c2},{combo1c3,combo2c3,combo3c3}
        };
        aprender = new Aprender();
        this.sesion = sesion;
        this.menuClasificar = menuClasificar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo1c1 = new javax.swing.JComboBox<>();
        combo2c1 = new javax.swing.JComboBox<>();
        combo3c1 = new javax.swing.JComboBox<>();
        combo1c2 = new javax.swing.JComboBox<>();
        combo2c2 = new javax.swing.JComboBox<>();
        combo3c2 = new javax.swing.JComboBox<>();
        combo1c3 = new javax.swing.JComboBox<>();
        combo2c3 = new javax.swing.JComboBox<>();
        combo3c3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fucionar Datos");

        jLabel1.setText("Fusinar Datos para Poder Almacenarlos en Aprendizaje");

        jLabel2.setText("Clasificacion 1");

        jLabel3.setText("Clasificacion 2");

        jLabel4.setText("Clasificacion 3");

        combo1c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo2c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo3c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo1c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo2c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo3c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo1c3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo2c3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        combo3c3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Temperatura", "Gas", "Humo", "Fuego", "Sonido" }));

        jLabel5.setText("Si no se selecciona una combinancion esta quedará vacia");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAceptar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(combo1c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(combo2c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(combo3c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(41, 41, 41)
                                .addComponent(combo1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(combo2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo3c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(combo1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(combo2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo3c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo3c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo3c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo1c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo3c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(botonAceptar))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // Validar la informacion para poder crear el objeto
        aprender.guardarFusion(sesion, comboBoxs, this,menuClasificar);
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> combo1c1;
    private javax.swing.JComboBox<String> combo1c2;
    private javax.swing.JComboBox<String> combo1c3;
    private javax.swing.JComboBox<String> combo2c1;
    private javax.swing.JComboBox<String> combo2c2;
    private javax.swing.JComboBox<String> combo2c3;
    private javax.swing.JComboBox<String> combo3c1;
    private javax.swing.JComboBox<String> combo3c2;
    private javax.swing.JComboBox<String> combo3c3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
