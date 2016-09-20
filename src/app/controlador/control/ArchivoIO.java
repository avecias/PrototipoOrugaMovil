package app.controlador.control;

import app.modelo.comunicacion.SD.Archivo;
import app.modelo.comunicacion.SD.Lectura;
import app.vista.graficas.GraficaXY;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ArchivoIO {

    private static Archivo archivo;

    public static Archivo leer() {
        archivo = new Archivo();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione el archivo de lectura");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            construir(archivo, file);
            JOptionPane.showMessageDialog(null, "Archivo cargado con exito");
            return archivo;
        }
        else{
            JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo");
            return null;
        }
    }

    private static void construir(Archivo archivo, File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String linea;
            ArrayList<ArrayList<Lectura>> listaLecturas = new ArrayList<>();
            ArrayList<Lectura> lecturas = null;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (linea.charAt(0) == 'p') {
                    if (primera) {
                        String[] split = linea.split("_");
                        archivo.setEncabezado(split[0]);
                        archivo.setVersion(split[1]);
                        primera = false;
                    }
                    else{
                        listaLecturas.add(lecturas);
                    }
                    lecturas = new ArrayList<>();
                } else if (linea.charAt(0) == 's') {
                    lecturas.add(trama(linea));
                }
            }
            listaLecturas.add(lecturas);
            archivo.setLecturas(listaLecturas);
        } catch (IOException ex) {
            System.err.println("Error de entrada o de salida en construir " + ex);
        } catch (PatternSyntaxException ex) {
            System.err.println("No creo que sea un archivo valido " + ex);
        } catch(StringIndexOutOfBoundsException ex){
            System.err.println("Archivo incorrecto " + ex);
        }
    }

    private static Lectura trama(String linea) {
        Lectura lectura = new Lectura();
        try {
            if (linea.charAt(linea.length() - 1) == 'f') {
                //Es valido el final de la cadena
                for (int i = 1; i < 6; i++) {
                    if (i < 4) {
                        String s = "s" + i + ":", sNext = "s" + (i + 1) + ":";
                        if (i == 1) {
                            lectura.setSensor1(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        } else if (i == 2) {
                            lectura.setSensor2(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        } else if (i == 3) {
                            lectura.setSensor3(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf(sNext))));
                        }
                    } else if (i == 4) {
                        String s = "s" + i + ":";
                        lectura.setSensor4(Integer.valueOf(linea.substring(linea.indexOf(s) + 3, linea.indexOf("e:"))));
                    } else if (i == 5) {
                        lectura.setEncoder(Integer.valueOf(linea.substring(linea.indexOf("e:") + 2, linea.indexOf("f"))));
                    }
                }
            }
        } catch (PatternSyntaxException ex) {
            System.err.println("No creo que este sea un cadena valida " + ex + ": " + linea);
        }
        return lectura;
    }

    public static void main(String[] args) {
//        System.out.println(trama("s1:516s2:314s3:1023s4:345e:12f").toString());
//        System.out.println(trama("s1:51s2:31s3:1000s4:545e:7f").toString());
//        System.out.println(trama("s1:245s2:0s3:690s4:0e:3f").toString());
        Archivo a = ArchivoIO.leer();
        //System.out.println(a.toString());
        new GraficaXY("Prueba").mostrar(a);
    }
}
