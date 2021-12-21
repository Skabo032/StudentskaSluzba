package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import controller.ProfessorDocumentListener;
import model.Address;
import model.Professor;
import model.Professor.Title;
import model.ProfessorDataBase;

public class ProfessorDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField dateOfBirth;
	public static JTextField homeAddress;
	public static JTextField phoneNumber;
	public static JTextField email;
	public static JTextField officeAddress;
	public static JTextField idNumber;
	public static JComboBox<Professor.Title> title;
	public static JTextField yearsOfExperience;
	public static JButton confirm;
	public static JButton cancel;
	
	
	public ProfessorDialog(String dialogTitle) {
		super(MainFrame.getInstance(), dialogTitle, true); 
	
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 500;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);

		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel("Ime: "), gb);
		
		firstName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		firstName.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(firstName, gb);
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel("Prezime: "), gb);
		
		lastName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		lastName.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(lastName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel("Datum rodjenja: "), gb);
		
		dateOfBirth = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 2;
		dateOfBirth.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel("Kucna adresa: "), gb);
		
		homeAddress = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 3;
		homeAddress.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(homeAddress, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel("Broj telefona: "), gb);
		
		phoneNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 4;
		phoneNumber.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel("E-mail: "), gb);
		
		email = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 5;
		email.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(email, gb);
		
		// ===== ADRESA KANCELARIJE =====
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel("Adresa kancelarije: "), gb);
		
		officeAddress = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 6;
		officeAddress.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(officeAddress, gb);
		
		// ===== BROJ LICNE KARTE =====
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel("Broj licne karte: "), gb);
		
		idNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 7;
		idNumber.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(idNumber, gb);
		
		// ===== ZVANJE =====
		gb.gridx = 0;
		gb.gridy = 8;
		p.add(new JLabel("Zvanje: "), gb);
		
		title = new JComboBox<>();
		title.setModel(new DefaultComboBoxModel<>(Professor.Title.values()));
		gb.gridx = 1;
		gb.gridy = 8;
		p.add(title, gb);
		
		// ===== GODINE STAZA =====
		gb.gridx = 0;
		gb.gridy = 9;
		p.add(new JLabel("Godine staza: "), gb);
		
		yearsOfExperience = new JTextField(5);
		gb.gridx = 1;
		gb.gridy = 9;
		yearsOfExperience.getDocument().addDocumentListener(new ProfessorDocumentListener());
		p.add(yearsOfExperience, gb);
		
		// BUTTONS
		gb.gridx = 0;
		gb.gridy = 10;
		confirm = new JButton("Potvrdi");
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Professor p = new Professor();
				p.setFirstName(firstName.getText());
				p.setLastName(lastName.getText());
				p.setDateOfBirth(LocalDate.parse(dateOfBirth.getText()));
				p.setEmail(email.getText());
				String[] hAddrArr = homeAddress.getText().split(",");
				Address hAddress = new Address(hAddrArr[0], Integer.parseInt(hAddrArr[1]), hAddrArr[2], hAddrArr[3]);
				p.setHomeAddress(hAddress);
				String[] oAddrArr = homeAddress.getText().split(",");
				Address oAddress = new Address(oAddrArr[0], Integer.parseInt(oAddrArr[1]), oAddrArr[2], oAddrArr[3]);
				p.setHomeAddress(oAddress);
				p.setPhoneNumber(phoneNumber.getText());
				p.setIdNumber(idNumber.getText());
				p.setTitle((Title)title.getSelectedItem());
				try {
					p.setYearsOfExperience(Integer.parseInt(yearsOfExperience.getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(ProfessorDataBase.getInstance().addProfessor(p)) {
					ProfessorTable.getInstance().update();
					dispose();
				}
			}
		});
		p.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 10;
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
