package co.edu.unbosque.FourPawsCitizens.model;
/**
 * 
 * @author Juanma Perez
 *
 */
public class Pet {

	private String id;
	private long microchip;
	private String species;
	private String sex;
	private String size;
	private boolean potentiallyDangerous;
	private String neighborhood;

/**
 * Metodo publico Pet que sirve constructor de la clase
 * 
 * @param pId
 * @param pMicrochip
 * @param pSpecies
 * @param pSex
 * @param pSize
 * @param pPotentiallyDangerous
 * @param pNeighborhood
 */
public Pet(String pId, long pMicrochip, String pSpecies, String pSex, String pSize, boolean pPotentiallyDangerous,
			String pNeighborhood) {

		this.id = pId;
		this.microchip = pMicrochip;
		this.species = pSpecies;
		this.sex = pSex;
		this.size = pSize;
		this.potentiallyDangerous = pPotentiallyDangerous;
		this.neighborhood = pNeighborhood;

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the microchip
	 */
	public long getMicrochip() {
		return microchip;
	}

	/**
	 * @param microchip the microchip to set
	 */
	public void setMicrochip(long microchip) {
		this.microchip = microchip;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the potentiallyDangerous
	 */
	public boolean isPotentiallyDangerous() {
		return potentiallyDangerous;
	}

	/**
	 * @param potentiallyDangerous the potentiallyDangerous to set
	 */
	public void setPotentiallyDangerous(boolean potentiallyDangerous) {
		this.potentiallyDangerous = potentiallyDangerous;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", microchip=" + microchip + ", species=" + species + ", sex=" + sex + ", size=" + size
				+ ", potentiallyDangerous=" + potentiallyDangerous + ", neighborhood=" + neighborhood + "]";
	}

}
