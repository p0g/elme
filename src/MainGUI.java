import java.awt.Component;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class MainGUI extends JDialog {

	// Attributs
	private Mitgliederverwaltung mv;
	private Leiheverwaltung lv = new Leiheverwaltung();

	private JButton btn_leihen;
	private JButton btn_logout;
	private JButton btn_search;
	private JTextField tf_search;

	public static ArrayList<String> al = new ArrayList<String>();

	// Constructor
	public MainGUI(final Frame frame, final Mitglied mitglied, ArrayList<Medium> medien) {

		super(frame, "Hauptmen�", true);		

		JPanel pan = new JPanel();
		pan.setLayout(null);

		tf_search = new JTextField();
		tf_search.setSize(200, 20);
		tf_search.setLocation(30, 30);
		//tf_search.setText(" Suche");
		pan.add(tf_search);
		
		btn_search = new JButton("Logout");
		btn_search.setSize(150, 20);
		btn_search.setLocation(300, 110);
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Login();
			}
		});

		btn_leihen = new JButton("Leihfristen einsehen");
		btn_leihen.setSize(150, 20);
		btn_leihen.setLocation(300, 80);
		btn_leihen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FristenGUI fristen = new FristenGUI(frame, mitglied);
			}
		});
		pan.add(btn_leihen);

		btn_logout = new JButton("Logout");
		btn_logout.setSize(150, 20);
		btn_logout.setLocation(300, 110);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Login();
			}
		});
		pan.add(btn_logout);
		
		// JList mit Eintr�gen wird erstellt
		final JList list_medien = new JList(medien.toArray());

		list_medien.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = list_medien.locationToIndex(e.getPoint());
					Medium item = (Medium) list_medien.getModel().getElementAt(index);
					
					//System.out.println(item.getTitel());
					MedieninformationGUI mig = new MedieninformationGUI(frame, item, mitglied, lv);
				}
			}
		});
		
		list_medien.setSize(200, 400);
		list_medien.setLocation(30, 80);
		
		tf_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
                ListModel model = list_medien.getModel();
                String suchtext = tf_search.getText().trim();
                if (suchtext == null || suchtext.equals("")){
                	list_medien.setSelectedIndex(-1);
                	
                    return;
                    
                }
                int size = model.getSize();
                for (int i = 0; i < size; i++) {
                    Object o = model.getElementAt(i);
                    if (o.toString().equals(suchtext)) {
                    	list_medien.setSelectedIndex(i);
                        return;
                    }
                }
            }
        });
		
		
		
		pan.add(list_medien);

		frame.add(pan);
		frame.setVisible(true);

	}
}
