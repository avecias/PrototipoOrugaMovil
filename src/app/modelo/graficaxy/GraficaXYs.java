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

public class GraficaXYs{

    private final XYSeries serieTemperatura;
    private final XYSeries serieGas;
    private final XYSeries serieHumo;
    private final XYSeries serieLlamaFuego;
    private final XYSeries serieSonido;
    private final XYSeries enconder;
    private final XYSeriesCollection dataset;
    private final Lectura lectura;

    public GraficaXYs(Lectura lectura) {
        this.lectura = lectura;
        serieTemperatura = new XYSeries("Temperatura");
        serieGas = new XYSeries("Gas");
        serieHumo = new XYSeries("Humo");
        serieLlamaFuego = new XYSeries("Lllama de Fuego");
        serieSonido = new XYSeries("Sonido");
        enconder = new XYSeries("Encoder");
        dataset = new XYSeriesCollection();
    }


    public ChartPanel mostrar() {
        llenar();
        dataset.addSeries(serieTemperatura);
        dataset.addSeries(serieGas);
        dataset.addSeries(serieHumo);
        dataset.addSeries(serieLlamaFuego);
        dataset.addSeries(serieSonido);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Valores Digitales directamente del archivo", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true,
                false
        );
        final XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis( new NumberAxis("tiempo"));
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
            serieTemperatura.add(i, trama.getTemperatura());
            serieGas.add(i, trama.getGas());
            serieHumo.add(i, trama.getHumo());
            serieLlamaFuego.add(i, trama.getLlama());
            serieSonido.add(i, trama.getSonido());
            enconder.add(i, trama.getEncoder());
        }
    }
    

}
