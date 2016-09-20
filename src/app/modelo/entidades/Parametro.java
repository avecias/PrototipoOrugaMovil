/*
Clase entidad para los parametros de la conexion con el bluetooth
*/
package app.modelo.entidades;

import java.util.Objects;


public class Parametro {
    
    private String puerto;
    private int baudios;
    private int datos;
    private int paro;
    private int paridad;

    public Parametro() {
    }

    public Parametro(String puerto, int baudios, int datos, int paro, int paridad) {
        this.puerto = puerto;
        this.baudios = baudios;
        this.datos = datos;
        this.paro = paro;
        this.paridad = paridad;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getBaudios() {
        return baudios;
    }

    public void setBaudios(int baudios) {
        this.baudios = baudios;
    }

    public int getDatos() {
        return datos;
    }

    public void setDatos(int datos) {
        this.datos = datos;
    }

    public int getParo() {
        return paro;
    }

    public void setParo(int paro) {
        this.paro = paro;
    }

    public int getParidad() {
        return paridad;
    }

    public void setParidad(int paridad) {
        this.paridad = paridad;
    }

    @Override
    public String toString() {
        return "Parametro{" + "puerto=" + puerto + ", baudios=" + baudios + ", datos=" + datos + ", paro=" + paro + ", paridad=" + paridad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.puerto);
        hash = 83 * hash + this.baudios;
        hash = 83 * hash + this.datos;
        hash = 83 * hash + this.paro;
        hash = 83 * hash + this.paridad;
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
        final Parametro other = (Parametro) obj;
        if (!Objects.equals(this.puerto, other.puerto)) {
            return false;
        }
        if (this.baudios != other.baudios) {
            return false;
        }
        if (this.datos != other.datos) {
            return false;
        }
        if (this.paro != other.paro) {
            return false;
        }
        if (this.paridad != other.paridad) {
            return false;
        }
        return true;
    }
    
}
