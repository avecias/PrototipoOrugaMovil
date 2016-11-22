//Ventana Inicial del programa para poder realizar todas las operaciones basicas del software
package app.vista.usuario;

import app.controlador.archivo.CargarArchivo;
import app.controlador.controlmovil.UsarControl;
import app.controlado.sesion.Sesion;
import app.controlado.aprender.Aprender;
import app.controlado.aprender.Supervisar;
import app.controlador.grafica.Graficar;
import app.modelo.ia.clasificador.Prueba;
import app.modelo.ia.clasificador.PruebaKmeans3D;
import javax.swing.ImageIcon;

public class IGPrincipal extends javax.swing.JFrame {

    private final Sesion sesion;
    private final Graficar graficar;
    private final UsarControl usarControl;
    private final Aprender aprender;
    private final Supervisar supervisar;
    
    public IGPrincipal(Sesion sesion) {
        this.sesion = sesion;
        initComponents();
        icono();
        graficar = new Graficar();
        usarControl = new UsarControl();
        aprender = new Aprender();
        supervisar = new Supervisar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        pie = new javax.swing.JPanel();
        etiquetaEstado = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        botonVerGraficas = new javax.swing.JButton();
        pieTabla = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        menuControl = new javax.swing.JMenu();
        menuJoystick = new javax.swing.JMenuItem();
        menuCargar = new javax.swing.JMenu();
        menuAbrirArchivo = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuFusionar = new javax.swing.JMenuItem();
        menuClasificar = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenuItem();
        menuResultado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prototipo de Robot Oruga Movil");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Nombre", "Fecha", "Nombre Original"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(50);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(75);
            tabla.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        etiquetaEstado.setText("Estado de la conexion");

        javax.swing.GroupLayout pieLayout = new javax.swing.GroupLayout(pie);
        pie.setLayout(pieLayout);
        pieLayout.setHorizontalGroup(
            pieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pieLayout.createSequentialGroup()
                .addComponent(etiquetaEstado)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pieLayout.setVerticalGroup(
            pieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pieLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(etiquetaEstado))
        );

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("Tabla de archivos cargados en esta sesion");

        botonVerGraficas.setText("Ver Graficas");
        botonVerGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerGraficasActionPerformed(evt);
            }
        });

        pieTabla.setText("Archivos cargados (0)");

        menuArchivo.setText("Archivo");

        menuLimpiar.setText("Limpiar");
        menuArchivo.add(menuLimpiar);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        menuBarra.add(menuArchivo);

        menuControl.setText("Control");

        menuJoystick.setText("Joystick");
        menuJoystick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJoystickActionPerformed(evt);
            }
        });
        menuControl.add(menuJoystick);

        menuBarra.add(menuControl);

        menuCargar.setText("Cargar");

        menuAbrirArchivo.setText("Archivo");
        menuAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirArchivoActionPerformed(evt);
            }
        });
        menuCargar.add(menuAbrirArchivo);

        menuBarra.add(menuCargar);

        jMenu1.setText("Aprendizaje");

        menuFusionar.setText("Fusionar Datos");
        menuFusionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFusionarActionPerformed(evt);
            }
        });
        jMenu1.add(menuFusionar);

        menuClasificar.setText("Clasificar Con Supervision");
        menuClasificar.setEnabled(false);
        menuClasificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClasificarActionPerformed(evt);
            }
        });
        jMenu1.add(menuClasificar);

        menuVer.setText("Ver Aprendizaje");
        menuVer.setEnabled(false);
        menuVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerActionPerformed(evt);
            }
        });
        jMenu1.add(menuVer);

        menuResultado.setText("Resultado");
        menuResultado.setEnabled(false);
        menuResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResultadoActionPerformed(evt);
            }
        });
        jMenu1.add(menuResultado);

        menuBarra.add(jMenu1);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pieTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonVerGraficas)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pieTabla)
                    .addComponent(botonVerGraficas))
                .addGap(40, 40, 40)
                .addComponent(pie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuJoystickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJoystickActionPerformed
        // TODO add your handling code here:
        usarControl.hacer(sesion,this);
    }//GEN-LAST:event_menuJoystickActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // Salir de toda la aplicacion
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirArchivoActionPerformed
        // TODO add your handling code here:
        CargarArchivo.hacer(sesion, tabla, pieTabla);
    }//GEN-LAST:event_menuAbrirArchivoActionPerformed

    private void botonVerGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerGraficasActionPerformed
        // Ver en otra venta las graficas del archivo cargado
        graficar.hacer(this, sesion, tabla);
    }//GEN-LAST:event_botonVerGraficasActionPerformed

    private void menuFusionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFusionarActionPerformed
        // Interfaz de la fucion de datos y almacenarlos
        aprender.fusionar(sesion, tabla,menuClasificar);
    }//GEN-LAST:event_menuFusionarActionPerformed

    private void menuClasificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClasificarActionPerformed
        // Si se ha subido a session el tipo de fusion de datos se puede ver los datos
        supervisar.mostrar(menuVer,sesion, tabla);
//        System.out.println(sesion.getFusion());
//        PruebaKmeans3D.main(new String[]{""});
//        Prueba.main(new String[]{""});
    }//GEN-LAST:event_menuClasificarActionPerformed

    private void menuVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerActionPerformed
        // Ver el aprendizaje
        aprender.verAprendizaje(sesion,menuResultado);
    }//GEN-LAST:event_menuVerActionPerformed

    private void menuResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResultadoActionPerformed
        // Comparar resultados
        
    }//GEN-LAST:event_menuResultadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVerGraficas;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuAbrirArchivo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuCargar;
    private javax.swing.JMenuItem menuClasificar;
    private javax.swing.JMenu menuControl;
    private javax.swing.JMenuItem menuFusionar;
    private javax.swing.JMenuItem menuJoystick;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuResultado;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuVer;
    private javax.swing.JPanel pie;
    private javax.swing.JLabel pieTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void icono() {
        setIconImage(new ImageIcon("src/app/imagenes/icono.jpg").getImage());
    }
}
