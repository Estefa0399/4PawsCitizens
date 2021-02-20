package co.edu.unbosque.FourPawsCitizens.view;

import java.util.Scanner;

public class View {
	private Scanner read;

	public View() {
		read = new Scanner(System.in);
	}

	public void printMessage(String m) {
		System.out.println(m);
	}

	public int captureNumber(String m) {
		int resultado = 0;
		do {
			try {
				m = read.nextLine();
				resultado = Integer.parseInt(m);
				return resultado;
			} catch (NumberFormatException e) {
				printMessage("Es necesario que ingrese un número. Intente de nuevo.");
				resultado = 0;
			}
		}

		while (resultado != 0);
		return resultado;
	}
	
	public String captureData(String m) {
		String resultado = "";
		m = read.nextLine();
		resultado = m;
		return resultado;

	}


	public void showMenu() {
		int option;
		printMessage("Ingrese el numero que corresponda a su opcion a seguir:" + "\n" + "[1] Asignar ID." + "\n"
				+ "[2] Buscar por Microchip." + "\n" + "[3] Contar por especies." + "\n"
				+ "[4] Animales peligrosos por localidad." + "\n"
				+ "[5] Buscar por las siguientes características: Sexo, Especie, Tamaño y Peligro." + "\n"
				+ "[6] Cargar Datos." + "\n" + "[7] Finalizar programa.");
		
	}
}
