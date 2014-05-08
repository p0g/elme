package UeberflüssigeKlassen;


public class Buch extends Medium {
	
	//Attribute
	private String verfasser;
	private String verlag;
	private String isbn;
	
	//Konstruktor
	public Buch(String titel, int jahr, String verfasser, String verlag, String isbn) {
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

	public void setVerfasser(String verfasser) {
		this.verfasser = verfasser;
	}

	public String getVerlag() {
		return verlag;
	}

	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
