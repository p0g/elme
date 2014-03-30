import java.util.ArrayList;
import java.util.Date;


public class Leihe {

	//Attribute
	private int leihID;
	private static int ANZAHL=1;
	private int mitgliedID;
	private Date datum;
	private Mitglied besitzer;
	private ArrayList<Medium> medien;

	//Konstruktor
	public Leihe(int mitgliedID, Date datum, Mitglied besitzer) {
		this.mitgliedID = mitgliedID;
		this.datum = datum;
		this.besitzer=besitzer;
		leihID=ANZAHL++;
		medien=new ArrayList<Medium>();
	}

	public int getMitgliedID() {
		return mitgliedID;
	}

	public ArrayList<Medium> getMedienliste(){
		return medien;
		
	}
	
	public Date getDatum() {
		return datum;
	}

	public Mitglied getBesitzer() {
		return besitzer;
	}
	
	public void addMedium(Medium m){
		medien.add(m);
	}
	
	public void druckeDaten(){
		System.out.println("Leihe No. "+leihID);
		System.out.println("MitgliedID: "+mitgliedID);
		for(Medium m:medien){
			System.out.println("Medium: "+m.getTitel());
			
		}
	}
	
	
	
	
	
}
