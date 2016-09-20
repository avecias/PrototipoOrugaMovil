
package app.controlador.control;

import app.modelo.comunicacion.SD.Archivo;
import app.vista.graficas.GraficaXY;

public class Reporte {

    public static void generar(Archivo lecturas) {
        GraficaXY graficaXY = new GraficaXY("Lecturas de Prueba");
        graficaXY.mostrar(lecturas);
    }

    
}
