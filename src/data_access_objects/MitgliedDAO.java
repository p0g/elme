package data_access_objects;
import data_transfer_objects.MitgliedDTO;

public class MitgliedDAO {

	// Attribute
	private static MitgliedDAO uniqueInstance;

	// Konstruktor
	private MitgliedDAO() {

	}

	// Methoden
	public static MitgliedDAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new MitgliedDAO();

		}
		return uniqueInstance;
	}

	public void create(MitgliedDTO m) {
		// Ein neues Mitglied wird in die DB aufgenommen
	}

	public void update(MitgliedDTO m) {
		// aktualisiert das entsprechende Medium in der DB
	}

	public MitgliedDTO read(int i) {
		// Nimmt das entsprechende Mitglied aus der DB und gibt es zurück
		// Evtl auch ein anderer Parameter, muss Stefan entscheiden und ggf
		// anpassen
		return null;
	}

	public MitgliedDTO read(String benutzername) {
		// Nimmt das entsprechende Mitglied aus der DB und gibt es zurück
		// Evtl auch ein anderer Parameter, muss Stefan entscheiden und ggf
		// anpassen
		// Die Methode mit dem String brauchte ich, um einen Fehler wegzukriegen
		return null;
	}

	public void delete(MitgliedDTO m) {
		// löscht das entsprechende Mitglied aus der DB
	}
}
