package view;

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
		//StudentTable studTable = new StudentTable();
		//CourseTable courseTable = new CourseTable();

		
		addTab(MainFrame.getInstance().getResourceBundle().getString("students"), new JScrollPane(StudentTable.getInstance()));
		addTab(MainFrame.getInstance().getResourceBundle().getString("professors"), new JScrollPane(ProfessorTable.getInstance()));
		addTab(MainFrame.getInstance().getResourceBundle().getString("courses"), new JScrollPane(CourseTable.getInstance()));
		
	}
	
	public void changeLanguage() {
		setTitleAt(0, MainFrame.getInstance().getResourceBundle().getString("students"));
		setTitleAt(1, MainFrame.getInstance().getResourceBundle().getString("professors"));
		setTitleAt(2, MainFrame.getInstance().getResourceBundle().getString("courses"));
	}	
	public static MainViewTabbedPane getInstance() {
		if(instance == null)
			instance = new MainViewTabbedPane();
		return instance;
	}
	
}
