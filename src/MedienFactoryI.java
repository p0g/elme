
public interface MedienFactoryI {
	
	
	//Methoden
	public abstract BuchDTO createBook(String titel, int jahr, String verfasser, String verlag, String isbn);
	
	public abstract CDDTO createCD(String titel, int jahr, String interpret, String label);
	
	public abstract DvDDTO createDvD(String titel, int jahr, int fsk, int spieldauer);
	
}
