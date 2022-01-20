package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.StudentEditDocumentListener;
import model.Address;
import model.Grade;
import model.Student;
import model.StudentDataBase;
import model.Student.Status;

public class StudentEditDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField lastName = new JTextField(20);
	public static JTextField firstName = new JTextField(20);
	public static JTextField dateOfBirth = new JTextField(20);
	public static JTextField addressStreet = new JTextField(20);
	public static JTextField addressNumber = new JTextField(5);
	public static JTextField addressCity = new JTextField(20);
	public static JTextField addressCountry = new JTextField(20);
	public static JTextField phoneNumber = new JTextField(20);
	public static JTextField email = new JTextField(20);
	public static JTextField indexNumber = new JTextField(10);
	public static JTextField yearOfEnrolment = new JTextField(3);
	public static JTextField currentYearOfStudies = new JTextField(3);
	public static JComboBox<Student.Status> status = new JComboBox<Student.Status>();
	public static JButton confirm;
	public static JButton cancel;
	
	public StudentEditDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("editStudent"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 500;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		int selectedIndex = StudentTable.getInstance().getSelectedRow();
		if(selectedIndex == -1) {
			dispose();
		}
		else if(selectedIndex >= 0) {
			Student selectedStud = StudentDataBase.getInstance().getStudent(selectedIndex);
			lastName.setText(selectedStud.getLastName());
			firstName.setText(selectedStud.getFirstName());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			dateOfBirth.setText(selectedStud.getDateOfBirth().format(formatter));
			addressStreet.setText(selectedStud.getAddress().getStreet());
			addressNumber.setText(selectedStud.getAddress().getNumber());
			addressCity.setText(selectedStud.getAddress().getCity());
			addressCountry.setText(selectedStud.getAddress().getCountry());
			phoneNumber.setText(selectedStud.getPhoneNumber());
			email.setText(selectedStud.getEmail());
			indexNumber.setText(selectedStud.getIndexNumber());
			yearOfEnrolment.setText(Integer.toString(selectedStud.getYearOfEnrolment()));
			currentYearOfStudies.setText(Integer.toString(selectedStud.getCurrentYearOfStudies()));
			status.getModel().setSelectedItem(selectedStud.getStatus());			
		}
		GridBagLayout gbl = new GridBagLayout();
		JPanel pInfo = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 0;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("lastName")), gb);
				
		gb.gridx = 1;
		gb.gridy = 0;
		lastName.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(lastName, gb);
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 1;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("firstName")), gb);
				
		gb.gridx = 1;
		gb.gridy = 1;
		firstName.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(firstName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("dateOfBirth")), gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		dateOfBirth.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA - ulica =====
		gb.gridx = 0;
		gb.gridy = 3;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("street")), gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		addressStreet.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(addressStreet, gb);
		
		// ===== KUCNA ADRESA - broj =====
		gb.gridx = 0;
		gb.gridy = 4;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("number")), gb);
		
		gb.gridx = 1;
		gb.gridy = 4;
		addressNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(addressNumber, gb);
		
		// ===== KUCNA ADRESA - grad =====
		gb.gridx = 0;
		gb.gridy = 5;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("city")), gb);
		
		gb.gridx = 1;
		gb.gridy = 5;
		addressCity.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(addressCity, gb);
		
		// ===== KUCNA ADRESA - drzava =====
		gb.gridx = 0;
		gb.gridy = 6;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("country")), gb);
		
		gb.gridx = 1;
		gb.gridy = 6;
		addressCountry.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(addressCountry, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 7;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("phoneNumber")), gb);
		
		gb.gridx = 1;
		gb.gridy = 7;
		phoneNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 8;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("email")), gb);
		
		gb.gridx = 1;
		gb.gridy = 8;
		email.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(email, gb);
		
		// ===== BROJ INDEXA =====
		gb.gridx = 0;
		gb.gridy = 9;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("indexNumber")), gb);
		
		gb.gridx = 1;
		gb.gridy = 9;
		indexNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(indexNumber, gb);
		
		// ===== GODINA UPISA =====
		gb.gridx = 0;
		gb.gridy = 10;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearOfEnrolment")), gb);
		
		gb.gridx = 1;
		gb.gridy = 10;
		yearOfEnrolment.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(yearOfEnrolment, gb);
		
		// ===== TRENUTNA GODINA STUDIJA =====
		gb.gridx = 0;
		gb.gridy = 11;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("currentYearOfStudies")), gb);
		
		gb.gridx = 1;
		gb.gridy = 11;
		currentYearOfStudies.getDocument().addDocumentListener(new StudentEditDocumentListener());
		pInfo.add(currentYearOfStudies, gb);
		
		// ===== STATUS =====
		gb.gridx = 0;
		gb.gridy = 12;
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("status")), gb);
		
		status.setModel(new DefaultComboBoxModel<>(Student.Status.values()));
		gb.gridx = 1;
		gb.gridy = 12;
		pInfo.add(status, gb);
		
		// DUGMAD
		gb.gridx = 0;
		gb.gridy = 13;
		confirm = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Student s = new Student();
				s.setFirstName(firstName.getText());
				s.setLastName(lastName.getText());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				s.setDateOfBirth(LocalDate.parse(dateOfBirth.getText(), formatter));
				s.setEmail(email.getText());
				Address hAddress = new Address(addressStreet.getText(), addressNumber.getText(), addressCity.getText(), addressCountry.getText());
				s.setAddress(hAddress);

				s.setPhoneNumber(phoneNumber.getText());
				s.setIndexNumber(indexNumber.getText());
				s.setStatus((Status)status.getSelectedItem());
				s.setYearOfEnrolment(Integer.parseInt(yearOfEnrolment.getText()));
				s.setCurrentYearOfStudies(Integer.parseInt(currentYearOfStudies.getText()));
				
				int selectedIndex = StudentTable.getInstance().getSelectedRow();
				Student selectedStud = StudentDataBase.getInstance().getStudent(selectedIndex);
				if(StudentDataBase.getInstance().existsById(s.getIndexNumber()) && !selectedStud.getIndexNumber().equals(s.getIndexNumber())) {
					JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("errStudentExists"));
				}else {
					StudentDataBase.getInstance().editStudent(StudentTable.getInstance().getSelectedRow(), s);
					StudentTable.getInstance().update();
					dispose();
				}
			}
		});
		
		pInfo.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 13;
		cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		pInfo.add(cancel, gb);
		
		JPanel pUnfinishedExams = new JPanel();
		pUnfinishedExams.add(new JScrollPane(UnfinishedExamsTable.getInstance()));
		JButton btnAddUnfinished = new JButton(MainFrame.getInstance().getResourceBundle().getString("add"));
		JButton btnDeleteUnfinished = new JButton(MainFrame.getInstance().getResourceBundle().getString("delete"));
		JButton btnFinishUnfinished = new JButton(MainFrame.getInstance().getResourceBundle().getString("pass")); // Polaganje
		
		
		Student selectedStud = StudentDataBase.getInstance().getStudent(selectedIndex);
		
		
		JPanel pPassedExams = new JPanel();
		//pPassedExams.setLayout(new BoxLayout(pPassedExams, BoxLayout.PAGE_AXIS));

		

		JButton btnCancelGrade = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancelGrade"));
		btnCancelGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {MainFrame.getInstance().getResourceBundle().getString("yes"), 
						MainFrame.getInstance().getResourceBundle().getString("no")};
				int selectedExamId = PassedExamsTable.getInstance().getSelectedRow();
				if(PassedExamsTable.getInstance().getSelectedRow() != -1) {
					int answer = JOptionPane.showOptionDialog(MainFrame.getInstance(), 
							MainFrame.getInstance().getResourceBundle().getString("cancelGradeQuestion"), 
									MainFrame.getInstance().getResourceBundle().getString("cancelGrade"), 
															JOptionPane.YES_NO_OPTION, 
															JOptionPane.QUESTION_MESSAGE, 
															null, 
															options, 
															options[0]);
					if(answer == JOptionPane.YES_OPTION){
						Student selectedStud = StudentDataBase.getInstance().getStudent(selectedIndex);
						List<Grade> passedGrades = selectedStud.getPassedExams();
						List<Grade> unfinishedGrades = selectedStud.getUnfinishedExams();
						Grade selectedGrade = passedGrades.get(selectedExamId);
						selectedGrade.setDateOfExam(null);
						selectedGrade.setGrade(5);
						unfinishedGrades.add(selectedGrade);
						passedGrades.remove(selectedExamId);
						selectedStud.setPassedExams(passedGrades);
						selectedStud.setUnfinishedExams(unfinishedGrades);
						PassedExamsTable.getInstance().update();
						UnfinishedExamsTable.getInstance().update();
					}
				}
				
			}
		});
		pPassedExams.add(btnCancelGrade);
		pPassedExams.add(new JScrollPane(PassedExamsTable.getInstance()));
		
		JPanel pPassedExamsInfo1 = new JPanel();
		//pPassedExamsInfo1.setLayout(new BoxLayout(pPassedExamsInfo1, BoxLayout.LINE_AXIS));
		JLabel lbAvgGradeTxt = new JLabel(MainFrame.getInstance().getResourceBundle().getString("avgGrade"));
		pPassedExamsInfo1.add(lbAvgGradeTxt);
		JLabel lbAvgGrade = new JLabel(Double.toString(selectedStud.calcAvgGrade()));
		pPassedExamsInfo1.add(lbAvgGrade);
		pPassedExams.add(pPassedExamsInfo1, BorderLayout.PAGE_END);
		
		pPassedExams.add(Box.createVerticalGlue());
		
		
		JPanel pPassedExamsInfo2 = new JPanel();
		//pPassedExamsInfo1.setLayout(new BoxLayout(pPassedExamsInfo2, BoxLayout.LINE_AXIS));
		JLabel lbTotalPointsTxt = new JLabel(MainFrame.getInstance().getResourceBundle().getString("totalESPB"));
		pPassedExamsInfo1.add(lbTotalPointsTxt);
		JLabel lbTotalPoints = new JLabel(Integer.toString(selectedStud.calcEcts()));
		pPassedExamsInfo1.add(lbTotalPoints);
		pPassedExams.add(pPassedExamsInfo2, BorderLayout.PAGE_END);
		
		
		
		
		
		btnFinishUnfinished.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(UnfinishedExamsTable.getInstance().getSelectedRow() != -1)
					new GradeEntryDialog();
				
			}
		});
		
		pUnfinishedExams.add(btnAddUnfinished);
		pUnfinishedExams.add(btnDeleteUnfinished);
		pUnfinishedExams.add(btnFinishUnfinished);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Info", pInfo);
		tabbedPane.addTab(MainFrame.getInstance().getResourceBundle().getString("passed"), pPassedExams);
		tabbedPane.addTab(MainFrame.getInstance().getResourceBundle().getString("unpassed"), pUnfinishedExams);
		
		add(tabbedPane);
		setResizable(true);
		setVisible(true);
		
		
	}

}
