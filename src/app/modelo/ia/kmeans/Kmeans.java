/*
Algortimo de agrupamiento por K-means
condicion de k impar y mayor a 3
 */
package app.modelo.ia.kmeans;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.operaciones.Basico;
import app.modelo.operaciones.DosDimensiones;
import java.util.ArrayList;
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
        while(centrosIguales()){
            //Inicializa el algoritmo
        }
        return clases;
    }

    private void inicializar() {
    }

    private boolean centrosIguales() {
        return true;
    }

    public static void main(String[] args) {
        double[] vector = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        List<Punto> puntos = new ArrayList<>();
        Clase c = new Clase("Clase 1", puntos, new Punto(-1, 0, 0, 0));
        puntos.add(new Punto(0, 1.0, 1.0));
        puntos.add(new Punto(1, 2.0, 2.0));
        puntos.add(new Punto(2, 3.0, 3.0));
        puntos.add(new Punto(3, 4.0, 4.0));
        puntos.add(new Punto(4, 5.0, 5.0));
        puntos.add(new Punto(5, 6.0, 6.0));
        puntos.add(new Punto(6, 7.0, 7.0));
        puntos.add(new Punto(7, 8.0, 8.0));
        puntos.add(new Punto(8, 9.0, 9.0));
        System.out.println("Resultado " + Basico.norma(vector));
        System.out.println(DosDimensiones.centroide(puntos).toString());
        System.out.println(c);
    }

}
