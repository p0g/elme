package GUIs;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import sonstiges.MitgliedNichtExistentException;
import business_objects.MitgliedBO;
import data_transfer_objects.MitgliedDTO;

/**
 * LoginGUI die es einem Mitglied ermöglicht sich einzuloggen ACHTUNG:
 * Logindaten wurden schon in die Textfelder eingetragen um ein ständiges
 * Neu-Eingeben beim Entwickeln zu vermeiden.
 */
public class LoginGUI extends JDialog {

	// Attribute
	private JLabel lbl;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btn;
	private boolean erfolg;

	// Mitgliedsobjekt das mit Mitglied belegt wird, wenn eingeloggt
	MitgliedDTO mitglied = null;

	/**
	 * Konstruktor der LoginGUI
	 * 
	 * @param frame Hauptfenster (zur Orientierung)
	 * @param mv Mitgliederverwaltung
	 */
	public LoginGUI(Frame frame) {
		super(frame, "Login");

		// GUI-Teil
		this.setSize(380, 230);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocation(550, 300);

		JPanel pan = new JPanel();
		pan.setSize(320, 280);
		pan.setLayout(null);

		JLabel lab = new JLabel("Benutzername:");
		lab.setSize(90, 20);
		lab.setLocation(70, 50);
		pan.add(lab);

		lab = new JLabel("Passwort:");
		lab.setSize(90, 20);
		lab.setLocation(70, 80);
		pan.add(lab);

		tf1 = new JTextField();
		tf1.setSize(120, 20);
		tf1.setLocation(165, 50);
		// Voreingegebene Daten für schnelleren Login bei der Entwicklung
		tf1.setText("mamu");
		pan.add(tf1);

		tf2 = new JTextField();
		tf2.setSize(120, 20);
		tf2.setLocation(165, 80);
		// Voreingegebene Daten für schnelleren Login bei der Entwicklung
		tf2.setText("mamu1");
		pan.add(tf2);

		btn = new JButton("Einloggen");
		btn.setSize(100, 20);
		btn.setLocation(135, 130);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		pan.add(btn);

		lbl = new JLabel("Eingaben ungültig oder falsch!");
		lbl.setSize(200, 20);
		lbl.setLocation(95, 155);
		pan.add(lbl);
		lbl.setVisible(false);

		this.add(pan);
		this.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}
		});

		// LoginGUI anzeigen
		this.setVisible(true);
	}

	// Logindaten verarbeiten
	public void Login() {
		lbl.setVisible(false);
		String name = tf1.getText();
		String pw = tf2.getText();

		try {
			mitglied = MitgliedBO.getInstance().validiere(name, pw);
		} catch (MitgliedNichtExistentException e) {
			JOptionPane.showMessageDialog(this, "Dieses Mitglied existiert nicht.");
		}

		if (mitglied == null) {
			// Set the input fields empty and show an general error
			tf1.setText("");
			tf2.setText("");
			lbl.setVisible(true);

		} else {
			setMitglied(mitglied);
			erfolg = true;
			this.setVisible(false);
			// dispose();
			// tf1.setText("Herzlichen");
			// tf2.setText("GlŸckwunsch!");

		}
	}

	public boolean isErfolg() {
		return erfolg;
	}

	private void setMitglied(MitgliedDTO mitglied) {
		this.mitglied = mitglied;
	}

	/**
	 * 
	 * @return The Logined Mitglied
	 */
	public MitgliedDTO getMitglied() {
		return this.mitglied;
	}
}
