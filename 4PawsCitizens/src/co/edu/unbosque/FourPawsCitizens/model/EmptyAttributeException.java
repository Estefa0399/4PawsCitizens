package co.edu.unbosque.FourPawsCitizens.model;

public class EmptyAttributeException extends Exception {

	/** 
	 * @author Juana Valentina Torres Parrado
	 * Creación de excepción cuando esta vacio un atributo o sin definir.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyAttributeException() {
		super("El atributo esta vacio o sin identificar");
	}
	

}
	
