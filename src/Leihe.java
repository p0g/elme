import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Leihe {

	//Attribute
	private int leihID;
	private static int ANZAHL=1;
	private Date datum;
	private Mitglied mitglied;
	private Medium medium;

	//Konstruktor
	
	public Leihe(Mitglied mitglied, Medium medium) {
		this.datum = new Date(); // Ausleihdatum auf heute setzen
		verlaenger();			 // Ausleihdatum einmal verlaengern
		this.mitglied = mitglied;
		this.medium = medium;
	}
	
	public void verlaenger(){
		//TODO: Entsprechend dem Medium das Endleihdatum ermitteln. Im Moment einfach 14 Tage drauf
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.datum);
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		this.datum = calendar.getTime();
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
