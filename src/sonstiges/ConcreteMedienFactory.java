package sonstiges;
import data_transfer_objects.*;

public class ConcreteMedienFactory implements MedienFactoryI {

	// Attribute
	private static ConcreteMedienFactory uniqueInstance = null;

	// Konstruktor
	private ConcreteMedienFactory() {

	}

	// Methoden
	/*
	 * erzeugt ein DTO-Objekt vom Typ BuchDTO.
	 * Erwartet die gleichen Parameter wie der Konstruktor der Klasse BuchDTO.
	 */
	public BuchDTO createBook(int id, String titel, boolean entliehen, int jahr, String verfasser, String verlag, String isbn) {
		return new BuchDTO(id, entliehen, titel, jahr, verfasser, verlag, isbn);
	}

	/*
	 * erzeugt ein DTO-Objekt vom Typ CDDTO.
	 * Erwartet die gleichen Parameter wie der Konstruktor der Klasse CDDTO.
	 */
	public CDDTO createCD(int id, String titel, boolean entliehen, int jahr, String interpret, String label) {
		return new CDDTO(id, entliehen, titel, jahr, interpret, label);
	}

	/*
	 * erzeugt ein DTO-Objekt vom Typ DVDDTO.
	 * Erwartet die gleichen Parameter wie der Konstruktor der Klasse DVDDTO.
	 */
	public DvDDTO createDVD(int id, String titel, boolean entliehen, int jahr, int fsk, int spieldauer) {
		return new DvDDTO(id, entliehen, titel, jahr, fsk, spieldauer);
	}
	

	public static ConcreteMedienFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ConcreteMedienFactory();
		}
		return uniqueInstance;

	}

}
