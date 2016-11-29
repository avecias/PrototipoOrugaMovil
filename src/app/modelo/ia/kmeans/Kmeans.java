/*
Algortimo de agrupamiento por K-means
condicion de k impar y mayor a 3
 */
package app.modelo.ia.kmeans;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.ia.clasificador.ClasificadorEuclidiano2D;
import app.modelo.operaciones.DosDimensiones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        // Inicializar clases con el tamaño de K
        clases = new Clase[k];
        centroides = new Punto[k];
    }

    // Metodo para el calculo 
    public Clase[] calcular() {
        // Inicializar los parametros
        inicializar();
        // Inicializar las primeras clases
        clasificador = new ClasificadorEuclidiano2D(centroides);
        //Condicion de Paro
        int j = 0;
        while (!sonCentrosIguales()) {
            //Borrar la anterior clasificacion
            System.out.println("j = " + j);
            borrar();
            for (Punto punto : bancoDeDatos) {
                // Agregar a la clase que la claficacion
                clases[clasificador.clasificarConCentroide(punto)].getPuntos().add(punto);
            }
            calcularCentroides();
            clasificador = new ClasificadorEuclidiano2D(centroides);
        }
        agregarCentroides();
        return clases;
    }
    
    public Clase[] calcular2() {
        // Inicializar los parametros
        inicializar2();
        // Inicializar las primeras clases
        clasificador = new ClasificadorEuclidiano2D(centroides);
        int j = 0;
        //Condicion de Paro
        while (!sonCentrosIguales()) {
            //Borrar la anterior clasificacion
            System.out.println("j = " + j);
            borrar();
            for (Punto punto : bancoDeDatos) {
                // Agregar a la clase que la claficacion
                clases[clasificador.clasificarConCentroide(punto)].getPuntos().add(punto);
            }
            calcularCentroides();
            clasificador = new ClasificadorEuclidiano2D(centroides);
        }
        agregarCentroides();
        return clases;
    }

    public Clase[] calcularClases() {
        // Inicializar los parametros
        inicializar();
        // Inicializar las primeras clases
        clasificador = new ClasificadorEuclidiano2D(centroides);
        //Condicion de Paro
        while (!sonCentrosIguales()) {
            //Borrar la anterior clasificacion
            borrar();
            for (Punto punto : bancoDeDatos) {
                // Agregar a la clase que la claficacion
                clases[clasificador.clasificar(punto)].getPuntos().add(punto);
            }
            calcularCentroides();
            clasificador = new ClasificadorEuclidiano2D(centroides);
        }
        agregarCentroides();
        return clases;
    }

    private void inicializar() {
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            //Le damos el centro a los primeros elemento del banco de datos
            int v = Math.abs(r.nextInt() % bancoDeDatos.size());
            centroides[i] = new Punto(-1, bancoDeDatos.get(v).getX(), bancoDeDatos.get(v).getY());
            // System.out.println(centroides[i]);
            // Inicializamos las clases
            clases[i] = new Clase("Clase" + i, new ArrayList<Punto>());
        }
    }
    
    private void inicializar2() {
        for (int i = 0; i < k; i++) {
            //Le damos el centro a los primeros elemento del banco de datos
            centroides[i] = new Punto(-1, bancoDeDatos.get(i).getX(), bancoDeDatos.get(i).getY());
            // System.out.println(centroides[i]);
            // Inicializamos las clases
            clases[i] = new Clase("Clase" + i, new ArrayList<Punto>());
        }
    }

    private boolean sonCentrosIguales() {
        return Arrays.equals(centroides, centroidesAnteriores);
    }

    private void calcularCentroides() {
        centroidesAnteriores = centroides;
        for (int i = 0; i < clases.length; i++) {
            Punto punto = DosDimensiones.centroide(clases[i].getPuntos());
            centroides[i] = new Punto(-1, punto.getX(), punto.getY());
        }
    }

    private void borrar() {
        for (Clase clase : clases) {
            clase.getPuntos().clear();
        }
    }

    private void agregarCentroides() {
        for (int i = 0; i < centroides.length; i++) {
            clases[i].setCentroide(centroides[i]);
        }
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

//    public static void main(String[] args) {
//        Random r = new Random();
//        int[] valores = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        for (int i = 0; i < 4; i++) {
//            int v = Math.abs(r.nextInt()%valores.length);
//            System.out.println(v);
//            System.out.println(valores[v]);
//        }
//    }
}
