package business_objects;

import sonstiges.MitgliedNichtExistentException;
import data_access_objects.*;
import data_transfer_objects.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

public class MitgliedBO {

	// Attribute
	private static MitgliedBO uniqueInstance;

	// Konstruktor
	private MitgliedBO() {

	}

	// Methoden
	public static MitgliedBO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new MitgliedBO();
		}
		return uniqueInstance;
	}

	/**
	 * Eine neue Leihe hinzufügen
	 * 
	 * @param m Medium
	 */
	public void addLeihe(MitgliedDTO mg, MediumDTO m) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		
		LeiheDTO temp_l = new LeiheDTO(0, calendar.getTime(), mg, m);
		int l_id = LeiheDAO.getInstance().create(temp_l);
		m.setEntliehen(true);
		MediumDAO.getInstance().update(m);
	}

	/**
	 * Holt eine Leihe anhand eines Mediums
	 * 
	 * @param m Medium
	 * @return gefundene Leihe oder Null
	 */
	/*public LeiheDTO getLeihe(MediumDTO m) {
		return LeiheDAO.getInstance().read(m);
	}*/

	/**
	 * Eine Bestimmte Leihe entfernen
	 * 
	 * @param l Leihe
	 */
	public void removeLeihe(LeiheDTO l) {
		LeiheDAO.getInstance().delete(l);
	}

	/**
	 * Passwort überprüfen
	 * 
	 * @param angeblichesPasswort
	 *            Zu überprüfendes Passwort
	 * @return TRUE wenn korekt, sonst FALSE
	 */
	public boolean validierePasswort(MitgliedDTO m, String angeblichesPasswort) {
		return m.getPasswort().equals(angeblichesPasswort);

	}
	
	/**
	 * Checks if the used password is valid
	 * 
	 * @param benutzername
	 * @param angeblichesPasswort
	 * @return The Member (if pwcheck is valid)
	 * @throws MitgliedNichtExistentException
	 */
	public MitgliedDTO validiere(String benutzername, String angeblichesPasswort) throws MitgliedNichtExistentException {
		MitgliedDTO m = MitgliedDAO.getInstance().read(benutzername);
		if (m == null) {
			// Member is not in the list
			throw new MitgliedNichtExistentException("Dieses Mitglied existiert nicht.");
		} else {
			// Try to validate the password
			if (MitgliedBO.getInstance().validierePasswort(m, angeblichesPasswort)) {
				return m;
			} else {
				return null;
			}
		}
	}

	public void deregister(MitgliedDTO mitglied) {
		// TODO wie viele sind gerade eingelogt?
		
	}

}
