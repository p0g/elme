import java.util.Calendar;
import java.util.GregorianCalendar;


public class LeiheBO {
	
	//Attribute
	private static LeiheBO uniqueInstance=null;
	
	//Konstruktor
	private LeiheBO(){
		
	}
	
	//Methoden
	/**
	 * Verl�ngerung des Mediums
	 */
	public void verlaenger(LeiheDTO l){
		//TODO: Entsprechend dem Medium das Endleihdatum ermitteln. Im Moment einfach 14 Tage drauf
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(l.getDatum());
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		l.setDate(calendar.getTime());
	}
	
	public void druckeDaten(LeiheDTO l){
		System.out.println("Leihe No. "+l.getLeihID());
		System.out.println("MitgliedID: "+l.getMitglied().getMitgliedID());
		System.out.println("Medium: "+l.getMedium().getTitel());
	}
	
	public static LeiheBO getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new LeiheBO();
		}
		return uniqueInstance;
	}

}