import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FristenGUI extends JDialog {
	
	/**
	 * 
	 * @param frame Hauptfenster
	 * @param leihe Leiheobject mit vorhandenen Medien des Nutzers
	 */
	public FristenGUI(Frame frame, Leihe leihe) {
		
	
		JPanel panel = new JPanel();
		panel.add(new JLabel("Dialog"));
		
		
		this.add(panel);
		this.setModal(true);
		this.setSize(300, 300);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}
	

	
	//dialog.add(panel);

	//

}
