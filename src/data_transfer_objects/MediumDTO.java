package data_transfer_objects;
/*
 * Data Transfer - Klasse für Medien
 */
public abstract class MediumDTO {

	// Attribute
	protected int mediumID;
	protected String signatur;
	protected String titel;
	protected int jahr;
	protected boolean entliehen;
	protected String typ;

	// Konstruktor
	public MediumDTO(int id, String titel, int jahr, boolean entliehen) {
		this.mediumID = id;
		this.titel = titel;
		this.jahr = jahr;
		this.entliehen = entliehen;
	}

	// Methoden
	public int getMediumID() {
		return mediumID;
	}

	public String getSignatur() {
		return signatur;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}

	public boolean isEntliehen() {
		return entliehen;
	}

	public void setEntliehen(boolean value) {
		this.entliehen = value;
	}
	
	public String getTypName() {
		return typ;
	}
	
	public String toString(){
		return this.titel;
	}

}
