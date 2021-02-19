package co.edu.unbosque.FourPawsCitizens.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.FourPawsCitizens.model.*;

public class Manager {

	private Pet pet;
	private ArrayList<Pet> alPet;
	private Archivo file;

	public Manager() {

		file = new Archivo();
		alPet = new ArrayList<Pet>();
	}

	public void createPet(String pId, long pMicrochip, String pSpecies, String pSex, String pSize,
			boolean pPotentiallyDangerous, String pNeighborhood) {

		pet = new Pet(pId, pMicrochip, pSpecies, pSex, pSize, pPotentiallyDangerous, pNeighborhood);

		alPet.add(pet);

	}

	public void generatePet() {
		String id = "NO_ID";
		long microchip;
		String species;
		String sex;
		String size;
		boolean potentiallyDangerous;
		String neighborhood;

		for (int i = 0; i < file.readFile().size(); i++) {

			String[] partes = file.readFile().get(i).split(";");
			try {

				microchip = Long.parseLong(partes[0]);
				species = partes[1];
				sex = partes[2];
				size = partes[3];
				if (partes[4].trim().toUpperCase().equals("SI")) {
					potentiallyDangerous = true;
				} else {
					potentiallyDangerous = false;
				}
				neighborhood = partes[5];
				if (species.equals("SIN IDENTIFICAR") || sex.equals("SIN IDENTIFICAR") || size.equals("SIN IDENTIFICAR")
						|| neighborhood.equals("SIN IDENTIFICAR")) {

				} else {
					this.createPet(id, microchip, species, sex, size, potentiallyDangerous, neighborhood);

				}

			} catch (NumberFormatException e) {

			}
		}

	}

	public String assignID() {
		String aux;
		for (int i = 0; i < alPet.size(); i++) {
			String ms = "" + alPet.get(i).getMicrochip();
			ms = ms.substring(ms.length() - 3);
			aux = ms + "-";
			String sp = (alPet.get(i).getSpecies()).substring(0, 1);
			aux = aux + sp;
			alPet.get(i).getSex();
			alPet.get(i).getSize();
			alPet.get(i).isPotentiallyDangerous();
			alPet.get(i).getNeighborhood();
		}

		return "El proceso de asignación de ids ha finalizado";
	}

	public boolean verificateID(String id) {
		boolean aux = false;
		for (int i = 0; i < alPet.size(); i++) {
			if (id.equals(alPet.get(i).getId())) {
				aux = true;
			}
		}
		return aux;
	}

	public String findByMicrochip(long microchip) {
		return "";
	}

	public String countBySpecies(String species) {
		return "“El número de animales de la especie " + species + "es:";

	}

	public String findBypotentDangerousInNeighborhood() {
		return "";
	}

}
