package data_transfer_objects;

public class CDDTO extends MediumDTO {

	// Attribute
	private String interpret;
	private String label;

	// Konstruktor
	public CDDTO(String titel, int jahr, String interpret, String label) {
		super(titel, jahr);
		signatur = "CD-" + mediumID;

		this.interpret = interpret;
		this.label = label;
	}

	// Methoden
	public String getInterpret() {
		return interpret;
	}

	public String getLabel() {
		return label;
	}

}
