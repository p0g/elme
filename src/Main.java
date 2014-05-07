import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		// Globale Mitgliederverwaltung
		Mitgliederverwaltung mv=Mitgliederverwaltung.getInstance();
		// Globale Medienverwaltung (Biblithek)
		Medienverwaltung medienV =Medienverwaltung.getInstance();	
		
			
		/* Testdaten die nicht im Rahmen des Projektes erfasst werden sollen */		
		Adresse ad01=new Adresse("EFS", 44, 44227, "Dortmund", "DE");
		Mitglied mg01=new Mitglied("Mustermann", "Max", "test", "27.1.82", ad01);		
		Buch b1 = new Buch("Das erste Buch", 1999, "James Dick", "Stern Verlag", "123-456-789");
		Buch b2 = new Buch("Das zweite Buch", 2000, "Kirk", "Buchbinder", "222-333-444");
		DVD d1 = new DVD("Die Reise", 1980, 12, 120);		
		medienV.addMedium(b1);
		medienV.addMedium(b2);
		medienV.addMedium(d1);				
		mg01.addLeihe(b2);
		mv.addMitglied(mg01);			
		/* ####################################################################### */	
		
		
		/* Neuen Hauptframe erstellen */
		final JFrame frame = new JFrame("Verwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
		frame.setLocation(550, 300);		
		// ############################
		
		
		frame.setVisible(false);
		
		// LoginGUI starten und auf Login warten (Modular)
        LoginGUI login = new LoginGUI(frame, mv);
        
        if(login.isErfolg()){
        	// Login is ok 
        	// Hole eingeloggtes Mitglied
        	Mitglied mitglied = login.getMitglied();
        	
        	// Lade das Hauptfenster
        	MainGUI main = new MainGUI(frame, mitglied, medienV.getMedien());
        }
        // #############################
	}
}
