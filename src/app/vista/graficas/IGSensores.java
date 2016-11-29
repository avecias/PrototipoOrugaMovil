/*
Mostrar todos los sensores linealizados
 */
package app.vista.graficas;

import app.modelo.entidades.SensoresConvercion;
import app.modelo.graficaxy.GraficaXY;
import app.modelo.graficaxy.GraficaXYs;

public class IGSensores extends javax.swing.JFrame {

    private final GraficaXYs graficaXY;
    private final SensoresConvercion sensores;
    private GraficaXY xy;
    
    public IGSensores(GraficaXYs graficaXY, SensoresConvercion sensores) {
        this.graficaXY = graficaXY;
        this.sensores  = sensores;
        xy = new GraficaXY();
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
        panel4 = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        MenuSalir = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Los sensores");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab(" Digital", panel1);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab("Temperatura", panel2);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab("Gas", panel3);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab("Humo", panel4);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab("Llama de fuego", panel5);

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        tabPanel.addTab("Sonido", panel6);

        menuArchivo.setText("Archivo");

        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(MenuSalir);

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

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        // Agregar k para la supervision
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_MenuSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        // Panel 1
        panel1.removeAll();
        panel1.repaint();
        panel1.setLayout(new java.awt.BorderLayout());
        panel1.add(graficaXY.mostrar());
        panel1.validate();
        // panel2
        panel2.removeAll();
        panel2.repaint();
        panel2.setLayout(new java.awt.BorderLayout());
        panel2.add(xy.crearChartTemperatura("Temperatura","Grados Centigrados", sensores.getTemperatura()));
        panel2.validate();
        // panel3
        panel3.removeAll();
        panel3.repaint();
        panel3.setLayout(new java.awt.BorderLayout());
        panel3.add(xy.crearChartGas("Gas","Partes Por Millon", sensores.getGas()));
        panel3.validate();
        // panel4
        panel4.removeAll();
        panel4.repaint();
        panel4.setLayout(new java.awt.BorderLayout());
        panel4.add(xy.crearChart("Humo","Partes Por Millon", sensores.getHumo()));
        panel4.validate();
        // panel5
        panel5.removeAll();
        panel5.repaint();
        panel5.setLayout(new java.awt.BorderLayout());
        panel5.add(xy.crearChart("Llama de Fuego","Digital", sensores.getLlama()));
        panel5.validate();
        // panel6
        panel6.removeAll();
        panel6.repaint();
        panel6.setLayout(new java.awt.BorderLayout());
        panel6.add(xy.crearChart("Sonido","Digital", sensores.getSonido()));
        panel6.validate();
    }
}
