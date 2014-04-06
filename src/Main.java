import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		Mitgliederverwaltung mv=new Mitgliederverwaltung();
		
		Medienverwaltung medienV = new Medienverwaltung();
		
		Leiheverwaltung lv = new Leiheverwaltung();
		
		
		
		
			
		/* Testdaten die nicht in Rahmen des Projektes manuell erfasst werden */
		
		Adresse ad01=new Adresse("EFS", 44, 44227, "Dortmund", "DE");
		Mitglied mg01=new Mitglied("Mustermann", "Max", "test", "27.1.82", ad01);
		
		Buch b1 = new Buch("Das erste Buch", 1999, "James Dick", "Stern Verlag", "123-456-789");
		Buch b2 = new Buch("Das zweite Buch", 2000, "Kirk", "Buchbinder", "222-333-444");
		DVD d1 = new DVD("Die Reise", 1980, 12, 120);
		
		medienV.addMedium(b1);
		medienV.addMedium(b2);
		medienV.addMedium(d1);
				
		lv.addLeihe(mg01, b2);

		mv.addMitglied(mg01);
			
		/* ####################################################################### */
		
		
		
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
        	login.dispose();
        	
        	
        	
        	
        	
        	
        	// Login is ok, load the Mainmenu
        	MainGUI main = new MainGUI(frame, mitglied, medienV.getMedien());
        }
		
		

		//;
		
		
		//frame.setVisible(true);
		
		//log.setVisible(true);
		
		//if(log.isSucceeded()){
		//	
		//}

	}

}
