package GUIs;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import data_transfer_objects.BuchDTO;
import data_transfer_objects.CDDTO;
import data_transfer_objects.DvDDTO;
import data_transfer_objects.MediumDTO;
import data_transfer_objects.MitgliedDTO;
import business_objects.MitgliedBO;

/**
 * Fenster zum Anzeigen der Details zu einem Medium anzeigt
 * 
 * @author pq
 * 
 */
public class MedieninformationGUI extends JFrame {

	private static final long serialVersionUID = 6330962125257015674L;

	// Attribute/Komponenten
	private JPanel pan;
	private MitgliedDTO mg;
	private MediumDTO m;

	// Konstruktor
	public MedieninformationGUI(MediumDTO m, MitgliedDTO mg) {
		super("Medieninformationen");
		this.mg = mg;
		this.m = m;
		
		setSize(600, 250);
		setLocation(550, 300);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pan = new JPanel();
		pan.setSize(600, 250);
		pan.setLayout(null);

		// Umst�ndlicher IF-Schei� mit Methoden deshalb, weil es mMn besser
		// erweiterbar und wartbar ist als wenn man den Konstruktor �berl�dt

		if (m instanceof CDDTO) {
			createACDWindow((CDDTO) m);
		} else {
			if (m instanceof DvDDTO) {
				createADVDWindow((DvDDTO) m);
			} else {
				if (m instanceof BuchDTO) {
					createABookWindow((BuchDTO) m);
				} else {
					System.out.println("Medium wurde nicht erkannt");
					JLabel lab = new JLabel("Das Medium wurde nicht erkannt!");
					lab.setBounds(200, 150, 200, 20);
					pan.add(lab);
				}
			}
		}

		add(pan);
		setVisible(true);
	}

	// Methoden

	private void createABookWindow(BuchDTO b) {

		// Titel
		JLabel lab = new JLabel("Titel:");
		lab.setBounds(50, 50, 150, 20);
		pan.add(lab);

		lab = new JLabel(b.getTitel());
		lab.setBounds(205, 50, 200, 20);
		pan.add(lab);

		// Interpret
		lab = new JLabel("Interpret:");
		lab.setBounds(50, 75, 150, 20);
		pan.add(lab);

		lab = new JLabel(b.getVerfasser());
		lab.setBounds(205, 75, 200, 20);
		pan.add(lab);

		// Erscheinungsahr
		lab = new JLabel("Erscheinungsjahr:");
		lab.setBounds(50, 100, 150, 20);
		pan.add(lab);

		lab = new JLabel(Integer.toString(b.getJahr()));
		lab.setBounds(205, 100, 200, 20);
		pan.add(lab);

		// Label
		lab = new JLabel("Label:");
		lab.setBounds(50, 125, 150, 20);
		pan.add(lab);

		lab = new JLabel(b.getVerlag());
		lab.setBounds(205, 125, 200, 20);
		pan.add(lab);

		// ISBN
		lab = new JLabel("ISBN:");
		lab.setBounds(50, 150, 150, 20);
		pan.add(lab);

		lab = new JLabel(b.getIsbn());
		lab.setBounds(205, 150, 200, 20);
		pan.add(lab);

		// Button
		JButton btn = new JButton("Entleihen");
		btn.setBounds(415, 75, 150, 20);
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				entleihe();

				setEnabled(false);
				setVisible(false);
				dispose();

			}
		});
		pan.add(btn);

		// Status
		lab = new JLabel("Status:");
		lab.setBounds(415, 50, 50, 20);
		pan.add(lab);

		if (m.isEntliehen()) {
			lab = new JLabel("Entliehen");
			btn.setEnabled(false);
		} else {
			lab = new JLabel("Entleihbar");
			btn.setEnabled(true);
		}

		lab.setBounds(470, 50, 100, 20);
		pan.add(lab);

	}

	private void createACDWindow(CDDTO c) {
		// Titel
		JLabel lab = new JLabel("Titel:");
		lab.setBounds(50, 50, 150, 20);
		pan.add(lab);

		lab = new JLabel(c.getTitel());
		lab.setBounds(205, 50, 200, 20);
		pan.add(lab);

		// Interpret
		lab = new JLabel("Interpret:");
		lab.setBounds(50, 75, 150, 20);
		pan.add(lab);

		lab = new JLabel(c.getInterpret());
		lab.setBounds(205, 75, 200, 20);
		pan.add(lab);

		// Erscheinungsahr
		lab = new JLabel("Erscheinungsjahr:");
		lab.setBounds(50, 100, 150, 20);
		pan.add(lab);

		lab = new JLabel(Integer.toString(c.getJahr()));
		lab.setBounds(205, 100, 200, 20);
		pan.add(lab);

		// Label
		lab = new JLabel("Label:");
		lab.setBounds(50, 125, 150, 20);
		pan.add(lab);

		lab = new JLabel(c.getLabel());
		lab.setBounds(205, 125, 200, 20);
		pan.add(lab);

		// Button
		JButton btn = new JButton("Entleihen");
		btn.setBounds(415, 75, 150, 20);
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				entleihe();

				setEnabled(false);
				setVisible(false);
				dispose();

			}
		});
		pan.add(btn);

		// Status
		lab = new JLabel("Status:");
		lab.setBounds(415, 50, 50, 20);
		pan.add(lab);

		if (m.isEntliehen()) {
			lab = new JLabel("Entliehen");
			btn.setEnabled(false);
		} else {
			lab = new JLabel("Entleihbar");
			btn.setEnabled(true);
		}

		lab.setBounds(470, 50, 100, 20);
		pan.add(lab);

	}

	private void createADVDWindow(DvDDTO d) {
		// Titel
		JLabel lab = new JLabel("Titel:");
		lab.setBounds(50, 50, 150, 20);
		pan.add(lab);

		lab = new JLabel(d.getTitel());
		lab.setBounds(205, 50, 200, 20);
		pan.add(lab);

		// FSK
		lab = new JLabel("FSK:");
		lab.setBounds(50, 75, 150, 20);
		pan.add(lab);

		lab = new JLabel(Integer.toString(d.getFsk()));
		lab.setBounds(205, 75, 200, 20);
		pan.add(lab);

		// Erscheinungsahr
		lab = new JLabel("Erscheinungsjahr:");
		lab.setBounds(50, 100, 150, 20);
		pan.add(lab);

		lab = new JLabel(Integer.toString(d.getJahr()));
		lab.setBounds(205, 100, 200, 20);
		pan.add(lab);

		// Spieldauer
		lab = new JLabel("Spieldauer (Minuten):");
		lab.setBounds(50, 125, 150, 20);
		pan.add(lab);

		lab = new JLabel(Integer.toString(d.getSpieldauer()));
		lab.setBounds(205, 125, 200, 20);
		pan.add(lab);

		// Button
		JButton btn = new JButton("Entleihen");
		btn.setBounds(415, 75, 150, 20);
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				entleihe();

				setEnabled(false);
				setVisible(false);
				dispose();

			}
		});
		pan.add(btn);

		// Status
		lab = new JLabel("Status:");
		lab.setBounds(415, 50, 50, 20);
		pan.add(lab);

		if (m.isEntliehen()) {
			lab = new JLabel("Entliehen");
			btn.setEnabled(false);
		} else {
			lab = new JLabel("Entleihbar");
			btn.setEnabled(true);
		}

		lab.setBounds(470, 50, 100, 20);
		pan.add(lab);

	}

	private void entleihe() {
		MitgliedBO.getInstance().addLeihe(mg, m);
	}
}
