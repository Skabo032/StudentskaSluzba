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
	

	private void initialise() {
		ProfessorTable profTable = new ProfessorTable();
		
		addTab("Studenti", new JLabel("studenti"));
		addTab("Profesori", new JScrollPane(profTable));
		addTab("Predmeti", new JLabel("predmeti"));
		
		AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor)profTable.getModel();
		modelProfessor.fireTableDataChanged();
		validate();
	}
	
	public static MainViewTabbedPane getInstance() {
		if(instance == null)
			instance = new MainViewTabbedPane();
		return instance;
	}
	
}
