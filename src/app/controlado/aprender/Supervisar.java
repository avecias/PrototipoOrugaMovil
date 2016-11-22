/*
Supervisar previamente para poder aprender
 */
package app.controlado.aprender;

import app.controlado.sesion.Sesion;
import app.modelo.entidades.ArchivosCargado;
import app.modelo.entidades.Clase;
import app.modelo.entidades.Fusion;
import app.modelo.entidades.Punto;
import app.modelo.entidades.Trama;
import app.vista.graficas.IGAprendizajeSupervisado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Supervisar {

    public Supervisar() {
    }

    public void hacer(JMenuItem menuVer, IGAprendizajeSupervisado aprendizajeSupervisado, Sesion sesion, JTabbedPane tabPanel) {
        // Supervisar agregando un valo de k menas a cada grafica
        int k1, k2, k3;
        try {
            tabPanel.setSelectedIndex(0);
            k1 = Integer.valueOf(JOptionPane.showInputDialog("Inserte el valor de k1"));
            tabPanel.setSelectedIndex(1);
            k2 = Integer.valueOf(JOptionPane.showInputDialog("Inserte el valor de k2"));
            tabPanel.setSelectedIndex(2);
            k3 = Integer.valueOf(JOptionPane.showInputDialog("Inserte el valor de k3"));
            sesion.getFusion().setK1(k1);
            sesion.getFusion().setK2(k2);
            sesion.getFusion().setK3(k3);
            JOptionPane.showMessageDialog(aprendizajeSupervisado, "Valor de k1 = " + k1 + ", Valor de k2 = " + k2 + ", Valor de k3 = " + k3);
            aprendizajeSupervisado.setVisible(false);
            aprendizajeSupervisado.dispose();
            menuVer.setEnabled(true);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(aprendizajeSupervisado, "Este no es un numero " + e, "No es numero", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(aprendizajeSupervisado, "No hay valor" + e, "No es numero", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar(JMenuItem menuVer, Sesion sesion, JTable tabla) {
        // Mostrar el resultado de la combinacion de sensores
        // Guardar los datos fucionados en la session
        if (sesion.getArchivosCargados().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun archivo cargado");
            return;
        }
        //Checar si se esta seleccionando algun elemento en la tabla
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemeto de la tabla", "Ningun elemento seleccionado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Pasar a la interfaz grafica del clasificador
        ArchivosCargado archivo = sesion.getArchivosCargados().get(tabla.getSelectedRow());
        Fusion fusion = sesion.getFusion();
        List<Clase[]> fusionados = fusionar(archivo, fusion);
        sesion.setFusionados(fusionados);
        new IGAprendizajeSupervisado(menuVer, sesion, fusionados).setVisible(true);
    }

    public List<Clase[]> fusionar(ArchivosCargado archivo, Fusion fusion) {
        List<Clase[]> fusionados = new ArrayList<>();
        // Fucionar los datos para desplegralos en clases y de terminar las dimensiones
        if (fusion.getFusion1().length == Fusion.DOS_DIMENSIONES) {
            fusionados.add(dosDimensiones(archivo, fusion.getFusion1()));
        } else {
            fusionados.add(tresDimensiones(archivo, fusion.getFusion1()));
        }
        if (fusion.getFusion2().length == Fusion.DOS_DIMENSIONES) {
            fusionados.add(dosDimensiones(archivo, fusion.getFusion2()));
        } else {
            fusionados.add(tresDimensiones(archivo, fusion.getFusion2()));
        }
        if (fusion.getFusion3().length == Fusion.DOS_DIMENSIONES) {
            fusionados.add(dosDimensiones(archivo, fusion.getFusion3()));
        } else {
            System.out.println("Primera fusion " + fusion.getFusion3().length);
            fusionados.add(tresDimensiones(archivo, fusion.getFusion3()));
        }
        return fusionados;
    }

    private Clase[] dosDimensiones(ArchivosCargado archivo, String[] fusion1) {
        Clase[] clase = new Clase[1];
        clase[0] = new Clase();
        clase[0].setDimension(Fusion.DOS_DIMENSIONES);
        switch (fusion1[0]) {
            case "Temperatura":
                switch (fusion1[1]) {
                    case "Gas":
                        unirTemperaturaGas(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Humo":
                        unirTemperaturaHumo(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Fuego":
                        unirTemperaturaFuego(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Sonido":
                        unirTemperaturaSonido(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    default:
                        break;
                }
                break;
            case "Gas":
                switch (fusion1[1]) {
                    case "Temperatura":
                        unirGasTemperatura(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Humo":
                        unirGasHumo(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Fuego":
                        unirGasFuego(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Sonido":
                        unirGasSonido(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    default:
                        break;
                }
                break;
            case "Humo":
                switch (fusion1[1]) {
                    case "Temperatura":
                        unirHumoTemperatura(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Gas":
                        unirHumoGas(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Fuego":
                        unirHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Sonido":
                        unirHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    default:
                        break;
                }
                break;
            case "Fuego":
                switch (fusion1[1]) {
                    case "Temperatura":
                        unirFuegoTemperatura(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Gas":
                        unirFuegoGas(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Humo":
                        unirFuegoHumo(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Sonido":
                        unirFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    default:
                        break;
                }
                break;
            case "Sonido":
                switch (fusion1[1]) {
                    case "Temperatura":
                        unirSonidoTemperatura(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Gas":
                        unirSonidoGas(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Humo":
                        unirSonidoHumo(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    case "Fuego":
                        unirSonidoFuego(archivo.getLectura().getTramas(), clase[0]);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return clase;
    }

    private void unirTemperaturaGas(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaYGas");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getGas()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaHumo(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaYHumo");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getHumo()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaYFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaYSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasTemperatura(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasYTemperatura");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getTemperatura()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasHumo(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasYHumo");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getHumo()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasYFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasYSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirHumoTemperatura(List<Trama> tramas, Clase clase) {
        clase.setNombre("HumoYTemperatura");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getHumo(), tramas.get(i).getTemperatura()));
        }
        clase.setPuntos(lista);
    }

    private void unirHumoGas(List<Trama> tramas, Clase clase) {
        clase.setNombre("HumoYGas");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getHumo(), tramas.get(i).getGas()));
        }
        clase.setPuntos(lista);
    }

    private void unirHumoFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("HumoYFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getHumo(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirHumoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("HumoYSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getHumo(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirFuegoTemperatura(List<Trama> tramas, Clase clase) {
        clase.setNombre("FuegoYTemperatura");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getLlama(), tramas.get(i).getTemperatura()));
        }
        clase.setPuntos(lista);
    }

    private void unirFuegoGas(List<Trama> tramas, Clase clase) {
        clase.setNombre("FuegoYTemperatura");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getLlama(), tramas.get(i).getGas()));
        }
        clase.setPuntos(lista);
    }

    private void unirFuegoHumo(List<Trama> tramas, Clase clase) {
        clase.setNombre("FuegoYHumo");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getLlama(), tramas.get(i).getHumo()));
        }
        clase.setPuntos(lista);
    }

    private void unirFuegoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("FuegoYSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getLlama(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirSonidoTemperatura(List<Trama> tramas, Clase clase) {
        clase.setNombre("SonidoYTemperatura");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getSonido(), tramas.get(i).getTemperatura()));
        }
        clase.setPuntos(lista);
    }

    private void unirSonidoGas(List<Trama> tramas, Clase clase) {
        clase.setNombre("SonidoYGas");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getSonido(), tramas.get(i).getGas()));
        }
        clase.setPuntos(lista);
    }

    private void unirSonidoHumo(List<Trama> tramas, Clase clase) {
        clase.setNombre("SonidoYHumo");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getSonido(), tramas.get(i).getHumo()));
        }
        clase.setPuntos(lista);
    }

    private void unirSonidoFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("SonidoYFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getSonido(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private Clase[] tresDimensiones(ArchivosCargado archivo, String[] fusion1) {
        Clase[] clase = new Clase[1];
        clase[0] = new Clase();
        clase[0].setDimension(Fusion.TRES_DIMENSIONES);
        switch (fusion1[0]) {
            // Temperatura
            case "Temperatura":
                switch (fusion1[1]) {
                    // gas
                    case "Gas":
                        switch (fusion1[2]) {
                            case "Humo":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaGasFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaGasSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Humo":
                        // Humo
                        switch (fusion1[2]) {
                            case "Gas":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Fuego":
                        // Fuego
                        switch (fusion1[2]) {
                            case "Gas":
                                unirTemperaturaGasFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Humo":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Sonido":
                        // Sonido
                        switch (fusion1[2]) {
                            case "Gas":
                                unirTemperaturaGasSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Humo":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            //  GAS -------------
            case "Gas":
                switch (fusion1[1]) {
                    // gas
                    case "Temperatura":
                        switch (fusion1[2]) {
                            case "Humo":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaGasFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaGasSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Humo":
                        // Humo
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirGasHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirGasHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Fuego":
                        // Fuego
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaGasFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Humo":
                                unirGasHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirGasFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Sonido":
                        // Sonido
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaGasSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Humo":
                                unirGasHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirGasFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            //  HUMO-------------
            case "Humo":
                switch (fusion1[1]) {
                    // gas
                    case "Temperatura":
                        switch (fusion1[2]) {
                            case "Gas":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Gas":
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaGasHumo(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Fuego":
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Gas":
                                unirGasHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirGasFuegoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Sonido":
                        // Sonido
                        switch (fusion1[2]) {
                            case "Temperatura":
                                unirTemperaturaGasSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Gas":
                                unirGasHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Fuego":
                                unirHumoSonidoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            //  FUEGO-------------
            case "Fuego":
                switch (fusion1[1]) {
                    case "Temperatura":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Gas":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Humo":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Sonido":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            //  SONIDO-------------
            case "Sonido":
                switch (fusion1[1]) {
                    case "Temperatura":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Gas":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Humo":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Sonido":
                        switch (fusion1[2]) {
                            case "Fuego":
                                unirTemperaturaHumoFuego(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            case "Sonido":
                                unirTemperaturaHumoSonido(archivo.getLectura().getTramas(), clase[0]);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return clase;
    }

    private void unirTemperaturaGasHumo(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaGasHumo");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getGas(), tramas.get(i).getHumo()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaGasFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaGasFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getGas(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaGasSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaGasSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getGas(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaHumoFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaHumoFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getHumo(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaHumoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("unirTemperaturaHumoSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getHumo(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirTemperaturaFuegoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("TemperaturaFuegoSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getTemperatura(), tramas.get(i).getLlama(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasHumoFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasHumoFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getHumo(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasHumoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasHumoSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getHumo(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirGasFuegoSonido(List<Trama> tramas, Clase clase) {
        clase.setNombre("GasFuegoSonido");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getGas(), tramas.get(i).getLlama(), tramas.get(i).getSonido()));
        }
        clase.setPuntos(lista);
    }

    private void unirHumoSonidoFuego(List<Trama> tramas, Clase clase) {
        clase.setNombre("HumoSonidoFuego");
        List<Punto> lista = new ArrayList<>();
        for (int i = 0; i < tramas.size(); i++) {
            lista.add(new Punto(i, tramas.get(i).getHumo(), tramas.get(i).getSonido(), tramas.get(i).getLlama()));
        }
        clase.setPuntos(lista);
    }
}
