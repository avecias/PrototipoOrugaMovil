/*
Clasificador euclidiano a traves  de la distnacia euclidiana

 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClasificadorEuclidiano {
    
    private Clase[] clases;
    
    
    public static void main(String[] args) {
        System.out.println("Lista");
        List<Punto> puntos = new ArrayList<>();
        puntos.add( new Punto(1, 1.1, 0.34, 3.0));
        puntos.add( new Punto(2, 4.0, 0.56, 5.0));
        puntos.add( new Punto(3, 5.0, 4.30, 6.0));
        puntos.add( new Punto(4, 2.0, 5.0, 7.5));
        puntos.add( new Punto(5, 6.0, 6.7, 6.7));
        puntos.add( new Punto(6, 3.0, 1.1, 6.0));
        puntos.add( new Punto(7, 1.0, 3.1, 1.0));
        Collections.sort(puntos, new Comparator<Punto>() {
            @Override
            public int compare(Punto p1, Punto p2) {
                return new Double(p1.getZ()).compareTo(p2.getZ());
            }
        });
        for (Punto punto : puntos) {
            System.out.println(punto);
        }
    }
    
}
