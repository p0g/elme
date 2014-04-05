import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class MedieninformationGUI extends JFrame{
	
	/*Klasse ist noch nicht fertig. Bitte noch nichts ändern!
	 * Danke, 
	 * Sascha
	 */
	
	private static final long serialVersionUID = 6330962125257015674L;
	
	//Attribute/Komponenten
	private JPanel pan;
	
	//Konstruktor
	public MedieninformationGUI(Medium m/*, MainGUI win*/){
		//win.setEnabled(false);
		
		this.setSize(600, 400);
		this.setLocation(550, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				setEnabled(false);
				setVisible(false);
				//dispose();
				
				//AUF JEDEN FALL SPAETER ENTFERNEN, NUR FUER TESTZWECKE!
				System.exit(0);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		pan = new JPanel();
		pan.setSize(500, 500);
		pan.setLayout(null);
		
		//Umständlicher IF-Scheiß mit Methoden deshalb, weil es mMn besser erweiterbar und wartbar ist als wenn man den Konstruktor überlädt
		
		if(m instanceof CD){
			createACDWindow((CD) m);
		}
		else{
			if(m instanceof DVD){
				createADVDWindow((DVD) m);
			}
			else{
				if(m instanceof Buch){
					createABookWindow((Buch) m);
				}
				else{
					JLabel lab = new JLabel("Das Medium wurde nicht erkannt!");
					lab.setBounds(200, 150, 200, 20);
					pan.add(lab);
				}
			}
		}
		
		this.add(pan);
		this.setVisible(true);
	}
	
	//Methoden

	private void createABookWindow(Buch b){
		
		
	}
	
	private void createACDWindow(CD c){
		//Titel
		JLabel lab = new JLabel("Titel:");
		lab.setBounds(50, 50, 150, 20);
		pan.add(lab);
		
		lab = new JLabel(c.getTitel());
		lab.setBounds(205, 50, 200, 20);
		pan.add(lab);
		
		//Interpret
		lab = new JLabel("Interpret:");
		lab.setBounds(50, 75, 150, 20);
		pan.add(lab);
		
		lab = new JLabel(c.getInterpret());
		lab.setBounds(205, 75, 200, 20);
		pan.add(lab);
		
		//Erscheinungsahr
		lab = new JLabel("Erscheinungsjahr:");
		lab.setBounds(50, 100, 150, 20);
		pan.add(lab);
		
		lab = new JLabel(Integer.toString(c.getJahr()));
		lab.setBounds(205, 100, 200, 20);
		pan.add(lab);
		
		//Label
		lab = new JLabel("Label:");
		lab.setBounds(50, 125, 150, 20);
		pan.add(lab);
		
		lab = new JLabel(c.getLabel());
		lab.setBounds(205, 125, 200, 20);
		pan.add(lab);
	}

	private void createADVDWindow(DVD d){
	
	
	}
}
