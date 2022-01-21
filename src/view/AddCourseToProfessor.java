package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Course;
import model.CourseDataBase;
import model.Professor;
import model.ProfessorDataBase;

public class AddCourseToProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddCourseToProfessor() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("addCourse"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 500;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel addCourse = new JPanel(new BorderLayout());
		JPanel dugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		int selectedIndex = ProfessorTable.getInstance().getSelectedRow();
		Professor selectedProf = ProfessorDataBase.getInstance().getProfessor(ProfessorTable.getInstance().convertRowIndexToModel(selectedIndex));
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i < CourseDataBase.getInstance().getRowCount(); i++) {
			
			if(!selectedProf.getCourses().contains(CourseDataBase.getInstance().getCourse(i)) )
			{
				Course courseToAdd = CourseDataBase.getInstance().getCourse(i);
				listModel.addElement(courseToAdd.getCourseName());
			}
		}
		JList<String> courseList = new JList<String>(listModel);
		JScrollPane courseList2 = new JScrollPane(courseList);
		//courseList.setSize(290, 150);
		addCourse.add(courseList2, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton(MainFrame.getInstance().getResourceBundle().getString("add"));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedCourseIndex = courseList.getSelectedIndex();
				if(selectedCourseIndex != -1) {
					Course selectedCourse = CourseDataBase.getInstance().getCourseByName(courseList.getSelectedValue());
					selectedProf.addCourse(selectedCourse);
					selectedCourse.setCourseProffesor(selectedProf);
					ProfessorTeachingTable.getInstance().update();
					dispose();
				}
			}
		});
		JButton btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		dugmad.add(btnAdd);
		dugmad.add(btnCancel);
		
		addCourse.add(dugmad, BorderLayout.SOUTH);
		
		add(addCourse);
		setVisible(true);
		
	}

}
