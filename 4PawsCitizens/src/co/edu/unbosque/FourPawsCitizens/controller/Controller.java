package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.Manager;
import co.edu.unbosque.FourPawsCitizens.view.View;

public class Controller {
	private Manager model;
	private View view;

	public Controller() {
		model = new Manager();
		view = new View();
	}

}