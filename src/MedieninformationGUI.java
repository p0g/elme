import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class MedieninformationGUI extends JFrame{
	
	/*Klasse ist noch nicht fertig. Bitte noch nichts ändern!
	 * Danke, 
	 * Sascha
	 */
	
	private static final long serialVersionUID = 6330962125257015674L;
	
	//Attribute
	
	//Konstruktor
	public MedieninformationGUI(Medium m, LoginGUI win){
		win.setEnabled(false);
		
		this.setSize(500, 500);
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
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
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
		
		JPanel pan = new JPanel();
		pan.setSize(500, 500);
		pan.setLayout(null);
		
		/*Unter anderem an dieser Stelle fehlt noch ne ganze Menge! */
		
		this.add(pan);
		this.setVisible(true);
	}
	
	//Methoden

}
