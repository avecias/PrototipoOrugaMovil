/*
Calibrar a los sensores de tal manera que se muestre en sus propiedades
 */
package app.modelo.convertidor;

import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.SensoresConvercion;
import app.modelo.entidades.Trama;
import java.util.List;

public class Calibrar {

    private final int MQ1 = 0;   //define la entrada analogica para el sensor
    private final int RL_VALOR = 5;  //define el valor de la resistencia mde carga en kilo ohms
    private final double RAL = 9.83; // resistencia del sensor en el aire limpio / RO, que se deriva de la tabla de la hoja de datos
    private final int GAS_LP = 0;
    private final double[] LPCurve = {2.3, 0.21, -0.47};
    private double Ro;

    public Calibrar() {
        this.Ro = 10;
    }

    public SensoresConvercion hacer(ArchivosCargado archivo) {
        SensoresConvercion sc = new SensoresConvercion();
        List<Trama> tramas = archivo.getLectura().getTramas();
        double[] temperatura = new double[tramas.size()];
        double[] gas = new double[tramas.size()];
        double[] humo = new double[tramas.size()];
        double[] llama = new double[tramas.size()];
        double[] sonido = new double[tramas.size()];
        for (int i = 0; i < tramas.size(); i++) {
            temperatura[i] = tramas.get(i).getTemperatura() * 500 / 1023.0;
            gas[i] = porcentajeGas(tramas.get(i).getGas() / Ro, GAS_LP);
            humo[i] = porcentajeGas(tramas.get(i).getHumo() / Ro, GAS_LP);
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

    public SensoresConvercion hacerConVoltaje(ArchivosCargado archivo) {
        SensoresConvercion sc = new SensoresConvercion();
        List<Trama> tramas = archivo.getLectura().getTramas();
        double[] temperatura = new double[tramas.size()];
        double[] gas = new double[tramas.size()];
        double[] humo = new double[tramas.size()];
        double[] llama = new double[tramas.size()];
        double[] sonido = new double[tramas.size()];
        Ro = calibracion(tramas);
        for (int i = 0; i < tramas.size(); i++) {
            temperatura[i] = tramas.get(i).getTemperatura() * 5 / 1023.0;
            gas[i] = porcentajeGas(tramas.get(i).getGas() / Ro, GAS_LP);
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

    private double calibracion(List<Trama> tramas) {
        double val = 0.0;
        for (int i = 0; i < tramas.size(); i++) {
            val += RL_VALOR * (1023 - tramas.get(i).getGas() / tramas.get(i).getGas());
        }
        val = val / tramas.size();
        val = val / RAL;
        return val;
    }

    private double porcentajeGas(double rs_ro_ratio, int gas_id) {
        if (gas_id == GAS_LP) {
            System.out.println(porcentaje_gas(rs_ro_ratio, LPCurve));
            return porcentaje_gas(rs_ro_ratio, LPCurve);
        }
        return 0;
    }

    private double porcentaje_gas(double rs_ro_ratio, double[] pcurve) {
        return Math.pow(10, (((Math.log(rs_ro_ratio) - pcurve[1]) / pcurve[2]) + pcurve[0]));
    }
}
