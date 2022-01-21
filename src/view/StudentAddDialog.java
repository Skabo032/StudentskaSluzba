package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentAddDocumentListener;
import model.Address;
import model.Student;
import model.Student.Status;
import model.StudentDataBase;


public class StudentAddDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField lastName;
	public static JTextField firstName;
	public static JTextField dateOfBirth;
	public static JTextField addressStreet;
	public static JTextField addressNumber;
	public static JTextField addressCity;
	public static JTextField addressCountry;
	public static JTextField phoneNumber;
	public static JTextField email;
	public static JTextField indexNumber;
	public static JTextField yearOfEnrolment;
	public static JTextField currentYearOfStudies;
	public static JComboBox<Student.Status> status;
	public static JButton confirm;
	public static JButton cancel;
	
	public StudentAddDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("addStudent"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 500;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("lastName")), gb);
				
		lastName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		lastName.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(lastName, gb);
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("firstName")), gb);
				
		firstName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		firstName.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(firstName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("dateOfBirth")), gb);
		
		dateOfBirth = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 2;
		dateOfBirth.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA - ulica =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("street")), gb);
		
		addressStreet = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 3;
		addressStreet.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(addressStreet, gb);
		
		// ===== KUCNA ADRESA - broj =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("number")), gb);
		
		addressNumber = new JTextField(4);
		gb.gridx = 1;
		gb.gridy = 4;
		addressNumber.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(addressNumber, gb);
		
		// ===== KUCNA ADRESA - grad =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("city")), gb);
		
		addressCity = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 5;
		addressCity.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(addressCity, gb);
		
		// ===== KUCNA ADRESA - drzava =====
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("country")), gb);
		
		addressCountry = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 6;
		addressCountry.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(addressCountry, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("phoneNumber")), gb);
		
		phoneNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 7;
		phoneNumber.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 8;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("email")), gb);
		
		email = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 8;
		email.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(email, gb);
		
		// ===== BROJ INDEXA =====
		gb.gridx = 0;
		gb.gridy = 9;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("indexNumber")), gb);
		
		indexNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 9;
		indexNumber.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(indexNumber, gb);
		
		// ===== GODINA UPISA =====
		gb.gridx = 0;
		gb.gridy = 10;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearOfEnrolment")), gb);
		
		yearOfEnrolment = new JTextField(10);
		gb.gridx = 1;
		gb.gridy = 10;
		yearOfEnrolment.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(yearOfEnrolment, gb);
		
		// ===== TRENUTNA GODINA STUDIJA =====
		gb.gridx = 0;
		gb.gridy = 11;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("currentYearOfStudies")), gb);
		
		currentYearOfStudies = new JTextField(5);
		gb.gridx = 1;
		gb.gridy = 11;
		currentYearOfStudies.getDocument().addDocumentListener(new StudentAddDocumentListener());
		p.add(currentYearOfStudies, gb);
		
		// ===== STATUS =====
		gb.gridx = 0;
		gb.gridy = 12;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("status")), gb);
		
		status = new JComboBox<>();
		status.setModel(new DefaultComboBoxModel<>(Student.Status.values()));
		gb.gridx = 1;
		gb.gridy = 12;
		p.add(status, gb);
		
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
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				s.setDateOfBirth(LocalDate.parse(dateOfBirth.getText(), formatter));
				s.setEmail(email.getText());
				Address hAddress = new Address(addressStreet.getText(), addressNumber.getText(), addressCity.getText(), addressCountry.getText());
				s.setAddress(hAddress);

				s.setPhoneNumber(phoneNumber.getText());
				s.setIndexNumber(indexNumber.getText());
				s.setStatus((Status)status.getSelectedItem());
				s.setYearOfEnrolment(Integer.parseInt(yearOfEnrolment.getText()));
				s.setCurrentYearOfStudies(Integer.parseInt(currentYearOfStudies.getText()));
				
				if(StudentDataBase.getInstance().addStudent(s)) {
					StudentTable.getInstance().update();
					dispose();
				}else {
					JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("errStudentExists"));
				}
			}
		});
		
		p.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 13;
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
