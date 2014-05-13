package data_transfer_objects;
import java.util.ArrayList;

import sonstiges.*;

public class MitgliedDTO {

	// Atribute
	private String name;
	private String vorname;
	private String benutzername;
	private String passwort;
	private Adresse adresse;
	private String geburtsdatum;
	private int mitgliedID;
	// statische Variable nur für internen Gebrauch. initial 1, weil sonst die
	// generierung der benutzernamen bei 0 beginnen würde!
	private static int ANZAHL = 1;

	private ArrayList<LeiheDTO> leihen = new ArrayList<LeiheDTO>();

	/**
	 * Konstruktor des Mitglieds
	 * 
	 * @param name
	 *            Nachname
	 * @param vorname
	 *            Vorname
	 * @param passwort
	 *            Passwort TODO: Hashen
	 * @param geburtsdatum
	 *            Geburtsdatum
	 * @param adresse
	 *            Adressenobjekt
	 */
	public MitgliedDTO(int id, String name, String vorname, String benutzername, String passwort, String geburtsdatum, Adresse adresse) {
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
		this.geburtsdatum = geburtsdatum;
		this.adresse = adresse;
		
		this.mitgliedID = id;
		this.benutzername = benutzername;

		//mitgliedID = ANZAHL++;
		// Benutzername anlegen für den Login
		//benutzername = vorname.substring(0, 2) + name.substring(0, 2) + mitgliedID;
	}

	// Methoden
	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public int getMitgliedID() {
		return mitgliedID;
	}

	public ArrayList<LeiheDTO> getLeihen() {
		return leihen;
	}

}
