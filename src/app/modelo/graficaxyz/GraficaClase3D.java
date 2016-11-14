/*
Clase para graficar clase en tres dimensiones
 */
package app.modelo.graficaxyz;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.Colors;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.label.StandardXYZLabelGenerator;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

public class GraficaClase3D {

    public DemoPanel crearChart(Clase[] clases, String tituloChart, String descripcion) {
        DemoPanel content = new DemoPanel(new BorderLayout());
        Dimension dimension = new Dimension(1000, 600);
        content.setPreferredSize(dimension);
        XYZDataset dataset = crearDataSet(clases);
        Chart3D chart = crearChart3D(dataset, tituloChart, descripcion);
        Chart3DPanel chartPanel = new Chart3DPanel(chart);
        content.setChartPanel(chartPanel);
        chartPanel.zoomToFit(dimension);
        content.add(new DisplayPanel3D(chartPanel));
        return content;
    }

    private XYZDataset crearDataSet(Clase[] clases) {
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        for (Clase clase : clases) {
            XYZSeries s = new XYZSeries(clase.getNombre());
            List<Punto> puntos = clase.getPuntos();
            for (Punto punto : puntos) {
                s.add(punto.getX(), punto.getY(), punto.getZ());
            }
            dataset.add(s);
        }
        return dataset;
    }

    private Chart3D crearChart3D(XYZDataset dataset, String tituloChart, String descripcion) {
        Chart3D chart = Chart3DFactory.createScatterChart(tituloChart,
                descripcion, dataset, "X", "Y", "Z");
        XYZPlot plot = (XYZPlot) chart.getPlot();
        plot.setDimensions(new Dimension3D(10.0, 4.0, 4.0));
        plot.setLegendLabelGenerator(new StandardXYZLabelGenerator(
                StandardXYZLabelGenerator.COUNT_TEMPLATE));
        ScatterXYZRenderer renderer = (ScatterXYZRenderer) plot.getRenderer();
        renderer.setSize(0.15);
        renderer.setColors(Colors.createIntenseColors());
        chart.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40));
        return chart;
    }

}
