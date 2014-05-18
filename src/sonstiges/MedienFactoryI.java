package sonstiges;
import data_transfer_objects.BuchDTO;
import data_transfer_objects.CDDTO;
import data_transfer_objects.DvDDTO;

public interface MedienFactoryI {

	// Methoden
	public abstract BuchDTO createBook(int id, String titel, boolean entliehen, int jahr, String verfasser, String verlag, String isbn);

	public abstract CDDTO createCD(int id, String titel, boolean entliehen, int jahr, String interpret, String label);

	public abstract DvDDTO createDVD(int id, String titel, boolean entliehen, int jahr, int fsk, int spieldauer);
}
