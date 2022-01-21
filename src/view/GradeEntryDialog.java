package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Grade;
import model.Student;
import model.StudentDataBase;

public class GradeEntryDialog extends JDialog{
	
	public GradeEntryDialog() {
		
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("enterGrade"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 300;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JTextField id = new JTextField(10);
		JTextField name = new JTextField(20);
		JTextField date = new JTextField(15);
		JButton confirm = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		JButton cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		
		int selectedStudIdx = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(StudentTable.getInstance().convertRowIndexToModel(selectedStudIdx));
		List<Grade> grades = selectedStudent.getUnfinishedExams();
		int selectedGradeIdx = UnfinishedExamsTable.getInstance().getSelectedRow();
		id.setText(String.valueOf(grades.get(selectedGradeIdx).getCourse().getCourseID()));
		name.setText(grades.get(selectedGradeIdx).getCourse().getCourseName());
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("courseId")), setCooridnates(gb, 0, 0));
		
		id.setEnabled(false);
		p.add(id, setCooridnates(gb, 1, 0));
		
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("name")), setCooridnates(gb, 0, 1));
		
		name.setEnabled(false);
		p.add(name, setCooridnates(gb, 1, 1));
		
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("grade")), setCooridnates(gb, 0, 2));
		JComboBox<Integer> gradeValue = new JComboBox<Integer>(new Integer[] {6,7,8,9,10});
		p.add(gradeValue, setCooridnates(gb, 1, 2));
		
		
		confirm.setEnabled(false);
		
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("date")), setCooridnates(gb, 0, 3));
		
		date.getDocument().addDocumentListener(new DocumentListener() {
			
			public void verify() {
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
					LocalDate localDate = LocalDate.parse(date.getText(), formatter);
					confirm.setEnabled(true);
					
				} catch (DateTimeParseException e) {
					confirm.setEnabled(false);
				}
			}
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				verify();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				verify();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				verify();
			}
		});
		p.add(date, setCooridnates(gb, 1, 3));
		
		// declaration moved up so that it can be used in document listener
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				LocalDate dateOfExam = LocalDate.parse(date.getText(), formatter);
				
				Grade grade = grades.get(selectedGradeIdx);
				grade.setDateOfExam(dateOfExam);
				grade.setGrade((int)gradeValue.getSelectedItem());
				
				List<Grade> passedGrades = selectedStudent.getPassedExams();
				passedGrades.add(grade);
				
				List<Grade> unfinishedGrades = selectedStudent.getUnfinishedExams();
				unfinishedGrades.remove(selectedGradeIdx);
				
				selectedStudent.setPassedExams(passedGrades);
				selectedStudent.setUnfinishedExams(unfinishedGrades);
				StudentDataBase.getInstance().editStudent(StudentTable.getInstance().convertRowIndexToModel(selectedStudIdx), selectedStudent);
				UnfinishedExamsTable.getInstance().update();
				PassedExamsTable.getInstance().update(); //da refreshuje polozene odmah
				dispose();
			}
		});
		p.add(confirm, setCooridnates(gb, 0, 4));
		
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		p.add(cancel, setCooridnates(gb, 1, 4));
		
		
		add(p);
		setVisible(true);
	}
	
	public GridBagConstraints setCooridnates(GridBagConstraints gb, int x, int y) {
		gb.gridx = x;
		gb.gridy = y;
		return gb;
	}
}
