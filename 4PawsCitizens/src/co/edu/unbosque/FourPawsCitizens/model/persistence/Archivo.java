package co.edu.unbosque.FourPawsCitizens.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.FourPawsCitizens.model.*;

public class Archivo {
	
	private String route="./Data/pets-citizens.csv";
	private File filePet;

	public Archivo() {
		filePet = new File(route);
	
	}
	public  ArrayList<String> readFile() {

		String linea = "";

		ArrayList<String>  cadena =new ArrayList<String> ();

		try {
			FileReader fr = new FileReader(filePet); // fr-> Crea el flujo desde f
			BufferedReader br = new BufferedReader(fr); // br ->permite la lectura
			linea = br.readLine(); // linea toma el valor de la primera linea leída
			while (linea != null) { // mientras haya datos por leer en el archivo
				cadena.add(linea) ;       //acumular en cadena lo leido en linea
				linea = br.readLine(); //leer el valor de la siguiente linea
				
			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return cadena;
	}


}
