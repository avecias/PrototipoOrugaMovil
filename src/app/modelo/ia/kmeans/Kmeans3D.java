/*
Clasificador de K-means en 3d
 */
package app.modelo.ia.kmeans;

import app.modelo.entidades.Clase;
import app.modelo.entidades.Punto;
import app.modelo.ia.clasificador.ClasificadorEuclidiano3D;
import app.modelo.operaciones.TresDimensiones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Kmeans3D {

    private List<Punto> bancoDeDatos;
    private int k;
    private Clase[] clases;
    private Punto[] centroides;
    private Punto[] centroidesAnteriores;
    private ClasificadorEuclidiano3D clasificador;

    public Kmeans3D(List<Punto> bancoDeDatos, int k) {
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
        clasificador = new ClasificadorEuclidiano3D(centroides);
        //Condicion de Paro
        while (!sonCentrosIguales()) {
            //Borrar la anterior clasificacion
            borrar();
            for (Punto punto : bancoDeDatos) {
                // Agregar a la clase que la claficacion
                clases[clasificador.clasificarConCentroide(punto)].getPuntos().add(punto);
            }
            calcularCentroides();
            clasificador = new ClasificadorEuclidiano3D(centroides);
        }
        agregarCentroides();
        return clases;
    }
    
    public Clase[] calcular2() {
        // Inicializar los parametros
        inicializar2();
        // Inicializar las primeras clases
        clasificador = new ClasificadorEuclidiano3D(centroides);
        //Condicion de Paro
        while (!sonCentrosIguales()) {
            //Borrar la anterior clasificacion
            borrar();
            for (Punto punto : bancoDeDatos) {
                // Agregar a la clase que la claficacion
                clases[clasificador.clasificarConCentroide(punto)].getPuntos().add(punto);
            }
            calcularCentroides();
            clasificador = new ClasificadorEuclidiano3D(centroides);
        }
        agregarCentroides();
        return clases;
    }

    private void inicializar() {
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            //Le damos el centro a los primeros elemento del banco de datos
            int v = Math.abs(r.nextInt() % bancoDeDatos.size());
            centroides[i] = new Punto(-1, bancoDeDatos.get(v).getX(), bancoDeDatos.get(v).getY(), bancoDeDatos.get(v).getZ());
            // Inicializamos las clases
            clases[i] = new Clase("Clase" + i, new ArrayList<Punto>());
        }
    }
    
    private void inicializar2() {
        for (int i = 0; i < k; i++) {
            //Le damos el centro a los primeros elemento del banco de datos
            centroides[i] = new Punto(-1, bancoDeDatos.get(i).getX(), bancoDeDatos.get(i).getY(), bancoDeDatos.get(i).getZ());
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
            Punto punto = TresDimensiones.centroide(clases[i].getPuntos());
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
}
