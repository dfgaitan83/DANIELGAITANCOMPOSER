package co.edu.ucatolica.modelo.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClaseArchivos {
    private String rutaCarpeta = "c:\\data";
    private String rutaArchivo = "c:\\data\\cancion.txt";

    public int guardarContenido(String contenido) {
        File carpetaDatos = new File(rutaCarpeta);
        File archivo = new File(rutaArchivo);

        if (!carpetaDatos.exists()) {
            carpetaDatos.mkdirs(); 
        }

        try {
            FileWriter escritor = new FileWriter(archivo);
            escribirContenido(escritor, contenido);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    private void escribirContenido(FileWriter escritor, String contenido) throws IOException {
        PrintWriter pw = new PrintWriter(escritor);
        pw.println(contenido);
        escritor.close();
    }

    public String obtenerContenido() {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            leerContenido(br, lineas);
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return unirLineas(lineas);
    }

    private void leerContenido(BufferedReader lector, List<String> lineas) throws IOException {
        String linea = lector.readLine();
        while (linea != null) {
            lineas.add(linea);
            linea = lector.readLine();
        }
    }

    private String unirLineas(List<String> lineas) {
        return String.join(System.lineSeparator(), lineas);
    }
}
