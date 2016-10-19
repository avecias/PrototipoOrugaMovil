/*
Graficar las clases en dos dimensiones
 */
package app.modelo.graficaxy;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class GraficaClase {

    private JFreeChart chart;
    private ChartPanel chartPanel;
    private XYPlot plot;

    public ChartPanel crearChart(Clase[] clases) {
        XYDataset dataset = crearDataSet(clases);
        chart = ChartFactory.createScatterPlot("Agrupamiento",
                "Eje X", "Eje Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        plot = (XYPlot) chart.getPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(true);
        plot.setRangeCrosshairVisible(true);
        plot.setRangeCrosshairLockedOnData(true);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    private XYDataset crearDataSet(Clase[] clases) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        for (Clase clase : clases) {
            //Setear todos los valores para agregarlos a la base de datos
            List<Punto> puntos = clase.getPuntos();
            double[] x = new double[puntos.size()];
            double[] y = new double[puntos.size()];
            for (int j = 0; j < puntos.size(); j++) {
                //Llenar por clase
                x[j] = puntos.get(j).getX();
                y[j] = puntos.get(j).getY();
            }
            dataset.addSeries(clase.getNombre(), new double[][]{x, y});
        }
        return dataset;
    }

}
