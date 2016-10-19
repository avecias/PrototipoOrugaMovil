/*
Clasificador euclidiano a traves  de la distnacia euclidiana

 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.operaciones.DosDimensiones;

public class ClasificadorEuclidiano2D {

    private final Clase[] clases;

    public ClasificadorEuclidiano2D(Clase[] clases) {
        this.clases = clases;
    }

    public int clasificar(Punto entrada) {
        //Calcular los centroides de cada clase
        int pertence = -1;
        for (Clase clase : clases) {
            clase.setCentroide(DosDimensiones.centroide(clase.getPuntos()));
        }
        double distanciaMinima = distancia(clases[0].getCentroide(), entrada);
        for (int i = 0; i < clases.length; i++) {
            double distancia = distancia(clases[i].getCentroide(), entrada);
            if (distancia <= distanciaMinima) {
                distanciaMinima = distancia;
                pertence = i;
            }
        }
        return pertence;
    }

    private double distancia(Punto centroide, Punto entrada) {
        return Math.sqrt(Math.pow(centroide.getX() - entrada.getX(), 2) + Math.pow(centroide.getY() - entrada.getY(), 2));
    }

}
