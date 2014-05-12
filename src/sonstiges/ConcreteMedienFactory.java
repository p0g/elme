package sonstiges;
import data_transfer_objects.BuchDTO;
import data_transfer_objects.CDDTO;
import data_transfer_objects.DvDDTO;

public class ConcreteMedienFactory implements MedienFactoryI {

	// Attribute
	private static ConcreteMedienFactory uniqueInstance = null;

	// Konstruktor
	private ConcreteMedienFactory() {

	}

	// Methoden
	public BuchDTO createBook(String titel, int jahr, String verfasser, String verlag, String isbn) {
		return new BuchDTO(titel, jahr, verfasser, verlag, isbn);
	}

	public CDDTO createCD(String titel, int jahr, String interpret, String label) {
		return new CDDTO(titel, jahr, interpret, label);
	}

	public DvDDTO createDvD(String titel, int jahr, int fsk, int spieldauer) {
		return new DvDDTO(titel, jahr, fsk, spieldauer);
	}

	public static ConcreteMedienFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ConcreteMedienFactory();
		}
		return uniqueInstance;

	}

}
