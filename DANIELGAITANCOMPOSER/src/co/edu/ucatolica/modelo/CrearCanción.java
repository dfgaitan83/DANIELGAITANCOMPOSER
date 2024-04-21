package co.edu.ucatolica.modelo;

import java.io.*;
import javax.swing.*;

public class CrearCanción {
    static String[] nuestraPrimeraP= {"Lokita","bellaquita","Mamasita","bebesita","Girl","Señorita"};
    static String[] nuestraSegundaP= {"yo quiero","yo puedo","voy a","quisiera","vengo de", "fui a"};
    static String[] nuestraTerceraP= {"janguear","darte","ligarte","comerte","bellaquear","dialogarlo"};
    static String[] nuestraCuartaP= {"suave  aaaaa","lento","rapido","fuerte","suavesito","desentemente"};
    static String[] nuestraQuintaP= {"hasta reventarte de pasíon prr real hasta la muerte","toda la noche","hasta amanecer","toda el dia","hasta atardecer"};

    public static int generarNumeroAleatorio(){
        int numero;
        do {
            numero = (int)(Math.random() * 10);
        } while (numero > 4);
        return numero;
    }

    public String genearchivo(int estrofas, int versos) {
        StringBuilder contenido = new StringBuilder();

        for (int i = 0; i < estrofas; i++) {
            StringBuilder estrofa = new StringBuilder();
            for (int j = 0; j < versos; j++) {
                int indexPri = generarNumeroAleatorio();
                int indexSeg = generarNumeroAleatorio();
                int indexTer = generarNumeroAleatorio();
                int indexCua = generarNumeroAleatorio();
                int indexQui = generarNumeroAleatorio();
                
                estrofa.append(nuestraPrimeraP[indexPri]).append(" ")
                      .append(nuestraSegundaP[indexSeg]).append(" ")
                      .append(nuestraTerceraP[indexTer]).append(" ")
                      .append(nuestraCuartaP[indexCua]).append(" ")
                      .append(nuestraQuintaP[indexQui]).append("\n");
            }
            contenido.append(estrofa.toString()).append("\n");
        }

        return contenido.toString();
    }

    public void depositarCancion(int estrofas, int versos) {
        String cancion = genearchivo(estrofas, versos);

        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (FileWriter escritor = new FileWriter(archivo)) {
                escritor.write(cancion);
                JOptionPane.showMessageDialog(null, "Canción guardada exitosamente en " + archivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar la canción");
                e.printStackTrace();
            }
        }
    }

    public void seleccymuestrecancíon() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                JOptionPane.showMessageDialog(null, contenido.toString(), "tema reguetonero", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, " Se ha genereado un error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
//hola