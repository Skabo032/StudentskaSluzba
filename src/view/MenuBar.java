package view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.CourseDataBase;
import model.ProfessorDataBase;
import model.StudentDataBase;


public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon addIco = new ResizeIcon("images/add.png", 20, 20).getIcon();
		ImageIcon editIco = new ResizeIcon("images/edit.png", 20, 20).getIcon();
		ImageIcon deleteIco = new ResizeIcon("images/delete.png", 20, 20).getIcon();
		ImageIcon saveIco = new ResizeIcon("images/save.png", 20, 20).getIcon();
		ImageIcon openIco = new ResizeIcon("images/open.png", 20, 20).getIcon();
		ImageIcon closeIco = new ResizeIcon("images/close.png", 20, 20).getIcon();
		ImageIcon helpIco = new ResizeIcon("images/help.png", 20, 20).getIcon();
		ImageIcon aboutIco = new ResizeIcon("images/about.png", 20, 20).getIcon();
		
		ActionListener aAdd = new AddBtnActionListener();
		JMenuItem fNew = new JMenuItem("New");
		fNew.setMnemonic(KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fNew.addActionListener(aAdd);
		fNew.setIcon(addIco);
		
		JMenuItem fSave = new JMenuItem("Save");
		fSave.setMnemonic(KeyEvent.VK_S);
		fSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		fSave.setIcon(saveIco);
		JMenu fOpen = new JMenu("Open");
		fOpen.setMnemonic(KeyEvent.VK_O);
		fOpen.setIcon(openIco);
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
		fClose.setIcon(closeIco);
		file.add(fNew);
		file.add(fSave);
		file.add(fOpen);
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		//file.setAccelerator(KeyStroke.getKeyStroke(ActionEvent.CTRL_MASK, KeyEvent.VK_F));
		ActionListener aEdit = new EditBtnActionListener();
		JMenuItem eEdit = new JMenuItem("Edit");
		eEdit.setMnemonic(KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		eEdit.addActionListener(aEdit);
		eEdit.setIcon(editIco);
		ActionListener aDelete = new DeleteBtnActionListener();
		JMenuItem eDelete = new JMenuItem("Delete");
		eDelete.setMnemonic(KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		eDelete.addActionListener(aDelete);
		eDelete.setIcon(deleteIco);
		edit.add(eEdit);
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem hHelp = new JMenuItem("Help");
		hHelp.setMnemonic(KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		hHelp.setIcon(helpIco);
		JMenuItem hAbout = new JMenuItem("About");
		hAbout.setMnemonic(KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		hAbout.setIcon(aboutIco);
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
	}
		class AddBtnActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					new StudentAddDialog();
					
					break;
				case 1:	// PROFFESOR
					new ProfessorDialog(true);
					break;
				case 2:	// COURSE
					/* skip */
					new CourseAddDialog();
					break;
				default:
					/* skip */
				}
			}
		}
		class EditBtnActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					if(StudentTable.getInstance().getSelectedRow() != -1)
						new StudentEditDialog();
					break;
				case 1:	// PROFFESOR
					if(ProfessorTable.getInstance().getSelectedRow() != -1)
						new ProfessorDialog(false);
					break;
				case 2:	// COURSE
					/* skip */
					break;
				default:
					/* skip */
				}
			}
		}
		class DeleteBtnActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"DA", "Ne"};
				int answer;
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					if(StudentTable.getInstance().getSelectedRow() != -1)
					{
						
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
																"Da li stvarno zelite da obrisete odabranog studenta?", 
																"Brisanje studenta", 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
						if(answer == JOptionPane.YES_OPTION)
							StudentDataBase.getInstance().removeStudentByRowNum(StudentTable.getInstance().getSelectedRow());
						StudentTable.getInstance().update();
					}
					break;
				case 1:	// PROFFESOR
					if(ProfessorTable.getInstance().getSelectedRow() != -1) {
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
																"Da li stvarno zelite da obrisete odabranog profesora?", 
																"Brisanje profesora", 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
		
						if(answer == JOptionPane.YES_OPTION)
							ProfessorDataBase.getInstance().removeProfessorByRowNum(ProfessorTable.getInstance().getSelectedRow());
						ProfessorTable.getInstance().update();
					}
					break;
				case 2:	// COURSE
					if(CourseTable.getInstance().getSelectedRow() != -1)
					{
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
																"Da li stvarno zelite da obrisete odabrani predmet?", 
																"Brisanje predmeta", 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
						if(answer == JOptionPane.YES_OPTION)
							CourseDataBase.getInstance().removeCourseByRowNum(CourseTable.getInstance().getSelectedRow());
						CourseTable.getInstance().update();
					}
					break;
				default:
					/* skip */
				}
			}
		}
}
