/*
Clase donde se almacena los vectores o puntos que pertenecen a esta clase
 */
package app.modelo.entidades;

import java.util.List;
import java.util.Objects;

public class Clase {
    
    private String nombre;
    private List<Punto> puntos;
    private Punto centroide;

    public Clase() {
    }

    public Clase(String nombre, List<Punto> puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }
    
    public Clase(String nombre, List<Punto> puntos, Punto centroide) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.centroide = centroide;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public Punto getCentroide() {
        return centroide;
    }

    public void setCentroide(Punto centroide) {
        this.centroide = centroide;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.puntos);
        hash = 67 * hash + Objects.hashCode(this.centroide);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clase other = (Clase) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.puntos, other.puntos)) {
            return false;
        }
        if (!Objects.equals(this.centroide, other.centroide)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String to = "Clase{" + "nombre=" + nombre + "}\n";
        to += centroide.toString() + "\n";
        for (Punto punto : puntos) {
            to += punto.toString() + "\n";
        }
        return to;
    }
    
}
