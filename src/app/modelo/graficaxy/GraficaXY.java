package app.modelo.graficaxy;


import app.modelo.entidades.Lectura;
import app.modelo.entidades.Trama;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaXY{

    private final XYSeries s1;
    private final XYSeries s2;
    private final XYSeries s3;
    private final XYSeries s4;
    private final XYSeries enconder;
    private final XYSeriesCollection dataset;
    private final Lectura lectura;

    public GraficaXY(Lectura lectura) {
        this.lectura = lectura;
        s1 = new XYSeries("Sensor A");
        s2 = new XYSeries("Sensor B");
        s3 = new XYSeries("Sensor C");
        s4 = new XYSeries("Sensor D");
        enconder = new XYSeries("Encoder");
        dataset = new XYSeriesCollection();
    }


    public ChartPanel mostrar() {
        System.out.println("Mostrar");
        llenar();
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
        //final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        return new ChartPanel(chart);
    }

    private void llenar() {
        List<Trama> tramas = lectura.getTramas();
        for (int i = 0; i < tramas.size(); i++) {
            Trama trama = tramas.get(i);
            s1.add(i, trama.getSensorA());
            s2.add(i, trama.getSensorB());
            s3.add(i, trama.getSensorC());
            s4.add(i, trama.getSensorD());
            enconder.add(i, trama.getEncoder());
        }
    }
    

}
