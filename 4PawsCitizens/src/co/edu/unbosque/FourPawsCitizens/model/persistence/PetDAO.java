package co.edu.unbosque.FourPawsCitizens.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.FourPawsCitizens.model.Pet;

public class PetDAO {

	private ArrayList<Pet> alPet;
	private Archivo file;

	/**
	 * @author Estefania Galindo Constructor de la clase
	 * @param archivo
	 */
	public PetDAO() {
		file = new Archivo();
		alPet = new ArrayList<Pet>();
	}
	 
	

}
