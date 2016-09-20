package app.vista.graficas;

import app.modelo.comunicacion.SD.Archivo;
import app.modelo.comunicacion.SD.Lectura;
import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class GraficaXY extends ApplicationFrame {

    final XYSeries s1 = new XYSeries("Sensor 1");
    final XYSeries s2 = new XYSeries("Sensor 2");
    final XYSeries s3 = new XYSeries("Sensor 3");
    final XYSeries s4 = new XYSeries("Sensor 4");
    final XYSeries enconder = new XYSeries("Encoder");
    final XYSeriesCollection dataset = new XYSeriesCollection();

    public GraficaXY(String title) {
        super(title);
    }

    public void mostrar(Archivo archivo) {
        llenar(archivo);
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        dataset.addSeries(s4);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Prueba de Robot Movil", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true,
                false
        );
        final XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis( new NumberAxis("muestras"));
        plot.setRangeAxis(new NumberAxis("valor"));
        chart.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.black);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }

    private void llenar(Archivo archivo) {
        ArrayList<ArrayList<Lectura>> listaLecturas = archivo.getLecturas();
        ArrayList<Lectura> lecturas = listaLecturas.get(0);
        for (int i = 0; i < lecturas.size(); i++) {
            Lectura lectura = lecturas.get(i);
            s1.add(i, lectura.getSensor1());
            s2.add(i, lectura.getSensor2());
            s3.add(i, lectura.getSensor3());
            s4.add(i, lectura.getSensor4());
            enconder.add(i, lectura.getSensor1());
        }
    }
}
