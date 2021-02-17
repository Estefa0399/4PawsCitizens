package co.edu.unbosque.FourPawsCitizens.view;

import java.util.Scanner;

public class View {
	private Scanner leer;

	public View() {
		leer = new Scanner(System.in);
	}

	public void imprimirMensaje(String m) {
		System.out.println(m);
	}

	public String capturarDato(String m) {
		String resultado = "";
		m = leer.nextLine();
		resultado = m;
		return resultado;

	}
}
