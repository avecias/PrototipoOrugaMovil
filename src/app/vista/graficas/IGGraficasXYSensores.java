
package app.vista.graficas;

import app.modelo.graficaxy.GraficaXY;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class IGGraficasXYSensores extends JFrame{

    private final GraficaXY graficaXY;
    
    public IGGraficasXYSensores(String title, GraficaXY graficaXY) throws HeadlessException {
        super(title);
        this.graficaXY = graficaXY;
        incializar();
    }
    
    private void incializar(){
        setLayout(new BorderLayout());
        setContentPane(graficaXY.mostrar());
        setPreferredSize(new Dimension(1000, 700));
        pack();
    }
}
