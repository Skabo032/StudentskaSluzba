package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentEditDocumentListener;
import model.Address;
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
		super(MainFrame.getInstance(), "Izmeni studenta", true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
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
			dateOfBirth.setText(selectedStud.getDateOfBirth().toString());
			addressStreet.setText(selectedStud.getAddress().getStreet());
			addressNumber.setText(Integer.toString(selectedStud.getAddress().getNumber()));
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
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel("Prezime: "), gb);
				
		gb.gridx = 1;
		gb.gridy = 0;
		lastName.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(lastName, gb);
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel("Ime: "), gb);
				
		gb.gridx = 1;
		gb.gridy = 1;
		firstName.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(firstName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel("Datum rodjenja: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		dateOfBirth.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA - ulica =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel("Ulica: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		addressStreet.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(addressStreet, gb);
		
		// ===== KUCNA ADRESA - broj =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel("Broj: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 4;
		addressNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(addressNumber, gb);
		
		// ===== KUCNA ADRESA - grad =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel("Grad: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 5;
		addressCity.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(addressCity, gb);
		
		// ===== KUCNA ADRESA - drzava =====
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel("Drzava: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 6;
		addressCountry.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(addressCountry, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel("Broj telefona: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 7;
		phoneNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 8;
		p.add(new JLabel("E-mail: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 8;
		email.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(email, gb);
		
		// ===== BROJ INDEXA =====
		gb.gridx = 0;
		gb.gridy = 9;
		p.add(new JLabel("Broj indexa: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 9;
		indexNumber.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(indexNumber, gb);
		
		// ===== GODINA UPISA =====
		gb.gridx = 0;
		gb.gridy = 10;
		p.add(new JLabel("Godina upisa: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 10;
		yearOfEnrolment.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(yearOfEnrolment, gb);
		
		// ===== TRENUTNA GODINA STUDIJA =====
		gb.gridx = 0;
		gb.gridy = 11;
		p.add(new JLabel("Trenutna godina studija: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 11;
		currentYearOfStudies.getDocument().addDocumentListener(new StudentEditDocumentListener());
		p.add(currentYearOfStudies, gb);
		
		// ===== STATUS =====
		gb.gridx = 0;
		gb.gridy = 12;
		p.add(new JLabel("Status: "), gb);
		
		status.setModel(new DefaultComboBoxModel<>(Student.Status.values()));
		gb.gridx = 1;
		gb.gridy = 12;
		p.add(status, gb);
		
		// DUGMAD
		gb.gridx = 0;
		gb.gridy = 13;
		confirm = new JButton("Potvrdi");
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Student s = new Student();
				s.setFirstName(firstName.getText());
				s.setLastName(lastName.getText());
				s.setDateOfBirth(LocalDate.parse(dateOfBirth.getText()));
				s.setEmail(email.getText());
				Address hAddress = new Address(addressStreet.getText(), Integer.parseInt(addressNumber.getText()), addressCity.getText(), addressCountry.getText());
				s.setAddress(hAddress);

				s.setPhoneNumber(phoneNumber.getText());
				s.setIndexNumber(indexNumber.getText());
				s.setStatus((Status)status.getSelectedItem());
				s.setYearOfEnrolment(Integer.parseInt(yearOfEnrolment.getText()));
				s.setCurrentYearOfStudies(Integer.parseInt(currentYearOfStudies.getText()));
				
				System.out.println(StudentDataBase.getInstance().editStudent(s));
				StudentTable.getInstance().update();
				dispose();
			}
		});
		
		p.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 13;
		cancel = new JButton("Otkaži");
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
