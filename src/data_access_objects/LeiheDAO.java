package data_access_objects;
import data_transfer_objects.LeiheDTO;
import data_transfer_objects.MediumDTO;

/*
 * Data-Access Klasse für Leihen
 */
public class LeiheDAO {

	// direkt mit Singleton-Muster
	private static LeiheDAO uniqueInstance;

	// Konstruktor
	private LeiheDAO() {

	}

	// Methoden
	public static LeiheDAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new LeiheDAO();
		}
		return uniqueInstance;
	}

	public void create(LeiheDTO m) {
		// Eine neue Leihe wird in die DB aufgenommen
	}

	// Die Methode mit diesem Parameter brauchte ich, um einen Fehler
	// wegzukriegen. Vlt brauchen wir noch eine read-Methode mit einem anderem
	// Parameter?
	public LeiheDTO read(MediumDTO m) {
		// Nimmt die entsprechende Leihe aus der DB und gibt sie zurück
		// Das Medium identifiziert die Leihe eindeutig
		return null;
	}

	public LeiheDTO read(int leihID) {
		// Nimmt die entsprechende Leihe aus der DB und gibt sie zurück
		// Die leihID identifiziert die Leihe eindeutig
		return null;
	}

	public void update(LeiheDTO m) {
		// aktualisiert die entsprechende Leihe in der DB
	}

	public void delete(LeiheDTO m) {
		// löscht die entsprechende Leihe aus der DB
	}

}
