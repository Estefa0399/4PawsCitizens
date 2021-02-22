package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.EmptyAtrributeException;
import co.edu.unbosque.FourPawsCitizens.model.persistence.*;
import co.edu.unbosque.FourPawsCitizens.view.*;

public class Controller {

	private Manager model;
	private View view;

	public Controller() throws EmptyAtrributeException {
		model = new Manager();
		view = new View();

		view.printMessage(model.uploadData()+ "\nAdvertencia. Este proceso tarda unos minutos.");
		model.generatePet();

		long microchip = 0;
		int number = 0;
		String position = "";
		String species = "";
		String neighborhood = "";
		String sex;
		String size;
		String potentDangerous;
		String option = "S";
		
		while ("S".equals(option.toUpperCase())) {
		int a = view.showMenu();		

			switch (a) {
			case 1:
				view.printMessage(model.assignID());
				break;
			case 2:
				view.printMessage("Por favor ingrese el microchip");
				microchip = Long.parseLong(view.captureData(null));
				view.printMessage(model.findByMicrochip(microchip));
				break;
			case 3:
				view.printMessage("Ingrese la especie a contar");
				species = view.captureData(null);
				view.printMessage(model.countBySpecies(species));
				break;
			case 4:
				view.printMessage("Ingrese la localidad a buscar");
				neighborhood = view.captureData(null);
				view.printMessage("Ingrese la cantidad de animales que desea buscar");
				number = view.captureNumber(null);
				view.printMessage("Ingrese 'TOP' o 'LAST' segun desee para la busqueda de su info");
				position = view.captureData(null);
				view.printMessage(model.findBypotentDangerousInNeighborhood(number, position, neighborhood));
				break;
			case 5:
				view.printMessage("Ingrese las caracteristicas");
				view.printMessage("Sexo");
				sex = view.captureData(null);
				view.printMessage("Especie");
				species = view.captureData(null);
				view.printMessage("Tamaño");
				size = view.captureData(null);
				view.printMessage("Si es altamente peligroso ('SI'/'NO')");
				potentDangerous = view.captureData(null);
				view.printMessage(model.findByMultipleFields(sex, species, size, potentDangerous));
				break;
			case 6:
				view.printMessage("Ha finalizado el programa");
				break;

			}
			view.printMessage("Ha finalizado su opción");
			view.printMessage("Desea continuar <S/N>:");
			option = view.captureData(null).toUpperCase();

		}
	}

}