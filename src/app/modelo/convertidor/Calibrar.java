/*
Calibrar a los sensores de tal manera que se muestre en sus propiedades
 */
package app.modelo.convertidor;

import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.SensoresConvercion;
import app.modelo.entidades.Trama;
import java.util.List;

public class Calibrar {

    public static SensoresConvercion hacer(ArchivosCargado archivo) {
        SensoresConvercion sc = new SensoresConvercion();
        List<Trama> tramas = archivo.getLectura().getTramas();
        double[] temperatura = new double[tramas.size()];
        double[] gas = new double[tramas.size()];
        double[] humo = new double[tramas.size()];
        double[] llama = new double[tramas.size()];
        double[] sonido = new double[tramas.size()];
        for (int i = 0; i < tramas.size(); i++) {
            temperatura[i] = tramas.get(i).getTemperatura() * 500 / 1023.0;
            gas[i] = tramas.get(i).getGas() * 5 / 1023.0;
            humo[i] = tramas.get(i).getHumo() * 5 / 1023.0;
            llama[i] = (tramas.get(i).getLlama() < 512) ? 0 : 1;
            sonido[i] = (tramas.get(i).getSonido() < 512) ? 0 : 1;
        }
        sc.setTemperatura(temperatura);
        sc.setGas(gas);
        sc.setHumo(humo);
        sc.setLlama(llama);
        sc.setSonido(sonido);
        return sc;
    }
    
    
    public static SensoresConvercion hacerConVoltaje(ArchivosCargado archivo) {
        SensoresConvercion sc = new SensoresConvercion();
        List<Trama> tramas = archivo.getLectura().getTramas();
        double[] temperatura = new double[tramas.size()];
        double[] gas = new double[tramas.size()];
        double[] humo = new double[tramas.size()];
        double[] llama = new double[tramas.size()];
        double[] sonido = new double[tramas.size()];
        for (int i = 0; i < tramas.size(); i++) {
            temperatura[i] = tramas.get(i).getTemperatura() * 5 / 1023.0;
            gas[i] = tramas.get(i).getGas() * 5 / 1023.0;
            humo[i] = tramas.get(i).getHumo() * 5 / 1023.0;
            llama[i] = tramas.get(i).getLlama() * 5 / 1023.0;
            sonido[i] = tramas.get(i).getSonido() * 5 / 1023.0;
        }
        sc.setTemperatura(temperatura);
        sc.setGas(gas);
        sc.setHumo(humo);
        sc.setLlama(llama);
        sc.setSonido(sonido);
        return sc;
    }
}
