/*
Clasificador euclidiano de tres dimensiones
 */
package app.modelo.ia.clasificador;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.operaciones.TresDimensiones;

public class ClasificadorEuclidiano3D {

    private Clase[] clases;
    private Punto[] centroides;

    public ClasificadorEuclidiano3D() {
    }

    public ClasificadorEuclidiano3D(Clase[] clases) {
        this.clases = clases;
    }

    public ClasificadorEuclidiano3D(Clase[] clases, Punto[] centroides) {
        this.clases = clases;
        this.centroides = centroides;
    }

    public ClasificadorEuclidiano3D(Punto[] centroides) {
        this.centroides = centroides;
    }

    public int clasificar(Punto entrada) {
        //Metodo que primero calcula los centroides
        int pertence = -1;
        for (Clase clase : clases) {
            clase.setCentroide(TresDimensiones.centroide(clase.getPuntos()));
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

    public int clasificarConCentroide(Punto entrada) {
        // Los centroides ya estan establecidos
        int pertence = -1;
        double distanciaMinima = distancia(centroides[0], entrada);
        for (int i = 0; i < centroides.length; i++) {
            double distancia = distancia(centroides[i], entrada);
            if (distancia <= distanciaMinima) {
                distanciaMinima = distancia;
                pertence = i;
            }
        }
        return pertence;
    }

    private double distancia(Punto centroide, Punto entrada) {
        return Math.sqrt(Math.pow(centroide.getX() - entrada.getX(), 2) + Math.pow(centroide.getY() - entrada.getY(), 2) + Math.pow(centroide.getY() - entrada.getZ(), 2));
    }

    public Clase[] getClases() {
        return clases;
    }

    public void setClases(Clase[] clases) {
        this.clases = clases;
    }

    public Punto[] getCentroides() {
        return centroides;
    }

    public void setCentroides(Punto[] centroides) {
        this.centroides = centroides;
    }

}
