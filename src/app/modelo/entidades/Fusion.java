/*
Fusion de los datos para poder realizar inteligencia artificial
 */
package app.modelo.entidades;

import java.io.Serializable;
import java.util.Arrays;

public class Fusion implements Serializable{
    
    public static int dosDimensiones = 2;
    public static int tresDimensiones = 3;
    
    private String[] fusion1;
    private String[] fusion2;
    private String[] fusion3;
    private int k1, k2, k3;

    public Fusion() {
    }

    public Fusion(String[] fusion1, String[] fusion2, String[] fusion3) {
        this.fusion1 = fusion1;
        this.fusion2 = fusion2;
        this.fusion3 = fusion3;
    }
    
    public Fusion(int f1, int f2, int f3) {
        fusion1 = new String[f1];
        fusion2 = new String[f2];
        fusion3 = new String[f3];
    }

    public Fusion(String[] fusion1, String[] fusion2, String[] fusion3, int k1, int k2, int k3) {
        this.fusion1 = fusion1;
        this.fusion2 = fusion2;
        this.fusion3 = fusion3;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
    }

    public static int getDosDimensiones() {
        return dosDimensiones;
    }

    public static void setDosDimensiones(int dosDimensiones) {
        Fusion.dosDimensiones = dosDimensiones;
    }

    public static int getTresDimensiones() {
        return tresDimensiones;
    }

    public static void setTresDimensiones(int tresDimensiones) {
        Fusion.tresDimensiones = tresDimensiones;
    }

    public String[] getFusion1() {
        return fusion1;
    }

    public void setFusion1(String[] fusion1) {
        this.fusion1 = fusion1;
    }

    public String[] getFusion2() {
        return fusion2;
    }

    public void setFusion2(String[] fusion2) {
        this.fusion2 = fusion2;
    }

    public String[] getFusion3() {
        return fusion3;
    }

    public void setFusion3(String[] fusion3) {
        this.fusion3 = fusion3;
    }

    public int getK1() {
        return k1;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public int getK3() {
        return k3;
    }

    public void setK3(int k3) {
        this.k3 = k3;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Arrays.deepHashCode(this.fusion1);
        hash = 11 * hash + Arrays.deepHashCode(this.fusion2);
        hash = 11 * hash + Arrays.deepHashCode(this.fusion3);
        hash = 11 * hash + this.k1;
        hash = 11 * hash + this.k2;
        hash = 11 * hash + this.k3;
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
        final Fusion other = (Fusion) obj;
        if (this.k1 != other.k1) {
            return false;
        }
        if (this.k2 != other.k2) {
            return false;
        }
        if (this.k3 != other.k3) {
            return false;
        }
        if (!Arrays.deepEquals(this.fusion1, other.fusion1)) {
            return false;
        }
        if (!Arrays.deepEquals(this.fusion2, other.fusion2)) {
            return false;
        }
        return Arrays.deepEquals(this.fusion3, other.fusion3);
    }

    @Override
    public String toString() {
        return "Fusion{" + "fusion1=" + Arrays.toString(fusion1) + ", fusion2=" + Arrays.toString(fusion2) + ", fusion3=" + Arrays.toString(fusion3) + '}';
    }
    
}
