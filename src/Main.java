import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import sonstiges.*;
import data_access_objects.MediumDAO;
import data_access_objects.MitgliedDAO;
import data_transfer_objects.*;
import GUIs.*;
import business_objects.MitgliedBO;

public class Main {

	public static void main(String[] args) {

		/* Testdaten die nicht im Rahmen des Projektes erfasst werden sollen */
		
		Adresse ad01 = new Adresse("EFS", 44, 44227, "Dortmund", "DE");
		MitgliedDAO.getInstance().create("Meier", "Peter", "peme", "peme1", "2000-04-12", ad01);
		
		
		BuchDTO b1 = ConcreteMedienFactory.getInstance().createBook("Das erste Buch", 1999, "James Dick", "Stern Verlag", "123-456-789");
		BuchDTO b2 = ConcreteMedienFactory.getInstance().createBook("Das zweite Buch", 2000, "Kirk", "Buchbinder", "222-333-444");
		DvDDTO d1 = ConcreteMedienFactory.getInstance().createDvD("Die Reise", 1980, 12, 120);
		MediumDAO.getInstance().create(b1);
		MediumDAO.getInstance().create(b2);
		MediumDAO.getInstance().create(d1);
		//MitgliedBO.getInstance().addLeihe(mg01, b2);
		//MitgliedDAO.getInstance().create(mg01);
		/*
		 * ######################################################################
		 * #
		 */

		/* Neuen Hauptframe erstellen */
		final JFrame frame = new JFrame("Verwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocation(550, 300);
		// ############################

		frame.setVisible(false);
		StatistikGUI lStatistikGUI = new StatistikGUI(frame);
		// LoginGUI starten und auf Login warten (Modular)
		LoginGUI login = new LoginGUI(frame);

		if (login.isErfolg()) {
			// Login is ok
			// Hole eingeloggtes Mitglied
			MitgliedDTO mitglied = login.getMitglied();

			// Lade das Hauptfenster
			MainGUI main = new MainGUI(frame, mitglied, MediumDAO.getInstance().getMedien());
		}
		// #############################
	}
}
