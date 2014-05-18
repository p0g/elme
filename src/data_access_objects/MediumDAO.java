package data_access_objects;
import java.sql.ResultSet;
import java.util.ArrayList;

import business_objects.BuchBO;
import sonstiges.DBMySQL;
import data_transfer_objects.BuchDTO;
import data_transfer_objects.CDDTO;
import data_transfer_objects.DvDDTO;
import data_transfer_objects.MediumDTO;

/*
 * Data Access-Klasse für Medien
 */
public class MediumDAO {

	// direkt mit Singleton-Muster
	private static MediumDAO uniqueInstance;

	// Konstruktor
	private MediumDAO() {

	}

	// Methoden
	public static MediumDAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new MediumDAO();
		}
		return uniqueInstance;
	}

	public void create(MediumDTO m) {
		
		try {
			DBMySQL db = new DBMySQL();
				
			String sql_medien, sql_typ = "";
			Boolean goon = true;
			int typ = 0, medien_id = 0;
			
			// Medium untersuchen und speichern
			if(m instanceof BuchDTO){
				typ = 1;
			}else if(m instanceof CDDTO){
				typ = 3;
			}else if(m instanceof DvDDTO){
				typ = 2;
			}else{
				goon = false;
				System.out.println("Fehler: Unbekanntes Medium");
			}
			
			if(goon){
				sql_medien 	= "INSERT INTO medien (medium_typ_id, signatur, titel, jahr) "
							+ "VALUES ('"+ typ +"', '"+ m.getTitel() +"', '"+ m.getSignatur() +"', '"+ m.getJahr() +"' );";				
				ResultSet rs = db.insert(sql_medien);
				rs.next();
				medien_id = rs.getInt(1);
			}
			
			// Prüfen von welchem Typ das Medium ist
			// und entsprechende SQL-Tablle anwählen
			if(m instanceof BuchDTO){
				BuchDTO b = (BuchDTO)m;
				sql_typ = "INSERT INTO buecher (mediumid, verfasser, verlag, isbn) "
						+ "VALUES ('"+ medien_id  +"', '"+ b.getVerfasser() +"', '"+ b.getVerlag() +"', '"+ b.getIsbn()  +"');";
			}else if(m instanceof CDDTO){
				CDDTO c = (CDDTO)m;
				sql_typ = "INSERT INTO cds (mediumid, interpret, label) "
						+ "VALUES ('"+ medien_id  +"', '"+ c.getInterpret() +"', '"+ c.getLabel() +"');";
			}else if(m instanceof DvDDTO){
				DvDDTO d = (DvDDTO)m;
				sql_typ = "INSERT INTO dvds (mediumid, fsk, spieldauer) "
						+ "VALUES ('"+ medien_id  +"', '"+ d.getFsk() +"', '"+ d.getSpieldauer() +"');";
			}else{
				goon = false;
				System.out.println("Fehler: Unbekanntes Medium");
			}
						
			if(goon){
				db.insert(sql_typ);
			}
			
			
			
			db.disconnect();
		
		} catch (Exception e) {
			System.out.println("Fehler!");
			e.printStackTrace();
		}
	}

	public MediumDTO read(String signatur) {
		// Nimmt das entsprechende Medium aus der DB und gibt es zurück
		// Ein Medium wird durch seine signatur eindeutig identifiziert.
		return null;
	}

	public MediumDTO read(int i) {
		// Nimmt das entsprechende Medium aus der DB und gibt es zurück
		// Die Methode brauchte ich um einen Fehler wegzukriegen
		try {
			DBMySQL db = new DBMySQL();
			
			String sql = "SELECT medium_typ_id FROM medien m WHERE mediumid = "+ i +";";			
			ResultSet rs = db.exec(sql);	
			rs.next();
			int typ = rs.getInt("medium_typ_id");
			boolean ent = false;
			
			switch (typ) {
			case 1: // Typ Buch
				 sql = "SELECT * FROM medien m JOIN buecher b ON m.mediumid = b.mediumid WHERE m.mediumid = "+ i +";";
				 rs = db.exec(sql);rs.next();				 
				 if(rs.getInt("entliehen")==1){ent = true;}else{ent = false;}
				 return new BuchDTO(rs.getInt("mediumid"), ent , rs.getString("titel"), rs.getInt("jahr"), rs.getString("verfasser"), rs.getString("verlag"), rs.getString("isbn"));

			case 2: // Typ DVD
				sql = "SELECT * FROM medien m JOIN dvds b ON m.mediumid = b.mediumid WHERE m.mediumid = "+ i +";";
				rs = db.exec(sql);rs.next();
				if(rs.getInt("entliehen")==1){ent = true;}else{ent = false;}
				return new DvDDTO(rs.getInt("mediumid"), ent , rs.getString("titel"), rs.getInt("jahr"), rs.getInt("fsk"), rs.getInt("spieldauer"));
			case 3: // Typ CD
				sql = "SELECT * FROM medien m JOIN cds b ON m.mediumid = b.mediumid WHERE m.mediumid = "+ i +";";
				rs = db.exec(sql);rs.next();
				if(rs.getInt("entliehen")==1){ent = true;}else{ent = false;}
				return new CDDTO(rs.getInt("mediumid"), ent , rs.getString("titel"), rs.getInt("jahr"), rs.getString("interpret"), rs.getString("label"));

			default:
				break;
			}			
			
			
			db.disconnect();
		
		} catch (Exception e) {
			System.out.println("Fehler!");
			e.printStackTrace();
		}
		return null;
	}

	public void update(MediumDTO m) {
		// aktualisiert das entsprechende Medium in der DB
		// ATM NUR DEN ENTLIEHENSTATUS
		try {
			DBMySQL db = new DBMySQL();
			String sql = "UPDATE medien SET entliehen = 1 WHERE mediumid = '" + m.getMediumID() + "';";
			System.out.println(sql);
			db.update(sql);			
			db.disconnect();			
		} catch (Exception e) {
			System.out.println("MySQL-Fehler beim Aender des ENTLIEHEN-Status: "); e.printStackTrace();
		}
		
	}

	public void delete(MediumDTO m) {
		
		int id = m.getMediumID();
		
		String delete_sql = "";
		boolean goon = true;

		if(m instanceof BuchDTO){
			delete_sql = "DELETE FROM buecher WHERE mediumid = '" + id + "';";
		}else if(m instanceof CDDTO){
			delete_sql = "DELETE FROM cds WHERE mediumid = '" + id + "';";
		}else if(m instanceof DvDDTO){
			delete_sql = "DELETE FROM dvds WHERE mediumid = '" + id + "';";
		}else{
			goon = false;
			System.out.println("Fehler: Unbekanntes Medium");
		}
		
		if(goon){
			try {
				DBMySQL db = new DBMySQL();
				String sql = "DELETE FROM medien WHERE mediumid = '" + id + "';";			
				db.exec(sql);		
				db.exec(delete_sql);	
				db.disconnect();			
			} catch (Exception e) {
				System.out.println("MySQL-Fehler beim Löschen: "); e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MediumDTO> getMedien() {
		// Holt alle Medien aus der DB und schmeisst sie in eine ArrayList
		// Erstmal für jeden Medium-Typ selbst (UNION funzt nicht)		
		
		ArrayList<MediumDTO> medien = new ArrayList<MediumDTO>();
		boolean e = false;
		try{
			DBMySQL db = new DBMySQL();
			
			// Hole Buecher
			String sql = "SELECT * FROM medien m JOIN buecher b ON m.mediumid = b.mediumid";			
			ResultSet rs = db.exec(sql);	
			BuchDTO b = null;
			while(rs.next()){
				if(rs.getInt("entliehen")==1){e = true;}else{e = false;}
				b = new BuchDTO(rs.getInt("mediumid"), e , rs.getString("titel"), rs.getInt("jahr"), rs.getString("verfasser"), rs.getString("verlag"), rs.getString("isbn"));
				medien.add(b);
			}

			// Hole DvDs
			sql = "SELECT * FROM medien m JOIN dvds d ON m.mediumid = d.mediumid";			
			rs = db.exec(sql);	
			DvDDTO d = null;
			while(rs.next()){
				if(rs.getInt("entliehen")==1){e = true;}else{e = false;}
				d = new DvDDTO(rs.getInt("mediumid"), e , rs.getString("titel"), rs.getInt("jahr"), rs.getInt("fsk"), rs.getInt("spieldauer"));
				medien.add(d);
			}
			
			// Hole CDs
			sql = "SELECT * FROM medien m JOIN cds c ON m.mediumid = c.mediumid";			
			rs = db.exec(sql);	
			CDDTO c = null;
			while(rs.next()){
				if(rs.getInt("entliehen")==1){e = true;}else{e = false;}
				c = new CDDTO(rs.getInt("mediumid"), e , rs.getString("titel"), rs.getInt("jahr"), rs.getString("interpret"), rs.getString("label"));
				medien.add(c);
			}		

			db.disconnect();			
		} catch (Exception err) {
			System.out.println("Fehler beim holen der ArrayList aller Medien!");
			err.printStackTrace();
		}
		return medien;		
	}

	public MediumDTO getMediumById(int int1) {
		// Holt ein Medium anhand der ID
		return null;
	}

	// Warum ist diese Klasse nicht abstrakt, wie die anderen Mediumklassen
	// auch?
	// Wenn diese Klasse abstrakt wäre, würden wir Ihre Methoden auch abstrakt
	// machen.
	// Damit würden Ihre Methoden Medium-Objekte akzeptieren, was die erbenden
	// Klassen so übernehmen müssten,
	// was aber sinnlos wäre, weil dann jede DAO Klasse alle Medienobjekte
	// akzeptieren würde.
	// Außerdem würde das dem Prinzip des DAO/DTO-Musters widersprechen, wonach
	// man bei Änderung der DB nur EINE Klasse
	// ändern muss - denn dann müssten wir drei Klassen ändern!
}
