/*
Para poder ordenar listas con X
 */
package app.modelo.operaciones;

import app.modelo.entidades.Punto;
import java.util.Comparator;

public class ComparadorX implements Comparator<Punto> {

    @Override
    public int compare(Punto p1, Punto p2) {
        return new Double(p1.getX()).compareTo(p2.getX());
    }

}
