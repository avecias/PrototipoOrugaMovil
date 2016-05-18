
package app.modelo.comunicacion.SD;

import java.util.ArrayList;
import java.util.Objects;

public class Archivo {
    
    private String encabezado;
    private String version;
    private ArrayList<ArrayList<Lectura>> listaLecturas;

    public Archivo() {
    }

    public Archivo(String encabezado, String version, ArrayList<ArrayList<Lectura>> lecturas) {
        this.encabezado = encabezado;
        this.version = version;
        this.listaLecturas = lecturas;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<ArrayList<Lectura>> getLecturas() {
        return listaLecturas;
    }

    public void setLecturas(ArrayList<ArrayList<Lectura>> lecturas) {
        this.listaLecturas = lecturas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Archivo other = (Archivo) obj;
        if (!Objects.equals(this.encabezado, other.encabezado)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.listaLecturas, other.listaLecturas)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        String contenido = "Archivo{" + "encabezado=" + encabezado + ", version=" + version + " }\n";
        for (int i = 0; i < listaLecturas.size(); i++) {
            ArrayList<Lectura> lecturas = listaLecturas.get(i);
            contenido += "lectura" + i + "\n"; 
            for (int j = 0; j < lecturas.size(); j++) {
                contenido += lecturas.get(j).toString() + "\n";
            }
        }
        return contenido;
    }
    
    
}
