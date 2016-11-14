/*
Clacular la media de tres dimensiones
 */
package app.modelo.operaciones;

import app.modelo.entidades.Punto;
import java.util.List;

public class TresDimensiones {
    
    public static Punto centroide(List<Punto> puntos) {
        Punto centroide = new Punto();
        double xs = 0.0D;
        double ys = 0.0D;
        double zs = 0.0D;
        for (int i = 0; i < puntos.size(); i++) {
            xs += puntos.get(i).getX();
            ys += puntos.get(i).getY();
            zs += puntos.get(i).getZ();
        }
        centroide.setIdPunto(-1);
        centroide.setX(xs / puntos.size());
        centroide.setY(ys / puntos.size());
        centroide.setZ(zs / puntos.size());
        return centroide;
    }
}
