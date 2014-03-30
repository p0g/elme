
public abstract class Medium {

	//Attribute
	private static int ANZAHL=0;
	protected int mediumID;
	protected String signatur;
	protected String titel;
	protected int jahr;
	
	//Konstruktor
	public Medium(String titel, int jahr){
		mediumID=ANZAHL++;
		this.titel=titel;
		this.jahr=jahr;
		
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
	
	
	
}
