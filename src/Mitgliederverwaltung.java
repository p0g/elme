import java.util.ArrayList;


public class Mitgliederverwaltung {
	
	//Attribute
	private ArrayList<Mitglied> mitglieder;
	
	//Konstruktor
	public Mitgliederverwaltung(){
		mitglieder=new ArrayList<Mitglied>();
		
		/*Zu Testzwecken wird hier bereits automatisiert ein Mitglied eingefügt,
		 * um eine Zeitintensive registrierung bei jedem test zu umgehen*/
		
		Adresse ad01=new Adresse("EFS", 44, 44227, "Dortmund", "DE");
		Mitglied mg01=new Mitglied("Mustermann", "Max", "test", "27.1.82", ad01);
		addMitglied(mg01);
	}
	
	//Methoden
	/**
	 * Adds an Member to the mit Memberlist
	 * @param m - Memberobject
	 * TODO: Hash the member password before save
	 */
	public void addMitglied(Mitglied m) {
		mitglieder.add(m);
	}
	
	/**
	 * Checks if the used password is valid
	 * @param benutzername
	 * @param angeblichesPasswort
	 * @return
	 * @throws MitgliedNichtExistentException
	 */
	public boolean validiere(String benutzername, String angeblichesPasswort) throws MitgliedNichtExistentException {
		Mitglied m=null;
		
		// Check if the used membername is in the list
		for(Mitglied mg:mitglieder){
			if(mg.getBenutzername().equals(benutzername)){
				m=mg;
				break;				
			}			
		}		
		if(m==null){
			// Member is not in the list
			throw new MitgliedNichtExistentException("Dieses Mitglied existiert nicht.");
		}
		else{
			// Try to validate the password
			return m.validierePasswort(angeblichesPasswort);			
		}
		
		
		
	}
}
