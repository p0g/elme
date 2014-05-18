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
	public LeiheDTO(int id, Date d, MitgliedDTO mitglied, MediumDTO medium) {
		//LeiheBO.getInstance().verlaenger(this); // Ausleihdatum einmal
												// verlaengern
		this.datum = d;
		this.leihID = id;
		this.mitglied = mitglied;
		this.medium = medium;
		//System.out.println(this.datum);
	}

	// Methoden
	public int getLeihID() {
		return leihID;
	}

	public Date getDatum() {
		java.sql.Date sqlDate = new java.sql.Date(datum.getTime());
		System.out.println(sqlDate);
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
