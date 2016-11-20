/*
Sensores conversion
 */
package app.modelo.entidades;

import java.io.Serializable;
import java.util.Arrays;

public class SensoresConvercion implements Serializable,Cloneable{
    
    private double[] temperatura;
    private double[] gas;
    private double[] humo;
    private double[] llama;
    private double[] sonido;

    public SensoresConvercion() {
    }

    public SensoresConvercion(double[] temperatura, double[] gas, double[] humo, double[] llama, double[] sonido) {
        this.temperatura = temperatura;
        this.gas = gas;
        this.humo = humo;
        this.llama = llama;
        this.sonido = sonido;
    }

    public double[] getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double[] temperatura) {
        this.temperatura = temperatura;
    }

    public double[] getGas() {
        return gas;
    }

    public void setGas(double[] gas) {
        this.gas = gas;
    }

    public double[] getHumo() {
        return humo;
    }

    public void setHumo(double[] humo) {
        this.humo = humo;
    }

    public double[] getLlama() {
        return llama;
    }

    public void setLlama(double[] llama) {
        this.llama = llama;
    }

    public double[] getSonido() {
        return sonido;
    }

    public void setSonido(double[] sonido) {
        this.sonido = sonido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.hashCode(this.temperatura);
        hash = 83 * hash + Arrays.hashCode(this.gas);
        hash = 83 * hash + Arrays.hashCode(this.humo);
        hash = 83 * hash + Arrays.hashCode(this.llama);
        hash = 83 * hash + Arrays.hashCode(this.sonido);
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
        final SensoresConvercion other = (SensoresConvercion) obj;
        if (!Arrays.equals(this.temperatura, other.temperatura)) {
            return false;
        }
        if (!Arrays.equals(this.gas, other.gas)) {
            return false;
        }
        if (!Arrays.equals(this.humo, other.humo)) {
            return false;
        }
        if (!Arrays.equals(this.llama, other.llama)) {
            return false;
        }
        if (!Arrays.equals(this.sonido, other.sonido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SensoresConvercion{\n" + "temperatura=" + Arrays.toString(temperatura) + ",\ngas=" + Arrays.toString(gas) + ",\nhumo=" + Arrays.toString(humo) + ",\nllama=" + Arrays.toString(llama) + ",\nsonido=" + Arrays.toString(sonido) + '}';
    }

    
}
