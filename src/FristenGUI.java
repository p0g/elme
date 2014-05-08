import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Übersicht der vorhandenen Fristen des Mitglieds
 */
public class FristenGUI extends JDialog {
	
	/**
	 * Zeigt vorhandene Leihen/Medien des Users an
	 * @param frame Hauptfenster
	 * @param mitglied Mitgliedobjekt
	 */
	public FristenGUI(Frame frame, MitgliedDTO mitglied) {		
	
		JPanel panel = new JPanel();
	
		String[] medium;
		ArrayList<String[]> list_table = new ArrayList<String[]>();
		ArrayList<LeiheDTO> list_leihe = new ArrayList<LeiheDTO>();
		
		for(LeiheDTO leihe : mitglied.getLeihen()){
			medium = new String[4];
			medium[0] = leihe.getMedium().getTitel();
			medium[1] = leihe.getMedium().getClass().toString().replace("class ", "");
			medium[2] = leihe.getDatum().toString();
			medium[3] = "Verlängern";
			list_table.add(medium);
			list_leihe.add(leihe);
		}
		
		String[] colNames = new String[] { "Titel", "Art", "Leihfrist", "Verlängern" };
		String[][] data = new String[list_table.size()][4];
		
		for (int i = 0; i < list_table.size(); i++) {
			data[i] = list_table.get(i);
		}
			
        panel.add(new TabelleSortieren(data, colNames, list_leihe));
		
		
		this.add(panel);
		this.setModal(true);
		this.setSize(500, 500);
		this.pack();
		this.setLocationRelativeTo(frame);
		this.setVisible(true);		
	}
	
	/**
	 * Interne Klasse zur sortierung der Tabelle
	 */
	class TabelleSortieren extends JPanel {
	    
	    public TabelleSortieren(String[][] data, String[] colNames, final ArrayList<LeiheDTO> list_leihe) {
	        DefaultTableModel model = new DefaultTableModel(data, colNames);
	        JTable table = new JTable(model);
	       
	        Action verlaenger = new AbstractAction()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	JTable table = (JTable)e.getSource();
	                int modelRow = Integer.valueOf( e.getActionCommand() );
	                
	                LeiheBO.getInstance().verlaenger(list_leihe.get(modelRow));
	                setEnabled(false);
					setVisible(false);
					dispose();
	                //((DefaultTableModel)table.getModel()).setValueAt(null, modelRow, 3);
	                // Original Code: Remove an row
	            	/*JTable table = (JTable)e.getSource();
	                int modelRow = Integer.valueOf( e.getActionCommand() );
	                ((DefaultTableModel)table.getModel()).removeRow(modelRow);
	               	*/
	            }
	        };
	         
	        // externe Klasse um einen "Verlängerbutton" in die Tabelle einzubinden
	        ButtonColumn buttonColumn = new ButtonColumn(table, verlaenger, 3);
	        buttonColumn.setMnemonic(KeyEvent.VK_D);
	        
	        table.setShowGrid(true);
	        table.setGridColor(Color.gray);
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(Color.gray);
	        this.add(new JScrollPane(table));
	        enableSorting(table);
	    }
	    
	    public void enableSorting(JTable table) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        if (model == null)
	            return;

	            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
	            table.setRowSorter(sorter);
	            sorter.setModel(model);
	    }
	}
}
