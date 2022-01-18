package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import model.CourseDataBase;
import model.ProfessorDataBase;
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
		ImageIcon addIco = new ResizeIcon("images/add.png", 20, 20).getIcon();
		ImageIcon editIco = new ResizeIcon("images/edit.png", 20, 20).getIcon();
		ImageIcon deleteIco = new ResizeIcon("images/delete.png", 20, 20).getIcon();
		ImageIcon searchIco = new ResizeIcon("images/search.png", 20, 20).getIcon();

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
					if(StudentTable.getInstance().getSelectedRow() != -1) {
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteStudentQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteStudent"), 
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
					if(ProfessorTable.getInstance().getSelectedRow() != -1)
					{
						answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteProfessorQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteProfessor"), 
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
								MainFrame.getInstance().getResourceBundle().getString("deleteCourseQuestion"), 
								MainFrame.getInstance().getResourceBundle().getString("deleteCourse"), 
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
