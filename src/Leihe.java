import java.util.ArrayList;
import java.util.Date;


public class Leihe {

	//Attribute
	private int leihID;
	private static int ANZAHL=1;
	private int mitgliedID;
	private Date datum;
	private Mitglied besitzer;
	private Medium medium;

	//Konstruktor
	public Leihe(int mitgliedID, Date datum, Mitglied besitzer, Medium m) {
		this.mitgliedID = mitgliedID;
		this.datum = datum;
		this.besitzer = besitzer;
	}

	public int getMitgliedID() {
		return mitgliedID;
	}

	
	public Date getDatum() {
		return datum;
	}

	public Mitglied getBesitzer() {
		return besitzer;
	}
	
	public void setMedium(Medium m){
		this.medium = m;
	}
	
	public Medium getMedium(){
		return this.medium;
	}
	
	public void druckeDaten(){
		System.out.println("Leihe No. "+leihID);
		System.out.println("MitgliedID: "+mitgliedID);
		System.out.println("Medium: "+medium.getTitel());
	}
	
	
	
	
	
}
