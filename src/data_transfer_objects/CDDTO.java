package data_transfer_objects;

public class CDDTO extends MediumDTO {

	// Attribute
	private String interpret;
	private String label;

	// Konstruktor
	public CDDTO(int id, boolean entliehen, String titel, int jahr, String interpret, String label) {
		super(id, titel, jahr, entliehen);
		signatur = "CD-" + mediumID;

		this.interpret = interpret;
		this.label = label;
		this.typ = "CD";
	}

	// Methoden
	public String getInterpret() {
		return interpret;
	}

	public String getLabel() {
		return label;
	}

}
