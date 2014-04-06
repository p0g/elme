import java.util.ArrayList;
import java.util.Date;


public class Leihe {

	//Attribute
	private int leihID;
	private static int ANZAHL=1;
	private Date datum;
	private Mitglied mitglied;
	private Medium medium;

	//Konstruktor
	
	public Leihe(int mitgliedID, Date datum, Mitglied mitglied, Medium m) {
		this.datum = datum;
		this.mitglied = mitglied;
	}

	public Date getDatum() {
		return datum;
	}

	public Mitglied getMitglied() {
		return mitglied;
	}
	
	public void setMedium(Medium m){
		this.medium = m;
	}
	
	public Medium getMedium(){
		return this.medium;
	}
	
	public void druckeDaten(){
		System.out.println("Leihe No. "+leihID);
		System.out.println("MitgliedID: "+mitglied.getMitgliedID());
		System.out.println("Medium: "+medium.getTitel());
	}
	
	
	
	
	
}
