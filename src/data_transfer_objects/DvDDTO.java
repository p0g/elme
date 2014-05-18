package data_transfer_objects;

public class DvDDTO extends MediumDTO {

	// Attribute
	private int fsk; // vlt eine enumeration erstellen?
	private int spieldauer;

	// Konstruktor
	public DvDDTO(int id, boolean entliehen, String titel, int jahr, int fsk, int spieldauer) {
		super(id, titel, jahr, entliehen);
		signatur = "DVD-" + mediumID;

		this.fsk = fsk;
		this.spieldauer = spieldauer;
	}

	// Methoden
	public int getFsk() {
		return fsk;
	}

	public int getSpieldauer() {
		return spieldauer;
	}

}
