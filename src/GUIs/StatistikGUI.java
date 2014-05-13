package GUIs;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import java.util.Observable;
import java.util.Observer;

public class StatistikGUI extends JDialog implements Observer{

	public StatistikGUI(JFrame pFrame) {
		super(pFrame, "Login Statistik");
		setSize(300, 200);
		setResizable(false);
		setLayout(null);
		setLocation(10, 10);

		JPanel lPanel = new JPanel();
		lPanel.setSize(300, 200);
		lPanel.setLayout(null);

		JLabel lLabel1 = new JLabel("Current Logins: ");
		lLabel1.setSize(200, 20);
		lLabel1.setLocation(50, 50);
		lPanel.add(lLabel1);

		JLabel lLabel2 = new JLabel("Total Logins: ");
		lLabel2.setSize(200, 20);
		lLabel2.setLocation(50, 100);
		lPanel.add(lLabel2);

		add(lPanel);
		addWindowListener(new WindowListener() {

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
		setVisible(true);
	}

	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
