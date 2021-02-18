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

	public void escribirEnArchivo(ArrayList<Pet> alPet) {
		try {
			System.out.println(filePet);
			out = new ObjectOutputStream(new FileOutputStream(filePet));
			out.writeObject(alPet);
			out.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public ArrayList<Pet> leerArchivo() {

		ArrayList<Pet> alPet = new ArrayList<Pet>();
		if (filePet.length() != 0) {
			try {
				in = new ObjectInputStream(new FileInputStream(filePet));
				alPet = (ArrayList<Pet>) in.readObject();
			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}
		}
		return alPet;
	}

}
