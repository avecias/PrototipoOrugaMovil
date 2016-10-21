/*
Validar el archivo por medio de la cabecera para validar si es un archivo valido
 */
package app.controlador.archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidarArchivo {
    
    
    public boolean hacer(File archivo){
        boolean resultado = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
            String linea;
            if ((linea = br.readLine()) != null) {
                if (linea.equals("prototipomovil_v1.0")) {
                    resultado = true;
                }
            }
        }catch(IOException e){
            System.out.println("Error en leer el archivo " + e);
        }
        return resultado;
    }
}
