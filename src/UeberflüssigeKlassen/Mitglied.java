package UeberflüssigeKlassen;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import bla.Adresse;
import data_access_objects.MediumDAO;
import data_transfer_objects.LeiheDTO;
import data_transfer_objects.MediumDTO;
import data_transfer_objects.MitgliedDTO;

/**
 * Klasse eines Mitglieds
 */
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
	
	private ArrayList<LeiheDTO> leihen = new ArrayList<LeiheDTO>();
	
	/**
	 * Konstruktor des Mitglieds
	 * @param name Nachname
	 * @param vorname Vorname
	 * @param passwort Passwort TODO: Hashen
	 * @param geburtsdatum Geburtsdatum
	 * @param adresse Adressenobjekt
	 */
	public Mitglied(String name, String vorname, String passwort, String geburtsdatum, Adresse adresse) {
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
		this.geburtsdatum = geburtsdatum;
		this.adresse = adresse;
		
		mitgliedID=ANZAHL++;
		// Benutzername anlegen für den Login
		benutzername=vorname.substring(0,2) + name.substring(0,3) + mitgliedID;
	}

	/**
	 * Eine neue Leihe hinzufügen
	 * @param m Medium
	 */
	public void addLeihe(MediumDTO m){
		LeiheDTO l = new LeiheDTO(new MitgliedDTO(name, vorname, passwort, geburtsdatum, adresse), m);
		leihen.add(l);
		m.setEntliehen(true);
		MediumDAO.getInstance().update(m);
	}
	
	/**
	 * Holt eine Leihe anhand eines Mediums
	 * @param m Medium
	 * @return gefundene Leihe oder Null
	 */
	public LeiheDTO getLeihe(MediumDTO m){
		for(LeiheDTO leihe : leihen){
			if(leihe.getMedium().equals(m)){
				return leihe;			
			}			
		}
		return null;
	}
	
	/**
	 * 
	 * @return Vorhandene Leihen
	 */
	public ArrayList<LeiheDTO> getLeihen(){
		return leihen;
	}
	
	/**
	 * Eine Bestimmte Leihe entfernen
	 * @param l Leihe
	 */
	public void removeLeihe(LeiheDTO l){
		leihen.remove(l);
	}

	// Diverse Getter und Setter
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
	
	/**
	 * Passwort überprüfen
	 * @param angeblichesPasswort Zu überprüfendes Passwort
	 * @return TRUE wenn korekt, sonst FALSE
	 */
	public boolean validierePasswort(String angeblichesPasswort){
		return this.passwort.equals(angeblichesPasswort);
		
	}
	
	private void aktualisiereBenutzername(){
		benutzername=vorname.substring(0,2) + name.substring(0,3) + mitgliedID;
		
	}
	
}
