import java.util.Date;


public class LeiheDTO {

	// Attribute
		private int leihID;
		private static int ANZAHL=1;
		private Date datum;
		private Mitglied mitglied;
		private MediumDTO medium;
		
		// Konstruktor	
		public LeiheDTO(Mitglied mitglied, MediumDTO medium) {
			this.datum = new Date(); // Ausleihdatum auf heute setzen
			LeiheBO.getInstance().verlaenger(this);			 // Ausleihdatum einmal verlaengern
			this.mitglied = mitglied;
			this.medium = medium;
		}
		
		//Methoden
		public int getLeihID() {
			return leihID;
		}

		public Date getDatum() {
			return datum;
		}

		public Mitglied getMitglied() {
			return mitglied;
		}

		public MediumDTO getMedium() {
			return medium;
		}
		
		public void setDate(Date value){
			this.datum=value;
			
		}
		
}
