package main;

import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		JMenuItem fNew = new JMenuItem("New");
		JMenuItem fSave = new JMenuItem("Save");
		JMenu fOpen = new JMenu("Open");
			JMenuItem foStudenti = new JMenu("Studenti");
			JMenuItem foPredmeti = new JMenu("Predmeti");
			JMenuItem foProfesori = new JMenu("Profesori");
			JMenuItem foKatedre = new JMenu("Katedre");
			fOpen.add(foStudenti);
			fOpen.add(foPredmeti);
			fOpen.add(foKatedre);
			fOpen.add(foProfesori);
		JMenuItem fClose = new JMenuItem("Close");
		file.add(fNew);
		file.add(fSave);
		file.add(fOpen);
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem eEdit = new JMenuItem("Edit");
		JMenuItem eDelete = new JMenuItem("Delete");
		edit.add(eEdit);
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		JMenuItem hHelp = new JMenuItem("Help");
		JMenuItem hAbout = new JMenuItem("About");
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
		
		
		
		
		
	}

}
