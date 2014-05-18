package data_access_objects;
import java.sql.ResultSet;

import business_objects.MitgliedBO;
import sonstiges.Adresse;
import sonstiges.DBMySQL;
import data_transfer_objects.LeiheDTO;
import data_transfer_objects.MediumDTO;
import data_transfer_objects.MitgliedDTO;

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

	public void create(LeiheDTO lei) {
		// Eine neue Leihe wird in die DB aufgenommen
		try {
			DBMySQL db = new DBMySQL();				
		
			String sql = "INSERT INTO leihen (date,mitglied,medium) "
					   + "VALUES ('"+ lei.getDatum() +"','"+ lei.getMitglied().getMitgliedID() +"','"+ lei.getMedium().getMediumID() +"');";
			System.out.println(lei.getDatum());
			//db.insert(sql);		
			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler beim Anlegen einer Leihe: "); e.printStackTrace();
		}
		
	}

	// Die Methode mit diesem Parameter brauchte ich, um einen Fehler
	// wegzukriegen. Vlt brauchen wir noch eine read-Methode mit einem anderem
	// Parameter?
	public LeiheDTO read(MediumDTO m) {
		// Nimmt die entsprechende Leihe aus der DB und gibt sie zurück
		// Das Medium identifiziert die Leihe eindeutig
		try {
			DBMySQL db = new DBMySQL();			
			String sql = "SELECT * FROM leihen WHERE medium = '" + m.getMediumID() + "';";			
			ResultSet rs = db.exec(sql);			
			if(rs.next()){
				// Leihe vorhanden, dh. neues Objekt erzeugen und Daten rein
				//MitgliedDTO m = MitgliedDTO.getInstance();
				LeiheDTO lei = new LeiheDTO(null, m);
				return lei;
			}			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
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
		try {
			DBMySQL db = new DBMySQL();			
			String sql = "DELETE FROM leihen WHERE medium = '" + m.getMedium().getMediumID() + "' AND mitglied = '" + m.getMitglied().getMitgliedID() + "';";			
			db.exec(sql);
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
	}

}
