package Ueberfl�ssigeKlassen;
import java.util.ArrayList;

import sonstiges.MitgliedNichtExistentException;
import data_access_objects.MitgliedDAO;
import data_transfer_objects.MitgliedDTO;
import business_objects.MitgliedBO;

/**
 * Verwaltung aller Mitglieder
 */
public class Mitgliederverwaltung {

	// Attribute
	// private ArrayList<MitgliedDTO> mitglieder;
	private static Mitgliederverwaltung uniqueInstance;

	/**
	 * Konstruktor
	 */
	private Mitgliederverwaltung() {
		// mitglieder=new ArrayList<MitgliedDTO>();
	}

	// Methoden
	/**
	 * Adds an Member to the mit Memberlist
	 * 
	 * @param m
	 *            - Memberobject TODO: Hash the member password before save
	 */
	public void addMitglied(MitgliedDTO m) {
		MitgliedDAO.getInstance().create(m);
	}

	public static Mitgliederverwaltung getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Mitgliederverwaltung();
		}
		return uniqueInstance;

	}

	/**
	 * Checks if the used password is valid
	 * 
	 * @param benutzername
	 * @param angeblichesPasswort
	 * @return The Member (if pwcheck is valid)
	 * @throws MitgliedNichtExistentException
	 */
	public MitgliedDTO validiere1(String benutzername, String angeblichesPasswort)
			throws MitgliedNichtExistentException {
		MitgliedDTO m = MitgliedDAO.getInstance().read(benutzername);

		// // Check if the used membername is in the list
		// for(MitgliedDTO mg:mitglieder){
		// if(mg.getBenutzername().equals(benutzername)){
		// m=mg;
		// break;
		// }
		// }

		if (m == null) {
			// Member is not in the list
			throw new MitgliedNichtExistentException(
					"Dieses Mitglied existiert nicht.");
		} else {
			// Try to validate the password
			if (MitgliedBO.getInstance().validierePasswort(m, angeblichesPasswort)) {
				return m;
			} else {
				return null;
			}
		}
	}
}
