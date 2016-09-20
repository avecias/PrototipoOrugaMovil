/*
Sesion del programa para poder y subir bajar parametros en un objeto general
 */
package app.controlador.control.sesion;

import app.modelo.comunicacion.serial.ConexionSerial;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Parametro;
import java.util.ArrayList;
import java.util.List;

public class Sesion {
    
    //Los objetos que contendra para la sesison
    private ConexionSerial conexionSerial;
    private Parametro parametros;
    private List<ArchivosCargado> archivosCargados;

    public Sesion() {
    }

    public Sesion(ConexionSerial conexionSerial, Parametro parametros, List<ArchivosCargado> archivosCargados) {
        this.conexionSerial = conexionSerial;
        this.parametros = parametros;
        this.archivosCargados = archivosCargados;
    }

    public void iniciar(){
        //Iniciar los parametros de la lectura
        archivosCargados = new ArrayList<>();
        conexionSerial = new ConexionSerial();
    }
    
    public void teminar(){
        //Terminar con los objetos de la conexion
        conexionSerial.cerrarPuerto();
    }

    public ConexionSerial getConexionSerial() {
        return conexionSerial;
    }

    public void setConexionSerial(ConexionSerial conexionSerial) {
        this.conexionSerial = conexionSerial;
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    public List<ArchivosCargado> getArchivosCargados() {
        return archivosCargados;
    }

    public void setArchivosCargados(List<ArchivosCargado> archivosCargados) {
        this.archivosCargados = archivosCargados;
    }

    
}
