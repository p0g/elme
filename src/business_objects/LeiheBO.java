package business_objects;
import java.util.Calendar;
import java.util.GregorianCalendar;

import data_access_objects.LeiheDAO;
import data_transfer_objects.LeiheDTO;

public class LeiheBO {

	// Attribute
	private static LeiheBO uniqueInstance = null;

	// Konstruktor
	private LeiheBO() {

	}

	// Methoden
	/**
	 * Verlängerung des Mediums
	 */
	public void verlaenger(LeiheDTO l) {
		// TODO: Entsprechend dem Medium das Endleihdatum ermitteln. Im Moment
		// einfach 14 Tage drauf
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(l.getDatum());
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		l.setDate(calendar.getTime());
		LeiheDAO.getInstance().update(l);
	}

	public void druckeDaten(LeiheDTO l) {
		System.out.println("Leihe No. " + l.getLeihID());
		System.out.println("MitgliedID: " + l.getMitglied().getMitgliedID());
		System.out.println("Medium: " + l.getMedium().getTitel());
	}

	public static LeiheBO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new LeiheBO();
		}
		return uniqueInstance;
	}

}
