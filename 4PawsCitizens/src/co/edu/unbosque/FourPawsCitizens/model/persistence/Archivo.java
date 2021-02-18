package co.edu.unbosque.FourPawsCitizens.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.FourPawsCitizens.model.*;

public class Archivo {
	
	private String ruta="./Data/pets-citizens.csv";
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private File filePet;

	public Archivo() {
		filePet = new File(ruta);
		if (filePet.exists()) {
			System.out.println("Archivo existe");
		} else {
			try {
				filePet.createNewFile();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	
	}


	public  ArrayList<Pet> readFile() {

		ArrayList<Pet> alPet = new ArrayList<Pet>();
		String linea = "";
		String cadena = "";


		try {
			FileReader fr = new FileReader(filePet); // fr-> Crea el flujo desde f
			BufferedReader br = new BufferedReader(fr); // br ->permite la lectura
			linea = br.readLine(); // linea toma el valor de la primera linea leída
			while (linea != null) { // mientras haya datos por leer en el archivo
				String [] partes=linea.split(";");
				try {
					
					linea = br.readLine(); // leer el valor de la siguiente linea
				}catch( NumberFormatException e) {
					
					linea = br.readLine(); // leer el valor de la siguiente linea
				}
				
			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return alPet;
	}


}
