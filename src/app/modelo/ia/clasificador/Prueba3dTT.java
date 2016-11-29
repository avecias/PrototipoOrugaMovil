/*
Prueba del TT
 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.graficaxyz.GraficaClase3D;
import app.modelo.ia.kmeans.Kmeans3D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Prueba3dTT {
    
    public static void main(String[] args) {
        // Inicio de la prueba
        Random random = new Random();
        List<Punto> clasificar3D = new ArrayList<>();
        // Poder visualizar los centroides
        int dispercion1 = 50, dispercion2 = 60;

        //Llenar aleatoreamente las 2 clases
        for (int i = 0; i < 100; i++) {
            double x1 = dispercion1 * random.nextGaussian() + 10;
            double y1 = dispercion1 * random.nextGaussian() + 10;
            double z1 = dispercion1 * random.nextGaussian() + 10;
            double x2 = dispercion2 * random.nextGaussian() + 500;
            double y2 = dispercion2 * random.nextGaussian() + 500;
            double z2 = dispercion2 * random.nextGaussian() + 500;
            double x3 = dispercion2 * random.nextGaussian() + 1000;
            double y3 = dispercion2 * random.nextGaussian() + 1000;
            double z3 = dispercion2 * random.nextGaussian() + 1000;
            clasificar3D.add(new Punto(i, x1, y1, z1));
            clasificar3D.add(new Punto(i, x2, y2, z2));
            clasificar3D.add(new Punto(i, x3, y3, z3));
        }
        
        Punto vectorEntrada = new Punto(1, 700.0, 700.0, 700.0);
        List<Punto> entrada = new ArrayList<>();
        entrada.add(vectorEntrada);
        
        
        Clase[] clasificado = new Kmeans3D(clasificar3D, 3).calcular();
        Clase c1 = new Clase("Vector de Entrada", entrada);
        Clase[] clasesG = new Clase[]{clasificado[0],clasificado[1],clasificado[2],c1};
        // Clasificacion del vector de entrada
        System.out.println("Pertenece a la clase " + clasificado[new ClasificadorEuclidiano3D(clasificado).clasificar(vectorEntrada)].getNombre());
        
        // Objeto para crear paneles para graficar 
        GraficaClase3D gc = new GraficaClase3D();
        
        // Grafica en 3d de distancia minima
        JFrame frame1 = new JFrame("3D");
        frame1.setContentPane(gc.crearChart(clasesG, "Clases en 3D", "Clases mostradas en 3d y clasificador de distancia minima"));
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        
        // Grafica en 3d de puntos sin clasificar
        JFrame frame2 = new JFrame("Sin Clasificar en 3D");
        frame2.setContentPane(gc.crearChart(new Clase[]{new Clase("Sin", clasificar3D)}, "Clases sin Clasificar en 3D", "Clases mostradas en 3d y clasificador de distancia minima"));
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        
        // Prueba de la clasificacionen 3d
        JFrame frame3 = new JFrame("Clasificados");
        frame3.setContentPane(gc.crearChart(clasificado, "Clasificados por K-means","Clasificacion por k-meas"));
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.pack();
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }
}
