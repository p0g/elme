public class Adresse {

	//Attribute der Adresse
	private String strasse;
	private int hausnummer;
	private int plz;
	private String ort;
	private String land;

	//Konstruktor
	public Adresse(String strasse, int hausnummer, int plz, String ort, String land) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
	}

	//Methoden
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}
	
	public void druckeDaten(){
		System.out.println(strasse + hausnummer);
		System.out.println(plz + ort);
		System.out.println(land);
		
	}
	
}
