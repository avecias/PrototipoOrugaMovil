/*
Prueba del clasificador
 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.graficaxy.GraficaClase;
import app.modelo.ia.kmeans.Kmeans;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Prueba {

    public static void main(String[] args) {
        Random random = new Random();
        List<Punto> puntos1 = new ArrayList<>();
        List<Punto> puntos2 = new ArrayList<>();
        List<Punto> clasificar = new ArrayList<>();

        List<Punto> centroide1 = new ArrayList<>();
        List<Punto> centroide2 = new ArrayList<>();
        int dispercion1 = 20, dispercion2 = 15;

        //Llenar aleatoreamente las 2 clases
        for (int i = 0; i < 100; i++) {
            double x1 = dispercion1 * random.nextGaussian() + 10;
            double y1 = dispercion1 * random.nextGaussian() + 10;
            double z1 = dispercion1 * random.nextGaussian() + 10;
            double x2 = dispercion2 * random.nextGaussian() + 100;
            double y2 = dispercion2 * random.nextGaussian() + 100;
            double z2 = dispercion2 * random.nextGaussian() + 100;
            puntos1.add(new Punto(i, x1, y1, z1));
            puntos2.add(new Punto(i, x2, y2, z2));
            clasificar.add(puntos1.get(i));
            clasificar.add(puntos2.get(i));
        }

        Punto vectorEntrada = new Punto(1, 10.0, 50.0);
        List<Punto> entrada = new ArrayList<>();
        entrada.add(vectorEntrada);

        Clase c1 = new Clase("Primera", puntos1);
        Clase c2 = new Clase("Segunda", puntos2);
        Clase c3 = new Clase("Vector de Entrada", entrada);
        Clase[] clases = {c1, c2};
        System.out.println("Pertenece a la clase " + clases[new ClasificadorEuclidiano2D(clases).clasificar(vectorEntrada)].getNombre());
        
        GraficaClase gc = new GraficaClase();
        
        centroide1.add(c1.getCentroide());
        centroide2.add(c2.getCentroide());
        Clase[] clasesG = {c1, c2, c3, new Clase("Centroide1", centroide1), new Clase("Centroide2", centroide2)};
        
        
        JFrame frame = new JFrame("Clasificador");
        frame.setContentPane(gc.crearChart(clasesG, "Pruebas previas"));
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Collections.sort(puntos1, new ComparadorY());
        JFrame frame2 = new JFrame("Sin clasificar");
        frame2.setContentPane(gc.crearChart(new Clase[]{new Clase("Sin", clasificar)}, "Datos sin agrupar"));
        frame2.setPreferredSize(new Dimension(1000, 700));
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        Clase[] clasificado = new Kmeans(clasificar, 2).calcular();
        JFrame frame3 = new JFrame("Clasificados");
        frame3.setContentPane(gc.crearChart(clasificado, "Clasificados por K-means"));
        frame3.setPreferredSize(new Dimension(1000, 700));
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.pack();
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);

    }

}
