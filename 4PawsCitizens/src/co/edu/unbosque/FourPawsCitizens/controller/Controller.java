package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.persistence.*;
import co.edu.unbosque.FourPawsCitizens.view.*;

public class Controller {
	private Manager model;
	private View view;

	public Controller() {
		model = new Manager();
		view = new View();
		model.generatePet();
		long microchip=0;
		String species="";
		char option='S';
		
		int a = view.showMenu();
		switch (a) {
		case 1:
			view.printMessage(model.assignID());
			break;
		case 2:
			view.printMessage("Por favor ingrese el microchip");
			microchip=Long.parseLong(view.captureData(null));
			view.printMessage(model.findByMicrochip(microchip));
			break;
		case 3:
			view.printMessage("Ingrese la especie a contar");
			
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		
		}
	}

}