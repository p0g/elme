import java.util.ArrayList;

/**
 * Verwaltung aller Mitglieder
 */
public class Mitgliederverwaltung {
	
	//Attribute
	private ArrayList<Mitglied> mitglieder;
	
	/**
	 * Konstruktor
	 */
	public Mitgliederverwaltung(){
		mitglieder=new ArrayList<Mitglied>();
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
	 * @return The Member (if pwcheck is valid)
	 * @throws MitgliedNichtExistentException
	 */
	public Mitglied validiere(String benutzername, String angeblichesPasswort) throws MitgliedNichtExistentException {
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
			if(m.validierePasswort(angeblichesPasswort)){
				return m;
			}else{
				return null;
			}
		}	
	}
}
