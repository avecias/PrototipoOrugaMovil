/*
Trama equivalente a un la linea del archivo
*/
package app.modelo.entidades;

public class Trama {
    
    private int sensorA;
    private int sensorB;
    private int sensorC;
    private int sensorD;
    private int encoder;

    public Trama() {
    }

    public Trama(int sensorA, int sensorB, int sensorC, int sensorD, int encoder) {
        this.sensorA = sensorA;
        this.sensorB = sensorB;
        this.sensorC = sensorC;
        this.sensorD = sensorD;
        this.encoder = encoder;
    }

    public int getSensorA() {
        return sensorA;
    }

    public void setSensorA(int sensorA) {
        this.sensorA = sensorA;
    }

    public int getSensorB() {
        return sensorB;
    }

    public void setSensorB(int sensorB) {
        this.sensorB = sensorB;
    }

    public int getSensorC() {
        return sensorC;
    }

    public void setSensorC(int sensorC) {
        this.sensorC = sensorC;
    }

    public int getSensorD() {
        return sensorD;
    }

    public void setSensorD(int sensorD) {
        this.sensorD = sensorD;
    }

    public int getEncoder() {
        return encoder;
    }

    public void setEncoder(int encoder) {
        this.encoder = encoder;
    }

    @Override
    public String toString() {
        return "Trama{" + "sensorA=" + sensorA + ", sensorB=" + sensorB + ", sensorC=" + sensorC + ", sensorD=" + sensorD + ", encoder=" + encoder + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.sensorA;
        hash = 31 * hash + this.sensorB;
        hash = 31 * hash + this.sensorC;
        hash = 31 * hash + this.sensorD;
        hash = 31 * hash + this.encoder;
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
        final Trama other = (Trama) obj;
        if (this.sensorA != other.sensorA) {
            return false;
        }
        if (this.sensorB != other.sensorB) {
            return false;
        }
        if (this.sensorC != other.sensorC) {
            return false;
        }
        if (this.sensorD != other.sensorD) {
            return false;
        }
        if (this.encoder != other.encoder) {
            return false;
        }
        return true;
    }
    
    
}
