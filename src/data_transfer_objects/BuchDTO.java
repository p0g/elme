package data_transfer_objects;

public class BuchDTO extends MediumDTO {

	// Attribute
	private String verfasser;
	private String verlag;
	private String isbn;

	// Konstruktor
	public BuchDTO(int id, boolean entliehen, String titel,  int jahr, String verfasser, String verlag, String isbn) {
		super(id, titel, jahr, entliehen);
		signatur = "B-" + mediumID;

		this.verfasser = verfasser;
		this.verlag = verlag;
		this.isbn = isbn;
	}

	// Methoden
	public String getVerfasser() {
		return verfasser;
	}

	public String getVerlag() {
		return verlag;
	}

	public String getIsbn() {
		return isbn;
	}

}
