/*
Cuando la sesion no contenga parametros de la conexion con el puerto COM
o la misma conexion esta venta aparecera, de lo contrario no
 */
package app.vista.usuario;

import app.controlador.controlmovil.UsarControl;
import app.controlado.sesion.Sesion;
import app.modelo.comunicacion.serial.ConexionSerialImple;
import app.modelo.entidades.Parametro;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IGParametros extends javax.swing.JFrame {

    private Sesion sesion;
    private IGPrincipal principal; 
    
    public IGParametros(Sesion sesion, IGPrincipal principal) {
        this.sesion = sesion;
        this.principal = principal;
        initComponents();
        setIconImage(new ImageIcon("src/app/imagenes/icono.jpg").getImage());
        mostrarPuertos();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        comboCOM = new javax.swing.JComboBox();
        botonConectar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parametros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                cerrar(evt);
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

        jLabel6.setText("COM");

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelParametrosLayout = new javax.swing.GroupLayout(panelParametros);
        panelParametros.setLayout(panelParametrosLayout);
        panelParametrosLayout.setHorizontalGroup(
            panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(comboCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboParidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(botonConectar)
                .addContainerGap())
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
                    .addComponent(comboCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addComponent(botonConectar)
                .addContainerGap())
        );

        jLabel5.setText("Inserte parametros y conecte");
        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParametros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(panelParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        // Realizar la conexion al puerto COM
        obtenerTodosLosParametros();
    }//GEN-LAST:event_botonConectarActionPerformed

    private void cerrar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrar
        // Ventana cerrada
        System.out.println("Cerrado por el usuario");
        principal.setVisible(true);
    }//GEN-LAST:event_cerrar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectar;
    private javax.swing.JComboBox comboBaudios;
    private javax.swing.JComboBox comboCOM;
    private javax.swing.JComboBox comboDatos;
    private javax.swing.JComboBox comboParidad;
    private javax.swing.JComboBox comboParo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel panelParametros;
    // End of variables declaration//GEN-END:variables

    private void mostrarPuertos() {
        //Mostrar todos los puertos disponible para poder seleccionar uno
        Object[] puertos = ConexionSerialImple.puertosDisponibles();
        for (Object puerto : puertos) {
            comboCOM.addItem(puerto);
        }
    }

    private void obtenerTodosLosParametros() {
        //Obtener todos los parametros y subirlos a la sesion
        if (comboCOM.getComponentCount() < 0) {
            JOptionPane.showMessageDialog(null, "No hay ningun puerto disponible","Ningun Puerto",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String com = String.valueOf(comboCOM.getSelectedItem());
        int baudios = Integer.valueOf("" + comboBaudios.getSelectedItem());
        int paro = comboParo.getSelectedIndex() + 1;
        int datos = Integer.valueOf("" + comboDatos.getSelectedItem());
        int paridad = comboParidad.getSelectedIndex();
        Parametro parametro = new Parametro(com, baudios, datos, paro, paridad);
        System.out.println(parametro);
        UsarControl.conectarYUsar(sesion, parametro, principal);
    }
}
