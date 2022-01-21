package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import java.util.regex.*;

import model.Course;
import model.CourseDataBase;
import model.Grade;
import model.ProfessorDataBase;
import model.Student;
import model.StudentDataBase;
import view.ProfessorDialog;

public class ToolBar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnAdd;
	JButton btnEdit;
	JButton btnDelete;
	JTextField search;
	JButton btnSearch;
	
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		// all of the icon images are imported and resized
		ImageIcon addIco = new ResizeIcon("images" + File.separator + "add.png", 20, 20).getIcon();
		ImageIcon editIco = new ResizeIcon("images" + File.separator + "edit.png", 20, 20).getIcon();
		ImageIcon deleteIco = new ResizeIcon("images" + File.separator + "delete.png", 20, 20).getIcon();
		ImageIcon searchIco = new ResizeIcon("images" + File.separator + "search.png", 20, 20).getIcon();

		MouseListener mAdd = new AddBtnMouseListener();
		btnAdd = new JButton();
		btnAdd.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("addEntity")); 
		btnAdd.setIcon(addIco);
		btnAdd.addMouseListener(mAdd);
		add(btnAdd);
		
		MouseListener mEdit = new EditBtnMouseListener();
		btnEdit = new JButton();
		btnEdit.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("editEntity")); 
		btnEdit.setIcon(editIco);
		btnEdit.addMouseListener(mEdit);
		add(btnEdit);
		
		MouseListener mDelete = new DeleteBtnMouseListener();
		btnDelete = new JButton();
		btnDelete.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("delete")); 
		btnDelete.setIcon(deleteIco);
		btnDelete.addMouseListener(mDelete);
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		
		search = new JTextField(20); // had to limit the minimum size of textfield ...
		search.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search")); 
		search.setMaximumSize(new Dimension(200, 30)); // ... and the maximum size of textfield
		add(search);
		
		btnSearch = new JButton();
		btnSearch.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search")); 
		btnSearch.setIcon(searchIco);
		btnSearch.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					TableRowSorter<AbstractTableModelStudent> sorterStud = new TableRowSorter<AbstractTableModelStudent>(new AbstractTableModelStudent());
					if(!search.getText().isEmpty()) {
						RowFilter<Object, Object> filter = new RowFilter<Object, Object>(){

							@Override
							public boolean include(Entry entry) {
								String words[] = search.getText().split(",");
								if(words.length == 1) {
									String lastName = (String)entry.getValue(2);
									Pattern pattern = Pattern.compile(".*" + words[0].toLowerCase() + ".*");
									Matcher matcher1 = pattern.matcher(lastName.toLowerCase());
									return matcher1.matches();
								}
								else if(words.length == 2) {
									String lastName = (String)entry.getValue(2);
									String firstName = (String)entry.getValue(1);
									Pattern pattern1 = Pattern.compile(".*" + words[0].toLowerCase() + ".*");
									Pattern pattern2 = Pattern.compile(".*" + words[1].toLowerCase() + ".*");
									Matcher matcher1 = pattern1.matcher(lastName.toLowerCase());
									Matcher matcher2 = pattern2.matcher(firstName.toLowerCase());
									return matcher1.matches() && matcher2.matches();
								}
								else if(words.length == 3) {
									String lastName = (String)entry.getValue(2);
									String firstName = (String)entry.getValue(1);
									String index = (String)entry.getValue(0);
									Pattern pattern1 = Pattern.compile(".*" + words[0].toLowerCase() + ".*");
									Pattern pattern2 = Pattern.compile(".*" + words[1].toLowerCase() + ".*");
									Pattern pattern3 = Pattern.compile(".*" + words[2].toLowerCase() + ".*");
									Matcher matcher3 = pattern3.matcher(lastName.toLowerCase());
									Matcher matcher2 = pattern2.matcher(firstName.toLowerCase());
									Matcher matcher1 = pattern1.matcher(index.toLowerCase());
									return matcher1.matches() && matcher2.matches() && matcher3.matches();
								}
								else
									return false;
							}	
						};
						
					sorterStud.setRowFilter(filter);
					StudentTable.getInstance().setRowSorter(sorterStud);
					} else {
						sorterStud.setRowFilter(null);
						StudentTable.getInstance().setRowSorter(sorterStud);
					}
					break;
				case 1:	// PROFESSOR
					TableRowSorter<AbstractTableModelProfessor> sorterProf = new TableRowSorter<AbstractTableModelProfessor>(new AbstractTableModelProfessor());
					if(!search.getText().isEmpty()) {
						RowFilter<Object, Object> filter = new RowFilter<Object, Object>(){

							@Override
							public boolean include(Entry entry) {
								String firstName = (String)entry.getValue(0);
								String lastName = (String)entry.getValue(1);
								Pattern pattern = Pattern.compile(".*" + search.getText().toLowerCase() + ".*");
								Matcher matcher1 = pattern.matcher(firstName.toLowerCase() + " " + lastName.toLowerCase());
								Matcher matcher2 = pattern.matcher(lastName.toLowerCase() + " " + firstName.toLowerCase());
								return matcher1.matches() || matcher2.matches();
							}
							
						};
						
						sorterProf.setRowFilter(filter);
						ProfessorTable.getInstance().setRowSorter(sorterProf);
					} else {
						sorterProf.setRowFilter(null);
						ProfessorTable.getInstance().setRowSorter(sorterProf);
					}
					break;
				case 2:	// COURSE
					TableRowSorter<AbstractTableModelCourse> sorterCourse = new TableRowSorter<AbstractTableModelCourse>(new AbstractTableModelCourse());
					if(!search.getText().isEmpty()) {
						RowFilter<Object, Object> filter = new RowFilter<Object, Object>(){

							@Override
							public boolean include(Entry entry) {
								String id = String.valueOf((int)entry.getValue(0));
								String name = (String)entry.getValue(1);
								Pattern pattern = Pattern.compile(".*" + search.getText().toLowerCase() + ".*");
								Matcher matcher1 = pattern.matcher(id.toLowerCase() + " " + name.toLowerCase());
								Matcher matcher2 = pattern.matcher(name.toLowerCase() + " " + id.toLowerCase());
								return matcher1.matches() || matcher2.matches();
							}
							
						};
						sorterCourse.setRowFilter(filter);
						CourseTable.getInstance().setRowSorter(sorterCourse);
					} else {
						sorterCourse.setRowFilter(null);
						CourseTable.getInstance().setRowSorter(sorterCourse);
					}
					break;
				default:
					/* skip */
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		add(btnSearch);
		setFloatable(false);
	}
	
	public void changeLanguage() {
		btnAdd.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("addEntity"));
		btnEdit.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("editEntity"));
		btnDelete.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		search.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search"));
		btnSearch.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search"));
	}
		
		class AddBtnMouseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					new StudentAddDialog();
					break;
				case 1:	// PROFFESOR
					new ProfessorDialog(true);
					break;
				case 2:	// COURSE
					new CourseAddDialog();
					break;
				default:
					/* skip */
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
		class EditBtnMouseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
		class DeleteBtnMouseListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = {MainFrame.getInstance().getResourceBundle().getString("yes"), 
						MainFrame.getInstance().getResourceBundle().getString("no")};
				int answer;
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					int selectedIndex1 = StudentTable.getInstance().getSelectedRow();
					if(selectedIndex1 != -1) {
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
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
		
}
