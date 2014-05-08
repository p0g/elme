
public class BuchDTO extends MediumDTO {

	//Attribute
	private String verfasser;
	private String verlag;
	private String isbn;
	
	//Konstruktor
	public BuchDTO(String titel, int jahr, String verfasser, String verlag, String isbn) {
		super(titel, jahr);
		signatur="B-" + mediumID;
		
		this.verfasser=verfasser;
		this.verlag=verlag;
		this.isbn=isbn;
	}
	
	//Methoden
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
