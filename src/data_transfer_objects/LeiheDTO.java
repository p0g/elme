package data_transfer_objects;
import java.util.Date;

import business_objects.LeiheBO;

public class LeiheDTO {

	// Attribute
	private int leihID;
	private static int ANZAHL = 1;
	private Date datum;
	private MitgliedDTO mitglied;
	private MediumDTO medium;

	// Konstruktor
	public LeiheDTO(int id, MitgliedDTO mitglied, MediumDTO medium) {
		this.datum = new Date(); // Ausleihdatum auf heute setzen
		LeiheBO.getInstance().verlaenger(this); // Ausleihdatum einmal
												// verlaengern
		this.leihID = id;
		this.mitglied = mitglied;
		this.medium = medium;
	}

	// Methoden
	public int getLeihID() {
		return leihID;
	}

	public Date getDatum() {
		java.sql.Date sqlDate = new java.sql.Date(datum.getTime());
		return sqlDate;
	}

	public MitgliedDTO getMitglied() {
		return mitglied;
	}

	public MediumDTO getMedium() {
		return medium;
	}

	public void setDate(Date value) {
		this.datum = value;

	}

}
