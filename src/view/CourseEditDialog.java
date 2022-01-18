package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CourseEditDocumentListener;
import model.Course;
import model.CourseDataBase;
import model.Professor;
import model.ProfessorDataBase;
import model.Course.Semester;

public class CourseEditDialog extends JDialog  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public static JTextField courseId = new JTextField(20);
	public static JTextField courseName = new JTextField(20);
	public static JComboBox<Course.Semester> semester = new JComboBox<>();
	public static JTextField yearOfStudy = new JTextField(20);
	public static JTextField professorId = new JTextField(10);
	public static JTextField ectsPoints = new JTextField(5);
	public static JButton confirm;
	public static JButton cancel;
	
	public CourseEditDialog(){
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("editCourse"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		int selectedIndex = CourseTable.getInstance().getSelectedRow();
		if(selectedIndex == -1) {
			dispose();
		}
		else if(selectedIndex >= 0) {
			Course selectedCourse = CourseDataBase.getInstance().getCourse(selectedIndex);
			courseId.setText(Integer.toString(selectedCourse.getCourseID()));
			courseName.setText(selectedCourse.getCourseName());
			semester.getModel().setSelectedItem(selectedCourse.getSemester());
			yearOfStudy.setText(Integer.toString(selectedCourse.getYearOfStudy()));
			professorId.setText(selectedCourse.getCourseProffesor().getIdNumber());
			ectsPoints.setText(Integer.toString(selectedCourse.getEctsPoints()));
		}
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== ID PREDMETA =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("courseId")), gb);
				
		gb.gridx = 1;
		gb.gridy = 0;
		courseId.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(courseId, gb);
		
		// ===== IME PREDMETA =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("courseName")), gb);
				
		gb.gridx = 1;
		gb.gridy = 1;
		courseName.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(courseName, gb);
		
		// ===== SEMESTAR =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("semester")), gb);
		
		semester.setModel(new DefaultComboBoxModel<>(Course.Semester.values()));
		gb.gridx = 1;
		gb.gridy = 2;
		p.add(semester, gb);
		
		// ===== GODINA =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("year")), gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		yearOfStudy.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(yearOfStudy, gb);
		
		// ===== ID PROFESORA =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("professorId")), gb);

		gb.gridx = 1;
		gb.gridy = 4;
		professorId.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(professorId, gb);
		
		// ===== ESPB BODOVI =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("espb")), gb);
		
		gb.gridx = 1;
		gb.gridy = 5;
		ectsPoints.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(ectsPoints, gb);
	
		
		// DUGMAD
		gb.gridx = 0;
		gb.gridy = 6;
		confirm = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Course c = new Course();
					c.setCourseID(Integer.parseInt(courseId.getText()));
					c.setCourseName(courseName.getText());
					c.setSemester((Semester)semester.getSelectedItem());
					c.setYearOfStudy(Integer.parseInt(yearOfStudy.getText()));
					String profId = professorId.getText();
					Professor p = ProfessorDataBase.getInstance().getProfessorById(profId);
					c.setCourseProffesor(p);
					c.setEctsPoints(Integer.parseInt(ectsPoints.getText()));
					
					int selectedIndex = CourseTable.getInstance().getSelectedRow();
					Course selectedCourse = CourseDataBase.getInstance().getCourse(selectedIndex);
					if(CourseDataBase.getInstance().existsById(c.getCourseID()) && selectedCourse.getCourseID()!=c.getCourseID()) {
						JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("errCourseExists"));
					}
					else {
						CourseDataBase.getInstance().editCourse(CourseTable.getInstance().getSelectedRow(), c);
						CourseTable.getInstance().update();
						dispose();
					}
				}
				catch(Exception e)
				{
					//exception
				}
				
			}
		});
		
		p.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 6;
		cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		p.add(cancel, gb);
		
		add(p);
		setResizable(false);
		setVisible(true);
}
}
