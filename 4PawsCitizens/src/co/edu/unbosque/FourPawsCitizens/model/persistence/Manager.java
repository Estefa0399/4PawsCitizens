package co.edu.unbosque.FourPawsCitizens.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.FourPawsCitizens.model.*;

public class Manager {

	private Pet pet;
	private ArrayList<Pet> alPet;
	private Archivo file;

	/**
	 * @author Estefania Galindo Constructor de la clase
	 * @param archivo
	 */
	public Manager() {

		file = new Archivo();
		alPet = new ArrayList<Pet>();
	}

	/**
	 * @author Juana Torres Este metodo void se encarga de manejar la exepcion
	 *         'EmptyAttributeException'
	 * 
	 * @param attribute
	 * @throws EmptyAttributeException
	 */
	public void handleException(String attribute) throws EmptyAttributeException {
		if (attribute.equals("SIN IDENTIFICAR")) {
			throw new EmptyAttributeException();
		}
		if (attribute.isEmpty()) {
			throw new EmptyAttributeException();
		}
	}

	/**
	 * @author Estefania Galindo Este método String sirve para cargar el archivo CSV
	 *         <b>pre</b> la clase archivo ha sido inicializada con la variable file
	 * @return mensaje "El proceso de carga del archivo ha finalizado"
	 */
	public String uploadData() {

		file.readFile();

		return "El proceso de carga del archivo ha finalizado";
	}

	/**
	 * @author Estefania Galindo, Juana Torres este metodo void sirve para crear un
	 *         objeto de la clase Pet y guardarlo en un ArrayList
	 * @param pId
	 * @param pMicrochip
	 * @param pSpecies
	 * @param pSex
	 * @param pSize
	 * @param pPotentiallyDangerous
	 * @param pNeighborhood         <b>pre</b> el ArrayList a utilizar ha sido
	 *                              inicializado <b>post</b> objeto Pet guardado en
	 *                              el ArrayList
	 */

	public void createPet(String pId, long pMicrochip, String pSpecies, String pSex, String pSize,
			boolean pPotentiallyDangerous, String pNeighborhood) {

		pet = new Pet(pId, pMicrochip, pSpecies, pSex, pSize, pPotentiallyDangerous, pNeighborhood);

		alPet.add(pet);

	}

	/**
	 * @author Estefania Galindo, Juana Torres Este metodo void se encarga de
	 *         guardar los objetos Pet sin ";" usando el metodo createPet <b>pre</b>
	 *         se ha cargado el archivo <b>post</b> ArrayList con los objetos Pet
	 */
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
				if (partes.length > 5) {
					neighborhood = partes[5];
					handleException(size);
					handleException(neighborhood);
					handleException(id);
					handleException(partes[0]);
					handleException(species);
					handleException(sex);
					this.createPet(id, microchip, species, sex, size, potentiallyDangerous, neighborhood);

				}

			} catch (NumberFormatException | EmptyAttributeException ec) {
			}
		}

	}

	/**
	 * @author Estefania Galindo este metodo String se encarga de asignar los ID's a
	 *         los objeto Pet guardados en un ArrayList previamente <b>pre</b> el
	 *         archivo se ha cargado <b>pre</b> se han generado los objetos Pet y
	 *         guardado en un ArrayList
	 * 
	 * @return mensaje "El proceso de asignación de ID's ha finalizado"
	 */
	public String assignID() {
		String aux;
		for (int i = 0; i < alPet.size(); i++) {
			String ms = "" + alPet.get(i).getMicrochip();
			ms = ms.substring(ms.length() - 3);
			aux = ms + "-";
			String sp = (alPet.get(i).getSpecies()).substring(0, 1).toUpperCase();
			aux = aux + sp;
			String se = (alPet.get(i).getSex()).substring(0, 1).toUpperCase();
			aux = aux + se;
			String si;
			if (alPet.get(i).getSize().equals("MINIATURA")) {
				si = (alPet.get(i).getSize()).substring(0, 2).toUpperCase();
			} else {
				si = (alPet.get(i).getSize()).substring(0, 1).toUpperCase();
			}
			aux = aux + si;
			char pd;
			if (alPet.get(i).isPotentiallyDangerous() == true) {
				pd = 'T';
			} else {
				pd = 'F';
			}
			aux = aux + pd + "-" + alPet.get(i).getNeighborhood().toUpperCase();

			if (this.verificateID(aux) == true) {
				ms = "" + alPet.get(i).getMicrochip();
				ms = ms.substring(ms.length() - 4);
				aux = ms + "-" + sp + se + si + pd + "-" + alPet.get(i).getNeighborhood().toUpperCase();
			}

			alPet.get(i).setId(aux);
		}

		return "El proceso de asignación de ID's ha finalizado";
	}

	/**
	 * @author Estefania Galindo, Juana Torres Este metodo boolean sirve para
	 *         verificar que los ID's que se crearon no sean repetidos <b>pre</b> se
	 *         han generado los ID's con el metodo anterios
	 * @param id
	 * @return variable aux con el resultado del proceso
	 */
	public boolean verificateID(String id) {
		boolean aux = false;
		for (int i = 0; i < alPet.size(); i++) {
			if (id.equals(alPet.get(i).getId())) {
				aux = true;
			}
		}
		return aux;
	}

	/**
	 * @author Estefania Galindo, Juan Manuel Perez este método String sirve para
	 *         buscar un objeto Pet con el parametro solicitado <b>pre</b> se han
	 *         generado los ID's y se han verificado
	 * 
	 * @param microchip
	 * @return variable aux con el resultado del proceso
	 */
	public String findByMicrochip(long microchip) {
		String aux = "Pet not found";

		if (!alPet.isEmpty()) {
			for (int i = 0; i < alPet.size(); i++) {
				if (alPet.get(i).getMicrochip() == microchip) {
					aux = alPet.get(i).toString();
				}
			}
		}

		return aux;
	}

	/**
	 * @author Estefania Galindo, Juan Manuel Perez Este método String sirve para
	 *         contar los objetos Pet por el parametro dado <b>pre </b> Se ha
	 *         cargado el archivo y generado los objetos Pet
	 * @param species
	 * @return mensaje "El número de animales de la especie " + species + " es: " +
	 *         number
	 */
	public String countBySpecies(String species) {
		int number = 0;

		for (int i = 0; i < alPet.size(); i++) {
			if (alPet.get(i).getSpecies() == species.toUpperCase()) {

				number++;

			}
		}

		return "El número de animales de la especie " + species + " es: " + number;

	}

	/**
	 * @author Estefania Galindo Este método String sirve para encontrar n numeros
	 *         de objetos Pet segun los parametros dados <b>pre</b> Se ha cargado el
	 *         archivo y generado los objetos Pet
	 * @param n
	 * @param position
	 * @param neighborhood
	 * @return variable aux con el resultado del proceso
	 */
	public String findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {
		String aux = "";
		ArrayList<Pet> alNeighborhood = new ArrayList<Pet>();
		ArrayList<Pet> alDangerous = new ArrayList<Pet>();

		for (int i = 0; i < alPet.size(); i++) {
			if (alPet.get(i).getNeighborhood().toUpperCase() == neighborhood.toUpperCase()) {
				alNeighborhood.add(alPet.get(i));
			}
		}
		for (int i = 0; i < alNeighborhood.size(); i++) {
			if (alNeighborhood.get(i).isPotentiallyDangerous() == true) {
				alDangerous.add(alPet.get(i));
			}
		}

		switch (position) {
		case "TOP":
			for (int i = 0; i < n; i++) {
				aux = aux + "ID: " + alDangerous.get(i).getId() + "\n" + "Species: " + alDangerous.get(i).getSpecies()
						+ "\n" + "Gender: " + alDangerous.get(i).getSex() + "\n" + "Size: "
						+ alDangerous.get(i).getSize() + "\n" + "Potentially Dangerous: "
						+ alDangerous.get(i).isPotentiallyDangerous() + "\n" + "Neighborhood: "
						+ alDangerous.get(i).getNeighborhood() + "\n" + "--------------------" + "\n";
			}
			break;

		case "LAST":
			for (int i = n; n > i; i--) {
				aux = aux + "ID: " + alDangerous.get(i).getId() + "\n" + "Species: " + alDangerous.get(i).getSpecies()
						+ "\n" + "Gender: " + alDangerous.get(i).getSex() + "\n" + "Size: "
						+ alDangerous.get(i).getSize() + "\n" + "Potentially Dangerous: "
						+ alDangerous.get(i).isPotentiallyDangerous() + "\n" + "Neighborhood: "
						+ alDangerous.get(i).getNeighborhood() + "\n" + "--------------------" + "\n";
			}
		}

		return aux;
	}

	/**
	 * @author Estefania Galindo, Juan Manuel Perez Este método String sirve para
	 *         buscar objetos Pet segun los parametros dados <b>pre</b> Se ha
	 *         cargado el archivo, generado los objetos Pet y se han asignado los
	 *         ID's
	 * @param sex
	 * @param species
	 * @param size
	 * @param potentDangerous
	 * @return variable aux2 con el resultado del proceso
	 */
	public String findByMultipleFields(String sex, String species, String size, String potentDangerous) {
		String aux1 = "";
		String aux2 = "";

		String sp = (species).substring(0, 1).toUpperCase();
		aux1 = aux1 + sp;
		String se = (sex).substring(0, 1).toUpperCase();
		aux1 = aux1 + se;
		String si;
		if (size.toUpperCase().equals("MINIATURA")) {
			si = (size).substring(0, 2).toUpperCase();
		} else {
			si = (size).substring(0, 1).toUpperCase();
		}
		aux1 = aux1 + si;
		char pd = 'a';
		if (potentDangerous.toUpperCase().equals("SI")) {
			pd = 'T';
		} else if (potentDangerous.toUpperCase().equals("NO")) {
			pd = 'F';
		}
		aux1 = aux1 + pd;

		for (int i = 0; i < alPet.size(); i++) {
			String id = alPet.get(i).getId();
			if (id.substring(4, 9).equals(aux1)) {

				aux2 = aux2 + alPet.get(i).getId() + "\n";
			}
		}

		return aux2;
	}

}
