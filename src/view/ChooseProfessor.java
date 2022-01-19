package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import model.Course;
import model.CourseDataBase;
import model.Professor;
import model.ProfessorDataBase;

public class ChooseProfessor extends JDialog{
	
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
		
		JPanel p = new JPanel();
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i < ProfessorDataBase.getInstance().getRowCount(); i++) {
			listModel.addElement(ProfessorDataBase.getInstance().getProfessor(i).getFirstLastName());
		}
		JList profList = new JList<String>(listModel);
		profList.setSize(290, 150);
		p.add(profList);
		
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
		p.add(Box.createVerticalGlue());
		p.add(confirm);
		p.add(Box.createVerticalGlue());
		p.add(cancel);
		
		add(p);
		setVisible(true);
	}
}
