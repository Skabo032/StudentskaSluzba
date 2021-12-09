package view;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

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
	
}
