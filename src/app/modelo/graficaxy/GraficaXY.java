/*
Solo un valor mostraddo
 */
package app.modelo.graficaxy;

import app.modelo.entidades.Lectura;
import app.modelo.entidades.Trama;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaXY {

    private XYPlot plot;
    private ChartPanel chartPanel;
    private JFreeChart chart;

    public GraficaXY() {

    }

    public ChartPanel crearChart(String nombre, String dimension, double[] valores) {
        XYSeries serie = new XYSeries(nombre);
        XYSeriesCollection dataset = new XYSeriesCollection();
        llenar(valores, serie);
        dataset.addSeries(serie);
        chart = ChartFactory.createXYLineChart(
                "Grafica de " + nombre, // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true,
                false
        );
        plot = chart.getXYPlot();
        plot.setDomainAxis(new NumberAxis("tiempo"));
        plot.setRangeAxis(new NumberAxis(dimension));
        chart.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.black);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        return new ChartPanel(chart);
    }

    private void llenar(double[] valores, XYSeries serie) {
        for (int i = 0; i < valores.length; i++) {
            serie.add(i, valores[i]);
        }
    }

}
