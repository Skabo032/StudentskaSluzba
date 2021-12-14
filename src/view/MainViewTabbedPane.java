package view;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
		StudentTable studTable = new StudentTable();
		CourseTable courseTable = new CourseTable();

		
		addTab("Studenti", new JScrollPane(studTable));
		addTab("Profesori", new JScrollPane(profTable));
		addTab("Predmeti", new JScrollPane(courseTable));
		
		/*AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor)profTable.getModel();
		modelProfessor.fireTableDataChanged();
		validate();*/
	}
	
	public static MainViewTabbedPane getInstance() {
		if(instance == null)
			instance = new MainViewTabbedPane();
		return instance;
	}
	
}
