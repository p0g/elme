package data_access_objects;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		return null;
	}

	public void update(MediumDTO m) {
		// aktualisiert das entsprechende Medium in der DB
	}

	public void delete(MediumDTO m) {
		// löscht das entsprechende Medium aus der DB
	}
	
	// TODO: 
	public ArrayList<MediumDTO> getMedien() {
		ArrayList<MediumDTO> medien = new ArrayList<MediumDTO>();
		MediumDTO m = null;
		int i = 0;
		while (true) {
			m = read(i);
			if (m == null) {
				break;
			}
			medien.add(m);
			i++;
		}
		return medien;
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
