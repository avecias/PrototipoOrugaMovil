
package app.modelo.entidades;

import java.util.Date;
import java.util.Objects;

public class ArchivosCargado {
    
    private int id;
    private String nombre;
    private Lectura lectura;
    private Date date;

    public ArchivosCargado() {
    }

    public ArchivosCargado(int id, String nombre, Lectura lectura, Date date) {
        this.id = id;
        this.nombre = nombre;
        this.lectura = lectura;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lectura getLectura() {
        return lectura;
    }

    public void setLectura(Lectura lectura) {
        this.lectura = lectura;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.lectura);
        hash = 19 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArchivosCargado other = (ArchivosCargado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.lectura, other.lectura)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArchivosCargado{" + "id=" + id + ", nombre=" + nombre + ", date=" + date + '}';
    }
    
    
}
