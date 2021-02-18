package co.edu.unbosque.FourPawsCitizens.model;

import co.edu.unbosque.FourPawsCitizens.model.persistence.*;

public class Manager {

	private PetDAO petDao;
	private Pet pet;
	private Archivo file;
	
	public Manager() {
		petDao = new PetDAO();
		file = new Archivo();
	}
	public void generatePet() {
		for(int i=0 ;file.readFile().size()<=i;i++ ) {
			
		}
	}
	public String assignID () {
		
		return"El proceso de asignación de ids ha finalizado";
	}
	
	public String findByMicrochip (long microchip){
		return"";	
	}
	public String countBySpecies( String species ) {
		return "“El número de animales de la especie "+ species+"es:"; 
				
	}
	public String findBypotentDangerousInNeighborhood() {
		return"";
	}
}
