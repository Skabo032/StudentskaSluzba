package view;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;


enum Tab {
	STUDENT,
	PROFESSOR,
	COURSE
}

public class MainViewTabbedPane extends JTabbedPane{	
	
	// SINGLETON design pattern
	private static MainViewTabbedPane instance = null;
	
	private MainViewTabbedPane() {
		initialise();
	}
	
	private void initialise() {
		addTab("Studenti", new JLabel("studenti"));
		addTab("Profesori", new JLabel("profesori"));
		addTab("Predmeti", new JLabel("predmeti"));
	}
	
	public static MainViewTabbedPane getInstance() {
		if(instance == null)
			instance = new MainViewTabbedPane();
		return instance;
	}
	
	/*
	public Tab getTab() {
		switch(instance.getSelectedIndex()) {
		case 0:
			return Tab.STUDENT;
		case 1:
			return Tab.PROFESSOR;
		case 2:
			return Tab.COURSE;
		default:
			return null;
		
		}
	}
	*/
}
