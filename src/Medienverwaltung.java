import java.util.ArrayList;

/**
 * Verwaltung der vorhandenen Medien
 */
public class Medienverwaltung {
	
	//private ArrayList<MediumDTO> medien;
	private static Medienverwaltung uniqueInstance;
	
	private Medienverwaltung(){		
		//medien = new ArrayList<MediumDTO>();		
	}
	
	public void addMedium(MediumDTO m){
		MediumDAO.getInstance().create(m);
	}
	
	public MediumDTO getMedium(int i){
		return MediumDAO.getInstance().read(i);
	}
	
	public ArrayList<MediumDTO> getMedien(){
		ArrayList<MediumDTO> medien=new ArrayList<MediumDTO>();
		MediumDTO m=null;
		int i=0;
		while(true){
			m=MediumDAO.getInstance().read(i);
			if(m==null){
				break;
			}
			medien.add(m);
			i++;
		}
		return medien;
	}
	
	public static Medienverwaltung getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new Medienverwaltung();
		}
		return uniqueInstance;
		
	}
}
