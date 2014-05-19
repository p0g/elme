package GUIs;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import java.util.Observable;
import java.util.Observer;

public class StatistikGUI extends JFrame implements Observer {

	private int zCurrentLogin = 0;
	private int zTotalLogin = 0;
	JLabel zLabel1 = null;
	JLabel zLabel2 = null;

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

		zLabel1 = new JLabel("Current Logins: " + zCurrentLogin);
		zLabel1.setSize(200, 20);
		zLabel1.setLocation(50, 50);
		lPanel.add(zLabel1);

		zLabel2 = new JLabel("Total Logins: " + zTotalLogin);
		zLabel2.setSize(200, 20);
		zLabel2.setLocation(50, 100);
		lPanel.add(zLabel2);

		add(lPanel);
		setVisible(true);
	}

	public void update(Observable o, Object arg) {
		if (((String) arg).equals("Login")) {
			zCurrentLogin++;
			zTotalLogin++;
		} else if (((String) arg).equals("Logout")) {
			zCurrentLogin--;
		}
		zLabel1.setText("Current Logins: " + zCurrentLogin);
		zLabel2.setText("Total Logins: " + zTotalLogin);
	}
}
