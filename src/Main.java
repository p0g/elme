import java.awt.*;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		Mitgliederverwaltung mv=new Mitgliederverwaltung();
		
		
		/* Create new MainFrame */
		final JFrame frame = new JFrame("Verwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
		frame.setLocation(550, 300);
		
        LoginGUI login = new LoginGUI(frame, mv);
        //frame.setVisible(true);
        
        if(login.isErfolg()){
        	// Login is ok
        	
        	
        	// Hole eingeloggtes Mitglied
        	Mitglied mitglied = login.getMitglied();
        	
        	
        	Leiheverwaltung lv = new Leiheverwaltung();
        	
        	
        	
        	// Login is ok, load the Mainmenu
        	MainGUI main = new MainGUI(frame, mitglied);
        }
		
		

		//;
		
		
		//frame.setVisible(true);
		
		//log.setVisible(true);
		
		//if(log.isSucceeded()){
		//	
		//}

	}

}
