package data_access_objects;
import java.sql.ResultSet;

import sonstiges.Adresse;
import sonstiges.DBMySQL;
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

	public void create(String name, String vorname, String benutzername, String passwort, String geburtsdatum, Adresse adresse) {
		try {
			DBMySQL db = new DBMySQL();	
			
			// Mitglied hinzufügen			
			String sql = "INSERT INTO mitglieder (name,vorname,benutzername,passwort,geburtsdatum) "
					   + "VALUES ('"+ name +"','"+ vorname +"','"+ benutzername +"','"+ passwort +"','"+ geburtsdatum +"');";
			//System.out.println(sql);
			ResultSet rs = db.insert(sql);
			rs.next();
			int mitglied_id = rs.getInt(1);
			
			// Adresse hinzufügen
			sql = "INSERT INTO adressen (mitglied_id,strasse,hausnummer,plz,ort,land) "
					   + "VALUES ('"+ mitglied_id +"','"+ adresse.getStrasse() +"','"+ adresse.getHausnummer() +"','"+ adresse.getPlz() +"','"+ adresse.getOrt() +"','"+ adresse.getLand() +"');";				
			db.insert(sql);		
			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
	}

	//TODO Generell
	public void update(MitgliedDTO m) {
		// aktualisiert das entsprechende Mitglied in der DB
	}

	//TODO Adresse (Join)
	public MitgliedDTO read(int mitglieds_id) {
		try {
			DBMySQL db = new DBMySQL();			
			String sql = "SELECT * FROM mitglieder WHERE id = '" + mitglieds_id + "';";			
			ResultSet rs = db.exec(sql);			
			if(rs.next()){
				// Mitglied vorhanden, dh. neues Objekt erzeugen und Daten rein
				MitgliedDTO m = new MitgliedDTO(rs.getInt("id"), rs.getString("name"), rs.getString("vorname"), rs.getString("benutzername"), rs.getString("passwort"), rs.getDate("geburtsdatum").toString(), new Adresse(null,0,0,null,null));
				return m;
			}			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
		return null;
	}

	//TODO Adresse (Join)
	public MitgliedDTO read(String benutzername) {
		try {
			DBMySQL db = new DBMySQL();			
			String sql = "SELECT * FROM mitglieder WHERE benutzername = '" + benutzername + "';";			
			ResultSet rs = db.exec(sql);			
			if(rs.next()){
				// Mitglied vorhanden, dh. neues Objekt erzeugen und Daten rein
				MitgliedDTO m = new MitgliedDTO(rs.getInt("id"), rs.getString("name"), rs.getString("vorname"), rs.getString("benutzername"), rs.getString("passwort"), rs.getDate("geburtsdatum").toString(), new Adresse(null,0,0,null,null));
				return m;
			}			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
		return null;
	}

	public void delete(MitgliedDTO m) {
		try {
			DBMySQL db = new DBMySQL();			
			String sql = "DELETE FROM mitglieder WHERE id = '" + m.getMitgliedID() + "';";			
			db.exec(sql);
			sql = "DELETE FROM adressen WHERE mitglied_id = '" + m.getMitgliedID() + "';";			
			db.exec(sql);	
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler: "); e.printStackTrace();
		}
	}
}
