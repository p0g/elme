package data_access_objects;
import java.util.ArrayList;

import data_transfer_objects.MediumDTO;

/*
 * Data Access-Klasse f�r Medien
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
		// Ein neues Medium wird in die DB aufgenommen
	}

	public MediumDTO read(String signatur) {
		// Nimmt das entsprechende Medium aus der DB und gibt es zur�ck
		// Ein Medium wird durch seine signatur eindeutig identifiziert.
		return null;
	}

	public MediumDTO read(int i) {
		// Nimmt das entsprechende Medium aus der DB und gibt es zur�ck
		// Die Methode brauchte ich um einen Fehler wegzukriegen
		return null;
	}

	public void update(MediumDTO m) {
		// aktualisiert das entsprechende Medium in der DB
	}

	public void delete(MediumDTO m) {
		// l�scht das entsprechende Medium aus der DB
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
	// Wenn diese Klasse abstrakt w�re, w�rden wir Ihre Methoden auch abstrakt
	// machen.
	// Damit w�rden Ihre Methoden Medium-Objekte akzeptieren, was die erbenden
	// Klassen so �bernehmen m�ssten,
	// was aber sinnlos w�re, weil dann jede DAO Klasse alle Medienobjekte
	// akzeptieren w�rde.
	// Au�erdem w�rde das dem Prinzip des DAO/DTO-Musters widersprechen, wonach
	// man bei �nderung der DB nur EINE Klasse
	// �ndern muss - denn dann m�ssten wir drei Klassen �ndern!
}
