/*
Algortimo de agrupamiento por K-means
condicion de k impar y mayor a 3
 */
package app.modelo.ia.kmeans;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import java.util.List;

public class Kmeans {

    private Clase[] clases;
    private Clase[] clasesAnterior;

    /*
    Parametros de entrada
    
    Parametro de Regreso
     */
    public Clase[] calcular(List<Punto> banco, int k) {
        //Inicializar clases con el tamaño de K
        clases = new Clase[k];
        clasesAnterior = new Clase[k];
        //Inicializar los parametros
        inicializar();
        //Condicion de Paro
        while (centrosIguales()) {
            //Inicializa el algoritmo
        }
        return clases;
    }

    private void inicializar() {
    }

    private boolean centrosIguales() {
        return true;
    }

}
