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

import controller.CourseAddDocumentListener;
import model.Course;
import model.Course.Semester;
import model.CourseDataBase;
import model.Professor;
import model.ProfessorDataBase;

public class CourseAddDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField courseId;
	public static JTextField courseName;
	public static JComboBox<Course.Semester> semester;
	public static JTextField yearOfStudy;
	public static JTextField professorId;
	public static JTextField ectsPoints;
	public static JButton confirm;
	public static JButton cancel;
	
	public CourseAddDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("addCourse"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== ID PREDMETA =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("courseId")), gb);
				
		courseId = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		courseId.getDocument().addDocumentListener(new CourseAddDocumentListener());
		p.add(courseId, gb);
		
		// ===== IME PREDMETA =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("courseName")), gb);
				
		courseName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		courseName.getDocument().addDocumentListener(new CourseAddDocumentListener());
		p.add(courseName, gb);
		
		// ===== SEMESTAR =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("semester")), gb);
		
		semester = new JComboBox<>();
		semester.setModel(new DefaultComboBoxModel<>(Course.Semester.values()));
		gb.gridx = 1;
		gb.gridy = 2;
		p.add(semester, gb);
		
		// ===== GODINA =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("year")), gb);
		
		yearOfStudy = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 3;
		yearOfStudy.getDocument().addDocumentListener(new CourseAddDocumentListener());
		p.add(yearOfStudy, gb);
		
		// ===== ID PROFESORA =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("professorId")), gb);
		
		professorId = new JTextField(10);
		gb.gridx = 1;
		gb.gridy = 4;
		professorId.getDocument().addDocumentListener(new CourseAddDocumentListener());
		p.add(professorId, gb);
		
		// ===== ESPB BODOVI =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("espb")), gb);
		
		ectsPoints = new JTextField(5);
		gb.gridx = 1;
		gb.gridy = 5;
		ectsPoints.getDocument().addDocumentListener(new CourseAddDocumentListener());
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
					c.setCourseID(courseId.getText());
					c.setCourseName(courseName.getText());
					c.setSemester((Semester)semester.getSelectedItem());
					c.setYearOfStudy(Integer.parseInt(yearOfStudy.getText()));
					int profId = Integer.parseInt(professorId.getText());
					Professor p = ProfessorDataBase.getInstance().getProfessor(profId);
					c.setCourseProffesor(p);
					c.setEctsPoints(Integer.parseInt(ectsPoints.getText()));
					
					
					if(CourseDataBase.getInstance().existsById(c.getCourseID())) {
						JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("errCourseExists"));
					}
					else {
						CourseDataBase.getInstance().addCourse(c);
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
