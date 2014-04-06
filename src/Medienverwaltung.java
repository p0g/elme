import java.util.ArrayList;


public class Medienverwaltung {
	
	private ArrayList<Medium> medien;
	
	public Medienverwaltung(){		
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

}
