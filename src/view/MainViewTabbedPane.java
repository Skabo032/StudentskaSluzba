package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainViewTabbedPane extends JTabbedPane
{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// SINGLETON design pattern
	private static MainViewTabbedPane instance = null;
	
	private MainViewTabbedPane() {
		initialise();
	}
	
	public JTable profTable;
	public void update(String action, int value) {
		AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor)profTable.getModel();
		modelProfessor.fireTableDataChanged();
		validate();
	}

	private void initialise() {
		profTable = new ProfessorTable();
		JScrollPane profPanel = new JScrollPane();
		profPanel.setPreferredSize(new Dimension(300, 200));
		
		addTab("Studenti", new JLabel("studenti"));
		addTab("Profesori", profPanel);
		addTab("Predmeti", new JLabel("predmeti"));
		
		profPanel.add(profTable);
		//update(null, -1);
	}
	
	public static MainViewTabbedPane getInstance() {
		if(instance == null)
			instance = new MainViewTabbedPane();
		return instance;
	}
	
}
