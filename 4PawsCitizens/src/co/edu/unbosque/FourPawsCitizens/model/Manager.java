package co.edu.unbosque.FourPawsCitizens.model;

import co.edu.unbosque.FourPawsCitizens.model.persistence.*;

public class Manager {

	private PetDAO petDao;
	private Pet pet;
	
	public Manager() {
		petDao = new PetDAO();
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
