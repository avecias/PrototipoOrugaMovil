/*
Operaciones basicas
 */
package app.modelo.operaciones;


public class Basico {
    
    public static double norma(double[] vector){
        double n = 0.0D;
        for (int i = 0; i < vector.length; i++) {
            n += vector[i];
        }
        return n/vector.length;
    }
    
}
