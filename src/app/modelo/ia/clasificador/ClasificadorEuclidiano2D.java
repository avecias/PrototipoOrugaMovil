/*
Clasificador euclidiano a traves  de la distnacia euclidiana

 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.operaciones.DosDimensiones;
import java.util.ArrayList;
import java.util.List;

public class ClasificadorEuclidiano2D {
    
    private final Clase[] clases;

    public ClasificadorEuclidiano2D(Clase[] clases) {
        this.clases = clases;
    }
    
    public int clasificar(Punto entrada){
        //Calcular los centroides de cada clase
        int pertence = -1;
        for (Clase clase : clases) {
            clase.setCentroide(DosDimensiones.centroide(clase.getPuntos()));
        }
        double distanciaMinima = distancia(clases[0].getCentroide(), entrada);
        for (int i = 0; i < clases.length; i++) {
            double distancia = distancia(clases[i].getCentroide(),entrada);
            if(distancia <= distanciaMinima){
                distanciaMinima = distancia;
                pertence = i;
            }
        }
        return pertence;
    }
    
    private double distancia(Punto centroide, Punto entrada) {
        return Math.sqrt(Math.pow(centroide.getX() - entrada.getX(), 2) + Math.pow(centroide.getY() - entrada.getY(),2));
    }
    
    public static void main(String[] args) {
        System.out.println("Distancia euclidiana");
        List<Punto> puntos1 = new ArrayList<>();
        puntos1.add( new Punto(1, 1.1, 0.34));
        puntos1.add( new Punto(2, 2.0, -1.56));
        puntos1.add( new Punto(3, 0.0, 2.30));
        puntos1.add( new Punto(4, 0.80, 1.1));
        puntos1.add( new Punto(5, -1.0, 0.0));
        
        List<Punto> puntos2 = new ArrayList<>();
        puntos2.add( new Punto(1, 11, 10));
        puntos2.add( new Punto(2, 8, 12));
        puntos2.add( new Punto(3, 9, 11));
        puntos2.add( new Punto(4, 11, 11.2));
        puntos2.add( new Punto(5, 10.1, 9.8));
        
        Clase c1 = new Clase("Primera", puntos1);
        Clase c2 = new Clase("Segunda", puntos2);
        
        Clase[] clases = {c1,c2};
        Punto vectorEntrada = new Punto(1, 1.0, 1.0);
        System.out.println("Vector de entrada " + vectorEntrada);
        System.out.println("Pertenece a la clase " + clases[new ClasificadorEuclidiano2D(clases).clasificar(vectorEntrada)].getNombre());
        for (Clase clase : clases) {
            System.out.println(clase.getCentroide());
        }
        
        //Collections.sort(puntos1, new ComparadorY());
    }
    
}
