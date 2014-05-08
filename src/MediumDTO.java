/*
 * Data Transfer - Klasse für Medien
 */
public abstract class MediumDTO {

		//Attribute
		private static int ANZAHL=0;
		protected int mediumID;
		protected String signatur;
		protected String titel;
		protected int jahr;
		protected boolean entliehen;
		
		//Konstruktor
		public MediumDTO(String titel, int jahr){
			mediumID=ANZAHL++;
			this.titel=titel;
			this.jahr=jahr;
			entliehen=false;
		}

		//Methoden
		public int getMediumID() {
			return mediumID;
		}

		public String getSignatur() {
			return signatur;
		}

		public String getTitel() {
			return titel;
		}

		public int getJahr() {
			return jahr;
		}

		public boolean isEntliehen() {
			return entliehen;
		}
		
		public void setEntliehen(boolean value){
			this.entliehen=value;
		}

		
}
