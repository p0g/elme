import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class LoginGUI extends JDialog{

	//Attribute
	private Mitgliederverwaltung mv;
	private JLabel lbl;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btn;
	private boolean erfolg;
	
	// Eingeloggtes Mitgliedsobjekt
	Mitglied mitglied = null;
	
	
	//Konstruktor
	public LoginGUI(Frame frame, Mitgliederverwaltung mv){
		
		super(frame,"Login",true);
		
		//Fachlicher Teil
		this.mv=mv;
		
		//GUI-Teil
		this.setSize(380, 230);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocation(550, 300);
		
		
		JPanel pan=new JPanel();
		pan.setSize(320, 280);
		pan.setLayout(null);
		
		JLabel lab=new JLabel("Benutzername:");
		lab.setSize(90, 20);
		lab.setLocation(70, 50);
		pan.add(lab);
	
		lab=new JLabel("Passwort:");
		lab.setSize(90, 20);
		lab.setLocation(70, 80);
		pan.add(lab);
		
		tf1=new JTextField();
		tf1.setSize(120, 20);
		tf1.setLocation(165, 50);
		tf1.setText("MaMus1");
		pan.add(tf1);
		
		tf2=new JTextField();
		tf2.setSize(120, 20);
		tf2.setLocation(165, 80);
		tf2.setText("test");
		pan.add(tf2);
		
		btn = new JButton("Einloggen");
		btn.setSize(100, 20);
		btn.setLocation(135, 130);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		pan.add(btn);
		
		lbl=new JLabel("Eingaben ungültig oder falsch!");
		lbl.setSize(200, 20);
		lbl.setLocation(95, 155);
		pan.add(lbl);
		lbl.setVisible(false);
		
		this.add(pan);
		this.addWindowListener(new WindowListener(){

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
				
			}});
		this.setVisible(true);
	}
	
	public void Login(){
		lbl.setVisible(false);
		String name=tf1.getText();
		String pw=tf2.getText();
		boolean test=false;
				
		
		try {
			mitglied = mv.validiere(name, pw);
		} catch (MitgliedNichtExistentException e) {
			
		}
		
		if(mitglied == null){
			// Set the input fields empty and show an general error
			tf1.setText("");
			tf2.setText("");
			lbl.setVisible(true);
			
		}
		else{
			setMitglied(mitglied);
			erfolg = true;
			this.setVisible(false);
			dispose();
			//tf1.setText("Herzlichen");
			//tf2.setText("Glückwunsch!");
			
		}
	}
	
	

	public boolean isErfolg(){
		return erfolg;
	}
	
	private void setMitglied(Mitglied mitglied) {
		this.mitglied = mitglied;
		
	}

	/**
	 * 
	 * @return The Logined Mitglied
	 */
	public Mitglied getMitglied() {
		return this.mitglied;
	}
}
