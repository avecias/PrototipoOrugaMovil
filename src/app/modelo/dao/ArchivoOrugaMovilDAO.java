/*
Clase encargada de comvertir el archiv que aporta el movil para poder convertir a un obejto y poder manipularlo
 */
package app.modelo.dao;

import app.modelo.entidades.Lectura;
import app.modelo.entidades.Trama;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;


public class ArchivoOrugaMovilDAO {
    
    public Lectura convertir(File file){
        //Este metodo convertira el archivo del movil a un objeto
        Lectura lectura = new Lectura();
        List<Trama> tramas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String linea;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (linea.charAt(0) == 'p') {
                    if (primera) {
                        String[] split = linea.split("_");
                        lectura.setEncabezado(split[0]);
                        lectura.setVersion(split[1]);
                        primera = false;
                    }
                    else{
                        //listaLecturas.add(lecturas);
                    }
                    //lecturas = new ArrayList<>();
                } else if (linea.charAt(0) == 's') {
                    tramas.add(trama(linea));
                }
            }
            //listaLecturas.add(lecturas);
            //archivo.setLecturas(listaLecturas);
        } catch (IOException ex) {
            System.err.println("Error de entrada o de salida en construir " + ex);
        } catch (PatternSyntaxException ex) {
            System.err.println("No creo que sea un archivo valido " + ex);
        } catch(StringIndexOutOfBoundsException ex){
            System.err.println("Archivo incorrecto " + ex);
        }
        return lectura;
    }
    
    
    private Trama trama(String linea) {
        Trama trama = new Trama();
        try {
            if (linea.charAt(linea.length() - 1) == 'f') {
                //Es valido el final de la cadena
                for (int i = 1; i < 6; i++) {
                    if (i < 4) {
                        String s = "s" + i + ":", sNext = "s" + (i + 1) + ":";
                        if (i == 1) {
                            trama.setSensorA(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        } else if (i == 2) {
                            trama.setSensorB(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        } else if (i == 3) {
                            trama.setSensorC(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        }
                    } else if (i == 4) {
                        String s = "s" + i + ":";
                        trama.setSensorD(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf("e:"))));
                    } else if (i == 5) {
                        trama.setEncoder(Integer.valueOf(linea.substring(linea.indexOf("e:") + 2, linea.indexOf("f"))));
                    }
                }
            }
        } catch (PatternSyntaxException ex) {
            System.err.println("No creo que este sea un cadena valida " + ex + ": " + linea);
        }
        return trama;
    }
}
