
package app.modelo.comunicacion.SD;

public class Lectura {
    
    private int sensor1;
    private int sensor2;
    private int sensor3;
    private int sensor4;
    private int encoder;

    public Lectura() {
    }

    public Lectura(int sensor1, int sensor2, int sensor3, int sensor4, int encoder) {
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.sensor4 = sensor4;
        this.encoder = encoder;
    }

    public int getSensor1() {
        return sensor1;
    }

    public void setSensor1(int sensor1) {
        this.sensor1 = sensor1;
    }

    public int getSensor2() {
        return sensor2;
    }

    public void setSensor2(int sensor2) {
        this.sensor2 = sensor2;
    }

    public int getSensor3() {
        return sensor3;
    }

    public void setSensor3(int sensor3) {
        this.sensor3 = sensor3;
    }

    public int getSensor4() {
        return sensor4;
    }

    public void setSensor4(int sensor4) {
        this.sensor4 = sensor4;
    }

    public int getEncoder() {
        return encoder;
    }

    public void setEncoder(int encoder) {
        this.encoder = encoder;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.sensor1;
        hash = 97 * hash + this.sensor2;
        hash = 97 * hash + this.sensor3;
        hash = 97 * hash + this.sensor4;
        hash = 97 * hash + this.encoder;
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
        if (this.sensor1 != other.sensor1) {
            return false;
        }
        if (this.sensor2 != other.sensor2) {
            return false;
        }
        if (this.sensor3 != other.sensor3) {
            return false;
        }
        if (this.sensor4 != other.sensor4) {
            return false;
        }
        if (this.encoder != other.encoder) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public String toString() {
        return "Lectura{" + " sensor1=" + sensor1 + ", sensor2=" + sensor2 + ", sensor3=" + sensor3 + ", sensor4=" + sensor4 + ", encoder=" + encoder + " }";
    }
    
}
