
package app.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Lectura implements Serializable{
    
    private String encabezado;
    private String version;
    private List<Trama> tramas;

    public Lectura() {
    }

    public Lectura(String encabezado, String version, List<Trama> tramas) {
        this.encabezado = encabezado;
        this.version = version;
        this.tramas = tramas;
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

    public List<Trama> getTramas() {
        return tramas;
    }

    public void setTramas(List<Trama> tramas) {
        this.tramas = tramas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.encabezado);
        hash = 97 * hash + Objects.hashCode(this.version);
        hash = 97 * hash + Objects.hashCode(this.tramas);
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
        final Lectura other = (Lectura) obj;
        if (!Objects.equals(this.encabezado, other.encabezado)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.tramas, other.tramas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String string = "Lectura{" + "encabezado=" + encabezado + ", version=" + version +  "}\n";
        for (Trama trama : tramas) {
            string += trama.toString() + "\n";
        }
        return string;
    }
    
    
}
