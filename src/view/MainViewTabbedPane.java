package view;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class MainViewTabbedPane extends JTabbedPane{
	
	public MainViewTabbedPane() {
		addTab("Studenti", new JLabel("studenti"));
		addTab("Profesori", new JLabel("profesori"));
		addTab("Predmeti", new JLabel("predmeti"));
	}
}
