/*
Algortimo de agrupamiento por K-means
condicion de k impar y mayor a 3
 */
package app.modelo.ia.kmeans;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.ia.clasificador.ClasificadorEuclidiano2D;
import java.util.Arrays;
import java.util.List;

public class Kmeans {

    private List<Punto> bancoDeDatos;
    private int k;
    private Clase[] clases;
    private Punto[] centroides;
    private Punto[] centroidesAnteriores;
    private ClasificadorEuclidiano2D clasificador;

    public Kmeans(List<Punto> bancoDeDatos, int k) {
        this.bancoDeDatos = bancoDeDatos;
        this.k = k;
        //Inicializar clases con el tamaño de K
        clases = new Clase[k];
        centroides = new Punto[k];
    }

    // Metodo para el calculo 
    public Clase[] calcular() {
        //Inicializar los parametros
        inicializar();
        //Condicion de Paro
        while (!sonCentrosIguales()) {
            // Si los centros son iguales se rompe el ciclo
            centroides = centroidesAnteriores;
            for (Punto bancoDeDato : bancoDeDatos) {
                //
            }
        }
        return clases;
    }

    private void inicializar() {
        for (int i = 0; i < k; i++) {
            //Le damos el centro a los primeros elemento del banco de datos
            centroides[i] = bancoDeDatos.get(i);
            centroides[i].setIdPunto(-1);
            centroidesAnteriores[i] = new Punto(-1, 0.0);
        }
    }

    private boolean sonCentrosIguales() {
        return Arrays.equals(centroides, centroidesAnteriores);
    }

    public List<Punto> getBancoDeDatos() {
        return bancoDeDatos;
    }

    public void setBancoDeDatos(List<Punto> bancoDeDatos) {
        this.bancoDeDatos = bancoDeDatos;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Clase[] getClases() {
        return clases;
    }

    public void setClases(Clase[] clases) {
        this.clases = clases;
    }

}
