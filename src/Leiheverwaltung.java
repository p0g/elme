import java.util.ArrayList;


public class Leiheverwaltung {
	

	public Leiheverwaltung(){		
	
	}
	
	public void addLeihe(Mitglied mg, Medium m){
		Leihe l = new Leihe(mg, m);
		mg.addLeihe(l);
		m.setEntliehen(true);		
	}
}
