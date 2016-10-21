/*
Prueba del clasificador
 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.graficaxy.GraficaClase;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Prueba {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextGaussian());
        List<Punto> puntos1 = new ArrayList<>();
        puntos1.add(new Punto(1, 1.1, 0.34));
        puntos1.add(new Punto(2, 2.0, -1.56));
        puntos1.add(new Punto(3, 0.0, 2.30));
        puntos1.add(new Punto(4, 0.80, 1.1));
        puntos1.add(new Punto(5, -1.0, 0.0));

        List<Punto> puntos2 = new ArrayList<>();
        puntos2.add(new Punto(1, 11, 10));
        puntos2.add(new Punto(2, 8, 12));
        puntos2.add(new Punto(3, 9, 11));
        puntos2.add(new Punto(4, 11, 11.2));
        puntos2.add(new Punto(5, 10.1, 9.8));

        Punto vectorEntrada = new Punto(1, 5.0, 5.0);
        List<Punto> entrada = new ArrayList<>();
        entrada.add(vectorEntrada);
        
        Clase c1 = new Clase("Primera", puntos1);
        Clase c2 = new Clase("Segunda", puntos2);
        Clase c3 = new Clase("Vector de Entrada", entrada);
        
        Clase[] clases = {c1, c2, c3};
        
        System.out.println("Pertenece a la clase " + clases[new ClasificadorEuclidiano2D(clases).clasificar(vectorEntrada)].getNombre());
        for (Clase clase : clases) {
            System.out.println(clase);
        }
        
        JFrame frame = new JFrame("Clasificador");
        frame.setContentPane(new GraficaClase().crearChart(clases));
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        //Collections.sort(puntos1, new ComparadorY());
    }

}
