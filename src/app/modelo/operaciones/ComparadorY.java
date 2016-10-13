/*
Para poder ordenar listas con Y
 */
package app.modelo.operaciones;

import app.modelo.entidades.Punto;
import java.util.Comparator;

public class ComparadorY implements Comparator<Punto> {

    @Override
    public int compare(Punto p1, Punto p2) {
        return new Double(p1.getY()).compareTo(p2.getY());
    }

}
