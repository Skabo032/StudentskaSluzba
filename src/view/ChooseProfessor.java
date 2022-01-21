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
import model.ProfessorDataBase;

public class ChooseProfessor extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseProfessor(){
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("chooseProfessor"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 300;
		int sizeY = 400;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel list = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i < ProfessorDataBase.getInstance().getRowCount(); i++) {
			listModel.addElement(ProfessorDataBase.getInstance().getProfessor(i).getFirstLastName());
		}
		JList<String> profList = new JList<String>(listModel);
		
		profList.setSize(290, 150);
		list.add(new JScrollPane(profList));
		
		JButton confirm = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedProfIndex = profList.getSelectedIndex();
				if(selectedProfIndex != -1) {
					
					int selectedCourseIndex = CourseTable.getInstance().getSelectedRow();
					Course selectedCourse = CourseDataBase.getInstance().getCourse(selectedCourseIndex);
					selectedCourse.setCourseProffesor(ProfessorDataBase.getInstance().getProfessor(selectedProfIndex));
					CourseDataBase.getInstance().editCourse(selectedCourseIndex, selectedCourse);
					CourseEditDialog.courseProf.setText(ProfessorDataBase.getInstance().getProfessor(selectedProfIndex).getFirstLastName());
					ProfessorDataBase.getInstance().getProfessor(selectedProfIndex).getCourses().add(selectedCourse);
					dispose();
				}
			}
		});
		JButton cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		buttons.add(confirm);
		buttons.add(cancel);
		
		list.add(buttons, BorderLayout.SOUTH);
		
		add(list);
		setVisible(true);
	}
}
