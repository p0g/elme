import java.util.ArrayList;

/**
 * Verwaltung der vorhandenen Medien
 */
public class Medienverwaltung {
	
	private ArrayList<Medium> medien;
	private static Medienverwaltung uniqueInstance;
	
	private Medienverwaltung(){		
		medien = new ArrayList<Medium>();		
	}
	
	public void addMedium(Medium m){
		medien.add(m);
	}
	
	public Medium getMedium(int i){
		return medien.get(i);
	}
	
	public ArrayList<Medium> getMedien(){
		return medien;
	}
	
	public static Medienverwaltung getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new Medienverwaltung();
		}
		return uniqueInstance;
		
	}
}
