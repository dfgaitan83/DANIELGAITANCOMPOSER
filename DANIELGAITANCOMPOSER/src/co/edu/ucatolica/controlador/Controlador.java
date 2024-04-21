package co.edu.ucatolica.controlador;

import java.io.IOException;

import co.edu.ucatolica.modelo.CrearCanción;
import co.edu.ucatolica.vista.Vista;

public class Controlador {
    int estrofas;
    int frases;

    public Controlador() {
        Vista vistaNr1 = new Vista();
        CrearCanción modelo1 = new CrearCanción();

        int opcion;
        do {
            opcion = vistaNr1.NuestroMenu();
            
            
            switch (opcion) {
                case 1:
                    ingresarDatos();
                    break;
                
                case 2:
                    generarCancion(modelo1);
                    break;
                
                case 3:
                    mostrarCancion(modelo1);
                    break;
                
                case 4:
                    System.out.println("BUEN TRABAJO, ¡haz creado una nueva obra de arte para tus oídos!");
                    break;
                
                default:
                    System.out.println("SEÑOR USUARIO, introduzca una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

   
    
    private void ingresarDatos() {
        estrofas = Vista.estrofas();
        frases = Vista.frases();
    }

    
    
    private void generarCancion(CrearCanción generador) {
        if (estrofas > 0 && frases > 0) {
            generador.depositarCancion(estrofas, frases);
        } else {
            System.out.println("Primero debe ingresar el número de estrofas y frases.");
        }
    }

    private void mostrarCancion(CrearCanción generador) {
        generador.seleccymuestrecancíon();
    }
}
