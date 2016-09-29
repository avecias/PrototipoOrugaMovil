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
        Pattern pat = Pattern.compile("^a\\d{1,4}b\\d{1,4}c\\d{1,4}d\\d{1,4}e\\d{1,2}");
        Matcher mat = pat.matcher(linea);
        return mat.matches();
    }

    private static Trama seccionar(String linea) {
        Trama trama = new Trama();
        String a = "",b=a,c=a,d=a,e=a;
        int i = 0;
        while(i < linea.length()){
            switch (linea.charAt(i)) {
                case 'a':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        a += linea.charAt(i);
                        i++;
                    }   break;
                case 'b':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        b += linea.charAt(i);
                        i++;
                    }   break;
                case 'c':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        c += linea.charAt(i);
                        i++;
                    }   break;
                case 'd':
                    //Grabar a
                    i++;while(isNumero(linea.charAt(i))){
                        d += linea.charAt(i);
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
        trama.setSensorA(Integer.valueOf(a));
        trama.setSensorB(Integer.valueOf(b));
        trama.setSensorC(Integer.valueOf(c));
        trama.setSensorD(Integer.valueOf(d));
        trama.setEncoder(Integer.valueOf(e));
        return trama;
    }
    
    
    private static boolean isNumero(char c) {
        return c >= 48 && c <= 57;
    }

}
