/*
 * Data Access-Klasse f�r Medien
 */
public class MediumDAO{
	
	//direkt mit Singleton-Muster
	private static MediumDAO uniqueInstance;

	//Konstruktor
	private MediumDAO(){
		
		
	}
	
	//Methoden
	public static MediumDAO getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new MediumDAO();
		}
		return uniqueInstance;
	}
	
	public void create(MediumDTO m){
		//Ein neues Medium wird in die DB aufgenommen
	}
	
	public MediumDTO read(/*evtl hier noch Parameter*/){
		//Ein neues Medium wird in die DB aufgenommen
		return null;
	}
	
	public void update(MediumDTO m){
		//aktualisiert das entsprechende Medium in der DB
	}
	
	
	public void delete(MediumDTO m){
		//l�scht das entsprechende Medium aus der DB
	}
	
//	Warum ist diese Klasse nicht abstrakt, wie die anderen Mediumklassen auch?
//			Wenn diese Klasse abstrakt w�re, w�rden wir Ihre Methoden auch abstrakt machen.
//			Damit w�rden Ihre Methoden Medium-Objekte akzeptieren, was die erbenden Klassen so �bernehmen m�ssten,
//			was aber sinnlos w�re, weil dann jede DAO Klasse alle Medienobjekte akzeptieren w�rde.
//			Au�erdem w�rde das dem Prinzip des DAO/DTO-Musters widersprechen, wonach man bei �nderung der DB nur EINE Klasse
//			�ndern muss - denn dann m�ssten wir drei Klassen �ndern!
}
