package view;

import javax.swing.JMenuBar;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.Course;
import model.CourseDataBase;
import model.Grade;
import model.ProfessorDataBase;
import model.Student;
import model.StudentDataBase;


public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu file;
	private JMenuItem fNew;
	private JMenuItem eDelete;
	private JMenu edit;
	private JMenuItem eEdit;
	private JMenuItem fClose;
	private JMenuItem foKatedre;
	private JMenuItem fOpen;
	private JMenuItem foPredmeti;
	private JMenuItem foProfesori;
	private JMenuItem foStudenti;
	private JMenuItem fSave;
	private JMenuItem hAbout;
	private JMenu help;
	private JMenuItem hHelp;
	
	
	public MenuBar() {
		file = new JMenu(MainFrame.getInstance().getResourceBundle().getString("file"));
		file.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon addIco = new ResizeIcon("images" + File.separator + "add.png", 20, 20).getIcon();
		ImageIcon editIco = new ResizeIcon("images"+ File.separator +"edit.png", 20, 20).getIcon();
		ImageIcon deleteIco = new ResizeIcon("images"+ File.separator +"delete.png", 20, 20).getIcon();
		ImageIcon saveIco = new ResizeIcon("images"+ File.separator +"save.png", 20, 20).getIcon();
		ImageIcon openIco = new ResizeIcon("images"+ File.separator +"open.png", 20, 20).getIcon();
		ImageIcon closeIco = new ResizeIcon("images"+ File.separator +"close.png", 20, 20).getIcon();
		ImageIcon helpIco = new ResizeIcon("images"+ File.separator +"help.png", 20, 20).getIcon();
		ImageIcon aboutIco = new ResizeIcon("images"+ File.separator +"about.png", 20, 20).getIcon();
		
		ActionListener aAdd = new AddBtnActionListener();
		fNew = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("new"));
		fNew.setMnemonic(KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fNew.addActionListener(aAdd);
		fNew.setIcon(addIco);
		
		fSave = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("save"));
		fSave.setMnemonic(KeyEvent.VK_S);
		fSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		fSave.setIcon(saveIco);
		fOpen = new JMenu(MainFrame.getInstance().getResourceBundle().getString("open"));
		fOpen.setMnemonic(KeyEvent.VK_O);
		fOpen.setIcon(openIco);
			foStudenti = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("students"));
			foStudenti.setMnemonic(KeyEvent.VK_S);
			foStudenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
			foStudenti.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainViewTabbedPane.getInstance().setSelectedIndex(0);
				}
			});
			foPredmeti = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("courses"));
			foPredmeti.setMnemonic(KeyEvent.VK_C);
			foPredmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
			foPredmeti.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainViewTabbedPane.getInstance().setSelectedIndex(2);					
				}
			});
			foProfesori = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("professors"));
			foProfesori.setMnemonic(KeyEvent.VK_P);
			foProfesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
			foProfesori.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainViewTabbedPane.getInstance().setSelectedIndex(1);
				}
			});
			foKatedre = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("departments"));
			foKatedre.setMnemonic(KeyEvent.VK_D);
			foKatedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
			fOpen.add(foStudenti);
			fOpen.add(foPredmeti);
			fOpen.add(foKatedre);
			fOpen.add(foProfesori);
		fClose = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("close"));
		fClose.setMnemonic(KeyEvent.VK_C);
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		fClose.setIcon(closeIco);
		file.add(fNew);
		file.add(fSave);
		file.add(fOpen);
		file.add(fClose);
		
		edit = new JMenu(MainFrame.getInstance().getResourceBundle().getString("edit"));
		edit.setMnemonic(KeyEvent.VK_E);
		//file.setAccelerator(KeyStroke.getKeyStroke(ActionEvent.CTRL_MASK, KeyEvent.VK_F));
		ActionListener aEdit = new EditBtnActionListener();
		eEdit = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("edit"));
		eEdit.setMnemonic(KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		eEdit.addActionListener(aEdit);
		eEdit.setIcon(editIco);
		ActionListener aDelete = new DeleteBtnActionListener();
		eDelete = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("delete"));
		eDelete.setMnemonic(KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		eDelete.addActionListener(aDelete);
		eDelete.setIcon(deleteIco);
		edit.add(eEdit);
		edit.add(eDelete);
		
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem english = new JCheckBoxMenuItem("English");
		english.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.getInstance().changeLanguage();
				
				
				file.setMnemonic(KeyEvent.VK_F);
				fNew.setMnemonic(KeyEvent.VK_N);
				fSave.setMnemonic(KeyEvent.VK_S);
				fOpen.setMnemonic(KeyEvent.VK_O);
				foStudenti.setMnemonic(KeyEvent.VK_S);
				foPredmeti.setMnemonic(KeyEvent.VK_C);
				foProfesori.setMnemonic(KeyEvent.VK_P);
				foKatedre.setMnemonic(KeyEvent.VK_D);
				fClose.setMnemonic(KeyEvent.VK_C);
				edit.setMnemonic(KeyEvent.VK_E);
				eEdit.setMnemonic(KeyEvent.VK_E);
				eDelete.setMnemonic(KeyEvent.VK_D);
				help.setMnemonic(KeyEvent.VK_H);
				hHelp.setMnemonic(KeyEvent.VK_H);
				hAbout.setMnemonic(KeyEvent.VK_A);
				
			}
		});
		english.setSelected(true);
		JMenuItem srpski = new JCheckBoxMenuItem("Srpski");
		srpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();
				file.setMnemonic(KeyEvent.VK_D);
				fNew.setMnemonic(KeyEvent.VK_N);
				fSave.setMnemonic(KeyEvent.VK_S);
				fOpen.setMnemonic(KeyEvent.VK_O);
				foStudenti.setMnemonic(KeyEvent.VK_S);
				foPredmeti.setMnemonic(KeyEvent.VK_P);
				foProfesori.setMnemonic(KeyEvent.VK_R);
				foKatedre.setMnemonic(KeyEvent.VK_K);
				fClose.setMnemonic(KeyEvent.VK_Z);
				edit.setMnemonic(KeyEvent.VK_I);
				eEdit.setMnemonic(KeyEvent.VK_I);
				eDelete.setMnemonic(KeyEvent.VK_O);
				help.setMnemonic(KeyEvent.VK_P);
				hHelp.setMnemonic(KeyEvent.VK_P);
				hAbout.setMnemonic(KeyEvent.VK_I);
			}
		});
		//srpski.setSelected(true);
		hHelp = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("help"));
		hHelp.setMnemonic(KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		hHelp.setIcon(helpIco);
		hHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new HelpDialog();
			}
		});
		
		hAbout = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("about"));
		hAbout.setMnemonic(KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		hAbout.setIcon(aboutIco);
		hAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AboutDialog();
				
			}
		});
		
		help.add(english);
		help.add(srpski);
		help.addSeparator();
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(english);
		bg.add(srpski);
	}
	
	public void changeLanguage() {
		file.setText(MainFrame.getInstance().getResourceBundle().getString("file"));
		fNew.setText(MainFrame.getInstance().getResourceBundle().getString("new"));
		eDelete.setText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		eEdit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		fClose.setText(MainFrame.getInstance().getResourceBundle().getString("close"));
		foKatedre.setText(MainFrame.getInstance().getResourceBundle().getString("departments"));
		fOpen.setText(MainFrame.getInstance().getResourceBundle().getString("open"));
		foPredmeti.setText(MainFrame.getInstance().getResourceBundle().getString("courses"));
		foProfesori.setText(MainFrame.getInstance().getResourceBundle().getString("professors"));
		foStudenti.setText(MainFrame.getInstance().getResourceBundle().getString("students"));
		fSave.setText(MainFrame.getInstance().getResourceBundle().getString("save"));
		hAbout.setText(MainFrame.getInstance().getResourceBundle().getString("about"));
		hHelp.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		edit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
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
					if(CourseTable.getInstance().getSelectedRow() != -1)
						new CourseEditDialog();
					break;
				default:
					/* skip */
				}
			}
		}
		class DeleteBtnActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {MainFrame.getInstance().getResourceBundle().getString("yes"), 
						MainFrame.getInstance().getResourceBundle().getString("no")};
				int answer;
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					int selectedIndex1 = StudentTable.getInstance().getSelectedRow();
					if(selectedIndex1 != -1)
					{
						
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteStudentQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteStudent"), 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
						if(answer == JOptionPane.YES_OPTION)
							StudentDataBase.getInstance().removeStudentByRowNum(StudentTable.getInstance().convertRowIndexToModel(selectedIndex1));
						StudentTable.getInstance().update();
					}
					break;
				case 1:	// PROFFESOR
					int selectedIndex2 = ProfessorTable.getInstance().getSelectedRow();
					if(selectedIndex2 != -1) {
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteProfessorQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteProfessor"), 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
		
						if(answer == JOptionPane.YES_OPTION) {
							for(Course c : CourseDataBase.getInstance().getCourses()) {
								if(c.getCourseProffesor() != null && 
										c.getCourseProffesor().getIdNumber().equals(ProfessorDataBase.getInstance().getProfessor(ProfessorTable.getInstance().convertRowIndexToModel(selectedIndex2)).getIdNumber()))
									c.setCourseProffesor(null);
							}
							ProfessorDataBase.getInstance().removeProfessorByRowNum(ProfessorTable.getInstance().convertRowIndexToModel(selectedIndex2));
						}
						CourseTable.getInstance().update();
						ProfessorTable.getInstance().update();
					}
					break;
				case 2:	// COURSE
					int selectedIndex3 = CourseTable.getInstance().getSelectedRow();
					if(selectedIndex3 != -1)
					{
						
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteCourseQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteCourse"), 
																JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																options, 
																options[0]);
						if(answer == JOptionPane.YES_OPTION) {
							// deletes selected exam from every students unpassed exam list
							for(Student s : StudentDataBase.getInstance().getStudents()) {
								for(Grade g : s.getUnfinishedExams()) {
									if(g.getCourse().equals(CourseDataBase.getInstance().getCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex3))))
										s.getUnfinishedExams().remove(g);
								}
							}
							
							CourseDataBase.getInstance().removeCourseByRowNum(CourseTable.getInstance().convertRowIndexToModel(selectedIndex3));
						}
						CourseTable.getInstance().update();
					}
					break;
				default:
					/* skip */
				}
			}
		}
}
