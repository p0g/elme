/*
 * Data-Access Klasse für Leihen
 */
public class LeiheDAO {

	//direkt mit Singleton-Muster
	private static LeiheDAO uniqueInstance;

	//Konstruktor
	private LeiheDAO(){
		
		
	}
	
	//Methoden
	public static LeiheDAO getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new LeiheDAO();
		}
		return uniqueInstance;
	}
	
	public void create(LeiheDTO m){
		//Ein neues Medium wird in die DB aufgenommen
	}
	
	public LeiheDTO read(/*evtl hier noch Parameter*/){
		//Ein neues Medium wird in die DB aufgenommen
		return null;
	}
	
	public void update(LeiheDTO m){
		//aktualisiert das entsprechende Medium in der DB
	}
	
	
	public void delete(LeiheDTO m){
		//löscht das entsprechende Medium aus der DB
	}

}
