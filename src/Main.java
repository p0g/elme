import java.awt.*;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		Mitgliederverwaltung mv=new Mitgliederverwaltung();
		
		
		/* Create new MainFrame */
		final JFrame frame = new JFrame("Verwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
		
        LoginGUI login = new LoginGUI(frame, mv);
        //frame.setVisible(true);
        
        if(login.isErfolg()){
        	// Login is ok
        	//Leiheverwaltung lv = new Leiheverwaltung();
        	
        	
        	
        	// Login is ok, load the Mainmenu
        	//MainGui main = new MainGui(frame, mv);
        }
		
		

		//;
		
		
		//frame.setVisible(true);
		
		//log.setVisible(true);
		
		//if(log.isSucceeded()){
		//	
		//}

	}

}
