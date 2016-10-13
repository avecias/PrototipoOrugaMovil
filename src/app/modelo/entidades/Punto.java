/*
Clase punto haciendo alucion a un vector en 2D O 3D
 */
package app.modelo.entidades;

public class Punto {
    
    private int idPunto;
    private double x;
    private double y;
    private double z;

    public Punto() {
    }

    public Punto(int idPunto, double x, double y, double z) {
        this.idPunto = idPunto;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punto(int idPunto, double x, double y) {
        this.idPunto = idPunto;
        this.x = x;
        this.y = y;
    }

    public Punto(int idPunto, double x) {
        this.idPunto = idPunto;
        this.x = x;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idPunto;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Punto other = (Punto) obj;
        if (this.idPunto != other.idPunto) {
            return false;
        }
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Punto{" + "idPunto=" + idPunto + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}
