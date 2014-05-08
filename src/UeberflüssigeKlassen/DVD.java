package UeberflüssigeKlassen;


public class DVD extends Medium {
	
	//Attribute
	private int fsk; //vlt eine enumeration erstellen?
	private int spieldauer;

	//Konstruktor
	public DVD(String titel, int jahr, int fsk, int spieldauer) {
		super(titel, jahr);
		signatur="DVD-" + mediumID;
		
		this.fsk=fsk;
		this.spieldauer=spieldauer;
	}

	//Methoden
	public int getFsk() {
		return fsk;
	}

	public void setFsk(int fsk) {
		this.fsk = fsk;
	}

	public int getSpieldauer() {
		return spieldauer;
	}

	public void setSpieldauer(int spieldauer) {
		this.spieldauer = spieldauer;
	}
}
