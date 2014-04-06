import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainGUI extends JDialog{
	
	// Attributs
	private Mitgliederverwaltung mv;
	
	private JButton btn_leihen;
	private JButton btn_logout;
	private JTextField tf_search;
	
	public static ArrayList<String> al = new ArrayList<String>();    
			
			
	// Constructor
	public MainGUI (final Frame frame, Mitglied mitglied){
		
		super(frame,"Hauptmenü",true);	
		
		
		JPanel pan=new JPanel();
		pan.setLayout(null);
		
		tf_search=new JTextField();
		tf_search.setSize(200, 20);
		tf_search.setLocation(30, 30);
		tf_search.setText(" Suche");
		pan.add(tf_search);
		
		btn_leihen = new JButton("Leihfristen einsehen");
		btn_leihen.setSize(150, 20);
		btn_leihen.setLocation(300, 80);
		btn_leihen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FristenGUI fristen = new FristenGUI(frame, null);
			}
		});
		pan.add(btn_leihen);
		
		btn_logout = new JButton("Logout");
		btn_logout.setSize(150, 20);
		btn_logout.setLocation(300, 110);
		btn_logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Login();
			}
		});
		pan.add(btn_logout);
		
		
		
	   	
		 String interessen[] = {"Politik", "Autos", "Mode", 
		            "Film- und Fernsehen", "Computer", "Tiere", "Sport"};
		 
		        //JList mit Einträgen wird erstellt
		        JList themenAuswahl = new JList(interessen);
		        
		        themenAuswahl.setSize(200, 400);
		        themenAuswahl.setLocation(30, 80);
		 
		        //JList wird Panel hinzugefügt
		        pan.add(themenAuswahl);
		
		        
		        
		        
		
		frame.add(pan);			
		frame.setVisible(true);
		
		
		
		
	}
}
