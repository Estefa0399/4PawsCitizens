package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.persistence.*;
import co.edu.unbosque.FourPawsCitizens.view.*;

public class Controller {
	private Manager model;
	private View view;

	public Controller() {
		model = new Manager();
		view = new View();
	}

}