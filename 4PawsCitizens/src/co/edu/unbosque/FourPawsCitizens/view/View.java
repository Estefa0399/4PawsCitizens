package co.edu.unbosque.FourPawsCitizens.view;

import java.util.Scanner;

public class View {
	private Scanner read;

	public View() {
		read = new Scanner(System.in);
	}

	/**
	 * @author Juana Valentina Torres Parrado
	 * 
	 *         Método void que imprime en consola un string
	 * @param String m
	 * 
	 */
	public void printMessage(String m) {
		System.out.println(m);
	}

	/**
	 * @author Juana Valentina Torres Parrado
	 * 
	 *Metodo que retorna un número entero (int) capturado de lo ingresado en la consola         
	 * @param String m
	 */
	public int captureNumber(String m) {
		int resultado = 0;

		try {
			m = read.nextLine();
			resultado = Integer.parseInt(m);
		} catch (NumberFormatException e) {
			printMessage("Es necesario que ingrese un número. Intente de nuevo.");
			resultado = 0;

		}

		return resultado;
	}

	/**
	 * @author Juana Valentina Torres Parrado
	 * Metodo que retorna String capturado de lo ingresado en la consola 
	 * @param String m
	 */
	public String captureData(String m) {
		String resultado = "";
		m = read.nextLine();
		resultado = m;
		return resultado;

	}

	/**
	 * @author Juana Valentina Torres Parrado y Estefania Galindo Merchan
	 * 
	 * Metodo que muestra un menu
	 * que retorna un numero entero (int) capturado de la consola
	 */
	public int showMenu() {
		int option = 0;
		while (option < 1 || option > 6) {
			printMessage("Ingrese el numero que corresponda a su opcion a seguir:" + "\n" + "[1] Asignar ID." + "\n"
					+ "[2] Buscar por Microchip." + "\n" + "[3] Contar por especies." + "\n"
					+ "[4] Animales peligrosos por localidad." + "\n"
					+ "[5] Buscar por las siguientes características: Sexo, Especie, Tamaño y Peligro." + "\n"
					+ "[6] Finalizar programa.");
			option = captureNumber(null);

		}
		return option;
	}
}
