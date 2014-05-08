package UeberflüssigeKlassen;

/**
 * Oberklasse aller Medien
 */
public abstract class Medium {

	//Attribute
	private static int ANZAHL=0;
	protected int mediumID;
	protected String signatur;
	protected String titel;
	protected int jahr;
	protected boolean entliehen;
	
	//Konstruktor
	public Medium(String titel, int jahr){
		mediumID=ANZAHL++;
		this.titel=titel;
		this.jahr=jahr;
		entliehen=false;
		
	}

	//Methoden 
	public int getMediumID() {
		return mediumID;
	}

	public void setMediumID(int mediumID) {
		this.mediumID = mediumID;
	}

	public String getSignatur() {
		return signatur;
	}

	public void setSignatur(String signatur) {
		this.signatur = signatur;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	public boolean isEntliehen(){
		return this.entliehen;
	}
	
	public void setEntliehen(boolean entliehen){
		this.entliehen=entliehen;
	}
	
	public String toString(){
		return this.titel;
	}
}
