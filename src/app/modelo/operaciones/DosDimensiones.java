/*
Operaciones matematicas para dos dimensiones
 */
package app.modelo.operaciones;

import app.modelo.entidades.Punto;
import java.util.List;

public class DosDimensiones{
    
    public static Punto centroide(List<Punto> puntos){
        Punto centroide = new Punto();
        double xs = 0.0D;
        double ys = 0.0D;
        for (int i = 0; i < puntos.size(); i++) {
            xs += puntos.get(i).getX();
            ys += puntos.get(i).getY();
        }
        centroide.setIdPunto(-1);
        centroide.setX(xs/puntos.size());
        centroide.setY(ys/puntos.size());
        return centroide;
    }
}
