import java.util.Date;


public class Mitglied {
	
	//Atribute
	private String name;
	private String vorname;
	private String benutzername;
	private String passwort;
	private Adresse adresse;
	private String geburtsdatum;
	private int mitgliedID;
	//statische Variable nur für internen Gebrauch. initial 1, weil sonst die generierung der benutzernamen bei 0 beginnen würde!
	private static int ANZAHL=1;
	
	//Konstruktor
	public Mitglied(String name, String vorname, String passwort, String geburtsdatum, Adresse adresse) {
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
		this.geburtsdatum = geburtsdatum;
		this.adresse = adresse;
		
		mitgliedID=ANZAHL++;
		benutzername=vorname.substring(0,2) + name.substring(0,3) + mitgliedID;
	}

	//Methoden
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		aktualisiereBenutzername();
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
		aktualisiereBenutzername();
	}

	public String getBenutzername() {
		return benutzername;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public int getMitgliedID() {
		return mitgliedID;
	}
	
	public boolean validierePasswort(String angeblichesPasswort){
		return this.passwort.equals(angeblichesPasswort);
		
	}
	
	private void aktualisiereBenutzername(){
		benutzername=vorname.substring(0,2) + name.substring(0,3) + mitgliedID;
		
	}
	
}
