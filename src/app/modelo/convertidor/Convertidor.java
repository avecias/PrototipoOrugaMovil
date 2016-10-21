/*
 Covertir el archivo leido en string a un objeto tipo lectura
 */
package app.modelo.convertidor;

import app.modelo.entidades.Lectura;
import app.modelo.entidades.Trama;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convertidor {

    public static Lectura aLectura(File file) {
        Lectura lectura = new Lectura();
        List<Trama> tramas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (esTrama(linea)) {
                    //Si es cabecera escribir
                    tramas.add(seccionar(linea));
                } else if (esCabecera(linea)) {
                    //Es una cabecera escribir cabecera y version
                    String[] cv = linea.split("_");
                    lectura.setEncabezado(cv[0]);
                    lectura.setVersion(cv[1]);
                } else {
                    //Si no es ninguna de la anteriores escribir error en la linea
                }
            }
            lectura.setTramas(tramas);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + e);
        }
        return lectura;
    }

    private static boolean esCabecera(String linea) {
        Pattern pat = Pattern.compile("prototipomovil_v1.0");
        Matcher mat = pat.matcher(linea);
        return mat.matches();
    }

    private static boolean esTrama(String linea) {
        Pattern pat = Pattern.compile("^t\\d{1,4}g\\d{1,4}h\\d{1,4}f\\d{1,4}s\\d{1,4}e\\d{1,2}");
        Matcher mat = pat.matcher(linea);
        return mat.matches();
    }

    private static Trama seccionar(String linea) {
        Trama trama = new Trama();
        String t = "",g=t,h=t,f=t,s=t,e=t;
        int i = 0;
        while(i < linea.length()){
            switch (linea.charAt(i)) {
                case 't':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        t += linea.charAt(i);
                        i++;
                    }   break;
                case 'g':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        g += linea.charAt(i);
                        i++;
                    }   break;
                case 'h':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        h += linea.charAt(i);
                        i++;
                    }   break;
                case 'f':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        f += linea.charAt(i);
                        i++;
                    }   break;
                case 's':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        s += linea.charAt(i);
                        i++;
                    }   break;
                case 'e':
                    //Grabar a
                    i++;while(i < linea.length()){
                        e += linea.charAt(i);
                        i++;
                    }   break;
                default:
                    break;
            }
        }
        trama.setTemperatura(Integer.valueOf(t));
        trama.setGas(Integer.valueOf(g));
        trama.setHumo(Integer.valueOf(h));
        trama.setLlama(Integer.valueOf(f));
        trama.setSonido(Integer.valueOf(s));
        trama.setEncoder(Integer.valueOf(e));
        return trama;
    }
    
    
    private static boolean isNumero(char c) {
        return c >= 48 && c <= 57;
    }

}
