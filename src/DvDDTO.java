
public class DvDDTO extends MediumDTO {

	//Attribute
	private int fsk; //vlt eine enumeration erstellen?
	private int spieldauer;
	
	//Konstruktor
	public DvDDTO(String titel, int jahr, int fsk, int spieldauer) {
		super(titel, jahr);
		signatur="DVD-" + mediumID;
		
		this.fsk=fsk;
		this.spieldauer=spieldauer;
	}
	
	//Methoden
	public int getFsk() {
		return fsk;
	}

	public int getSpieldauer() {
		return spieldauer;
	}
	
	

}
