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
	public static JTextField ectsPoints = new JTextField(5);
	public static JTextField courseProf = new JTextField(15);
	public static JButton confirm;
	public static JButton cancel;
	
	public CourseEditDialog(){
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("editCourse"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 500;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		int selectedIndex = CourseTable.getInstance().getSelectedRow();
		if(selectedIndex == -1) {
			dispose();
		}
		else if(selectedIndex >= 0) {
			Course selectedCourse = CourseDataBase.getInstance().getCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex));
			courseId.setText(selectedCourse.getCourseID());
			courseName.setText(selectedCourse.getCourseName());
			semester.getModel().setSelectedItem(selectedCourse.getSemester());
			yearOfStudy.setText(Integer.toString(selectedCourse.getYearOfStudy()));
			ectsPoints.setText(Integer.toString(selectedCourse.getEctsPoints()));
			courseProf.setText(selectedCourse.getCourseProffesor() == null ? " " : selectedCourse.getCourseProffesor().getFirstLastName());
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
		/*gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("professorId")), gb);

		gb.gridx = 1;
		gb.gridy = 4;
		professorId.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(professorId, gb);*/
		
		// ===== ESPB BODOVI =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("espb")), gb);
		
		gb.gridx = 1;
		gb.gridy = 5;
		ectsPoints.getDocument().addDocumentListener(new CourseEditDocumentListener());
		p.add(ectsPoints, gb);
	
		//courseProf = new JTextField(15);
		courseProf.setEditable(false);
		
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(courseProf, gb);
		
		JButton addProf = new JButton("+");
		addProf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ChooseProfessor();
				
			}
		});
		gb.gridx = 1;
		gb.gridy = 6;
		p.add(addProf, gb);
		JButton removeProf = new JButton("-");
		removeProf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Course selectedCourse = CourseDataBase.getInstance().getCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex));
				//selectedCourse.getCourseProffesor().getCourses().remove(selectedCourse);
				ProfessorDataBase.getInstance().getProfessorById(selectedCourse.getCourseProffesor().getIdNumber()).getCourses().remove(selectedCourse);
				selectedCourse.setCourseProffesor(null);
				CourseDataBase.getInstance().editCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex), selectedCourse);
				ProfessorTable.getInstance().update();
				courseProf.setText("");
			}
		});
		gb.gridx = 2;
		gb.gridy = 6;
		p.add(removeProf, gb);
		
		
		// DUGMAD
		gb.gridx = 0;
		gb.gridy = 7;
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
					c.setEctsPoints(Integer.parseInt(ectsPoints.getText()));
					
					Course selectedCourse = CourseDataBase.getInstance().getCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex));
					if(CourseDataBase.getInstance().existsById(c.getCourseID()) && !selectedCourse.getCourseID().equals(c.getCourseID())) {
						JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("errCourseExists"));
					}
					else {
						CourseDataBase.getInstance().editCourse(CourseTable.getInstance().convertRowIndexToModel(selectedIndex), c);
						CourseTable.getInstance().update();
						StudentTable.getInstance().update();
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
		gb.gridy = 7;
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
