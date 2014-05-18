package GUIs;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import java.util.Observable;
import java.util.Observer;

public class StatistikGUI extends JFrame implements Observer{

	public StatistikGUI() {
		super("Login Statistik");
		setSize(300, 200);
		setResizable(false);
		setLayout(null);
		setLocation(10, 10);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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
		setVisible(true);
	}

	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
