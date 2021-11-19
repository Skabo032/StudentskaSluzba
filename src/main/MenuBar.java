package main;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem fNew = new JMenuItem("New");
		fNew.setMnemonic(KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem fSave = new JMenuItem("Save");
		fSave.setMnemonic(KeyEvent.VK_S);
		fSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		JMenu fOpen = new JMenu("Open");
		fOpen.setMnemonic(KeyEvent.VK_O);
			JMenuItem foStudenti = new JMenuItem("Studenti");
			foStudenti.setMnemonic(KeyEvent.VK_S);
			foStudenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
			JMenuItem foPredmeti = new JMenuItem("Predmeti");
			foPredmeti.setMnemonic(KeyEvent.VK_P);
			foPredmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
			JMenuItem foProfesori = new JMenuItem("Profesori");
			foProfesori.setMnemonic(KeyEvent.VK_R);
			foProfesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
			JMenuItem foKatedre = new JMenuItem("Katedre");
			foKatedre.setMnemonic(KeyEvent.VK_K);
			foKatedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
			fOpen.add(foStudenti);
			fOpen.add(foPredmeti);
			fOpen.add(foKatedre);
			fOpen.add(foProfesori);
		JMenuItem fClose = new JMenuItem("Close");
		fClose.setMnemonic(KeyEvent.VK_C);
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		file.add(fNew);
		file.add(fSave);
		file.add(fOpen);
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		//file.setAccelerator(KeyStroke.getKeyStroke(ActionEvent.CTRL_MASK, KeyEvent.VK_F));
		JMenuItem eEdit = new JMenuItem("Edit");
		eEdit.setMnemonic(KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		JMenuItem eDelete = new JMenuItem("Delete");
		eDelete.setMnemonic(KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		edit.add(eEdit);
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem hHelp = new JMenuItem("Help");
		hHelp.setMnemonic(KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		JMenuItem hAbout = new JMenuItem("About");
		hAbout.setMnemonic(KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
		
		
		
		
		
	}

}
