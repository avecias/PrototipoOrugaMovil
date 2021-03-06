/*
Sesion del programa para poder y subir bajar parametros en un objeto general
 */
package app.controlado.sesion;

import app.modelo.comunicacion.serial.ConexionSerialImple;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Clase;
import app.modelo.entidades.Fusion;
import app.modelo.entidades.Parametro;
import java.util.ArrayList;
import java.util.List;
import jssc.SerialPortException;

public class Sesion {
    
    //Los objetos que contendra para la sesison
    private ConexionSerialImple conexionSerial;
    private Parametro parametros;
    private List<ArchivosCargado> archivosCargados;
    private Fusion fusion;
    private List<Clase[]> fusionados;
    private List<Clase[]> fusionadosClasificados;

    public Sesion() {
    }

    public Sesion(ConexionSerialImple conexionSerial, Parametro parametros, List<ArchivosCargado> archivosCargados) {
        this.conexionSerial = conexionSerial;
        this.parametros = parametros;
        this.archivosCargados = archivosCargados;
    }

    public void iniciar(){
        //Iniciar los parametros de la lectura
        archivosCargados = new ArrayList<>();
        conexionSerial = new ConexionSerialImple();
    }
    
    public void teminar(){
        try {
            //Terminar con los objetos de la conexion
            conexionSerial.cerrar();
        } catch (SerialPortException ex) {
            System.err.println("Error en cerrar los objetos");
        }
    }

    public ConexionSerialImple getConexionSerial() {
        return conexionSerial;
    }

    public void setConexionSerial(ConexionSerialImple conexionSerial) {
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

    public Fusion getFusion() {
        return fusion;
    }

    public void setFusion(Fusion fusion) {
        this.fusion = fusion;
    }

    public List<Clase[]> getFusionados() {
        return fusionados;
    }

    public void setFusionados(List<Clase[]> fusionados) {
        this.fusionados = fusionados;
    }

    public List<Clase[]> getFusionadosClasificados() {
        return fusionadosClasificados;
    }

    public void setFusionadosClasificados(List<Clase[]> fusionadosClasificados) {
        this.fusionadosClasificados = fusionadosClasificados;
    }
}
