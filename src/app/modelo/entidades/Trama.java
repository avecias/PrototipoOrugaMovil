/*
Trama final con los id de los sensores
 */
package app.modelo.entidades;

import java.io.Serializable;

public class Trama implements Serializable, Cloneable {

    private int temperatura;
    private int gas;
    private int humo;
    private int llama;
    private int sonido;
    private int encoder;

    public Trama() {
    }

    public Trama(int temperatura, int gas, int humo, int llama, int sonido, int encoder) {
        this.temperatura = temperatura;
        this.gas = gas;
        this.humo = humo;
        this.llama = llama;
        this.sonido = sonido;
        this.encoder = encoder;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getHumo() {
        return humo;
    }

    public void setHumo(int humo) {
        this.humo = humo;
    }

    public int getLlama() {
        return llama;
    }

    public void setLlama(int llama) {
        this.llama = llama;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }

    public int getEncoder() {
        return encoder;
    }

    public void setEncoder(int encoder) {
        this.encoder = encoder;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.temperatura;
        hash = 23 * hash + this.gas;
        hash = 23 * hash + this.humo;
        hash = 23 * hash + this.llama;
        hash = 23 * hash + this.sonido;
        hash = 23 * hash + this.encoder;
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
        final Trama other = (Trama) obj;
        if (this.temperatura != other.temperatura) {
            return false;
        }
        if (this.gas != other.gas) {
            return false;
        }
        if (this.humo != other.humo) {
            return false;
        }
        if (this.llama != other.llama) {
            return false;
        }
        if (this.sonido != other.sonido) {
            return false;
        }
        if (this.encoder != other.encoder) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TramaLinea{" + "temperatura=" + temperatura + ", gas=" + gas + ", humo=" + humo + ", llama=" + llama + ", sonido=" + sonido + ", encoder=" + encoder + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Trama(temperatura, gas, humo, llama, sonido, encoder);
    }

}
