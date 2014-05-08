/*
 * Data Access-Klasse für Medien
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
		//löscht das entsprechende Medium aus der DB
	}
	
//	Warum ist diese Klasse nicht abstrakt, wie die anderen Mediumklassen auch?
//			Wenn diese Klasse abstrakt wäre, würden wir Ihre Methoden auch abstrakt machen.
//			Damit würden Ihre Methoden Medium-Objekte akzeptieren, was die erbenden Klassen so übernehmen müssten,
//			was aber sinnlos wäre, weil dann jede DAO Klasse alle Medienobjekte akzeptieren würde.
//			Außerdem würde das dem Prinzip des DAO/DTO-Musters widersprechen, wonach man bei Änderung der DB nur EINE Klasse
//			ändern muss - denn dann müssten wir drei Klassen ändern!
}
