/*
Clase para la visualizacion de la fusion de datos para su visualizacion y clasificacion supervisada
 */
package app.vista.graficas;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.Clase;
import app.modelo.entidades.Fusion;
import app.modelo.graficaxy.GraficaClase;
import app.modelo.graficaxyz.GraficaClase3D;
import java.util.List;

public class IGVerAprendizaje extends javax.swing.JFrame {

    
    private final Sesion sesion;
    private final List<Clase[]> fusionadosClasificados;
    private final List<Clase[]> fusionados;
    
    public IGVerAprendizaje(Sesion sesion, List<Clase[]> fusionadosClasificados, List<Clase[]> fusionados) {
        this.sesion = sesion;
        this.fusionadosClasificados = fusionadosClasificados;
        this.fusionados  =fusionados;
        initComponents();
        inicializar();
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

        MenuAceptar.setText("Salir");
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAceptarActionPerformed
        // Agregar k para la supervision
        this.setVisible(false);
        this.dispose();
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

    private void inicializar() {
        GraficaClase clase = new GraficaClase();
        GraficaClase3D clase3D = new GraficaClase3D();
        // Panel1
        panel1.removeAll();
        panel1.repaint();
        panel1.setLayout(new java.awt.BorderLayout());
        if(fusionados.get(0)[0].getDimension() == Fusion.DOS_DIMENSIONES){
            panel1.add(clase.crearChart(fusionadosClasificados.get(0), fusionados.get(0)[0].getNombre()));
        }
        else{
            panel1.add(clase3D.crearChart(fusionadosClasificados.get(0), fusionados.get(0)[0].getNombre(), fusionados.get(0)[0].getNombre()));
        }
        panel1.validate();
        // Panel1
        panel2.removeAll();
        panel2.repaint();
        panel2.setLayout(new java.awt.BorderLayout());
        if(fusionados.get(1)[0].getDimension() == Fusion.DOS_DIMENSIONES){
            panel2.add(clase.crearChart(fusionadosClasificados.get(1), fusionados.get(1)[0].getNombre()));
        }
        else{
            panel2.add(clase3D.crearChart(fusionadosClasificados.get(1), fusionados.get(1)[0].getNombre(), fusionados.get(1)[0].getNombre()));
        }
        panel2.validate();
        // Panel1
        panel3.removeAll();
        panel3.repaint();
        panel3.setLayout(new java.awt.BorderLayout());
        if(fusionados.get(2)[0].getDimension() == Fusion.DOS_DIMENSIONES){
            panel3.add(clase.crearChart(fusionadosClasificados.get(2), fusionados.get(2)[0].getNombre()));
        }
        else{
            panel3.add(clase3D.crearChart(fusionadosClasificados.get(2), fusionados.get(2)[0].getNombre(), fusionados.get(2)[0].getNombre()));
        }
        panel3.validate();
    }
}
