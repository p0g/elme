public class CD extends Medium {

	// Attribute
	private String interpret;
	private String label;

	// Konstruktor
	public CD(String titel, int jahr, String interpret, String label) {
		super(titel, jahr);
		signatur = "CD-" + mediumID;

		this.interpret = interpret;
		this.label = label;
	}

	// Methoden
	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
