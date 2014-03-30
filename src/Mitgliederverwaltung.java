import java.util.ArrayList;


public class Mitgliederverwaltung {
	
	//Attribute
	private ArrayList<Mitglied> mitglieder;
	
	//Konstruktor
	public Mitgliederverwaltung(){
		mitglieder=new ArrayList<Mitglied>();
		
		/*Zu Testzwecken wird hier bereits automatisiert ein Mitglied eingefügt,
		 * um eine Zeitintensive registrierung bei jedem test zu umgehen*/
		
		Adresse ad=new Adresse("EFS", 44, 44227, "Dortmund", "DE");
		Mitglied mg=new Mitglied("Mustermann", "Max", "test", "27.1.82", ad);
		addMitglied(mg);
	}
	
	//Methoden
	public void addMitglied(Mitglied m) {
		mitglieder.add(m);
	}
	
	public boolean validiere(String benutzername, String angeblichesPasswort) throws MitgliedNichtExistentException {
		Mitglied m=null;
		
		for(Mitglied mg:mitglieder){
			if(mg.getBenutzername().equals(benutzername)){
				m=mg;
				break;
				
			}
			
		}
		
		if(m==null){
			throw new MitgliedNichtExistentException("Dieses Mitglied existiert nicht.");
		}
		else{
			return m.validierePasswort(angeblichesPasswort);
			
		}
		
		
		
	}
}
