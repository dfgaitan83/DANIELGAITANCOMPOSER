package co.edu.ucatolica.vista;

import javax.swing.JOptionPane;



public class Vista {
	
	
	public void printEstrofa (String a) {
			
		JOptionPane.showMessageDialog(null, a);
	}
	
	
	public static int estrofas () {
		
		try {
			
			int datoNro1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de estrofas, por favor: "));
			return datoNro1;
		}
		catch(java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Coloca un valor valido,para seguir con el proyecto reguetonero!por favor");
			estrofas();
		}
		return 0;
		
	}
	
	public static int frases () {
		
		try {
			int datoNro1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de de frases, por favor"));
			return datoNro1;
		}
		catch(java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite un valor valido, por favor");
			frases();
		}
		return 0;
		}
	
	
	
	public int NuestroMenu() {
		try {
			int dato1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que le gustaria ejecutar, para ello digite el numero para ejecutar gracias: \n------------------------------------------------------------------------------------------------------------ "
					+ "\n OPCIÓN 1: Numero de estrofas y de frases"
					+ "\n------------------------------------------------------------------------------------ "
					+ "\n OPCIÓN 2: Generación canción y guardarla"
					+ "\n------------------------------------------------------------------------------------ "
					+ "\n OPCIÓN 3: Selección de carpeta para imprimir"
					+ "\n------------------------------------------------------------------------------------ "
					+ "\n OPCIÓN 4: Salida"
					+"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° "));
			
			return dato1;
		}
			
		    catch(java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite un valor valido, por favor");
			}
			return 0;
			}
}

