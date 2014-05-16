package sonstiges;
import data_transfer_objects.BuchDTO;
import data_transfer_objects.CDDTO;
import data_transfer_objects.DvDDTO;

public interface MedienFactoryI {

	// Methoden
	public abstract BuchDTO createBook(String titel, int jahr, String verfasser, String verlag, String isbn);

	public abstract CDDTO createCD(String titel, int jahr, String interpret, String label);

	public abstract DvDDTO createDVD(String titel, int jahr, int fsk, int spieldauer);
}
