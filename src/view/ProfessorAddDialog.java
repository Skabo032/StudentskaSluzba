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

import controller.ProfessorAddDocumentListener;
import model.Address;
import model.Professor;
import model.Professor.Title;
import model.ProfessorDataBase;
public class ProfessorAddDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField dateOfBirth;
	public static JTextField homeStreet = new JTextField(20);
	public static JTextField homeNumber = new JTextField(5);
	public static JTextField homeCity = new JTextField(20);
	public static JTextField homeCountry = new JTextField(20);
	public static JTextField phoneNumber;
	public static JTextField email;
	public static JTextField officeStreet = new JTextField(20);
	public static JTextField officeNumber = new JTextField(5);
	public static JTextField officeCity = new JTextField(20);
	public static JTextField officeCountry = new JTextField(20);
	public static JTextField idNumber;
	public static JComboBox<Professor.Title> title;
	public static JTextField yearsOfExperience;
	public static JButton confirm;
	public static JButton cancel;
	
	
	public ProfessorAddDialog() {
		super(MainFrame.getInstance(), "Dodaj profesora", true); 
	
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 500;
		int sizeY = 700;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== IME =====
		p.add(new JLabel("Ime: "), setCooridnates(gb, 0, 0));
		
		firstName = new JTextField(20);
		firstName.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(firstName, setCooridnates(gb, 1, 0));
		
		// ===== PREZIME =====
		p.add(new JLabel("Prezime: "), setCooridnates(gb, 0, 1));
		
		lastName = new JTextField(20);
		lastName.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(lastName, setCooridnates(gb, 1, 1));
		
		// ===== DATUM RODJENJA =====
		p.add(new JLabel("Datum rodjenja: "), setCooridnates(gb, 0, 2));
		p.add(new JLabel("dd.mm.yyyy "), setCooridnates(gb, 2, 2));
		
		dateOfBirth = new JTextField(20);
		dateOfBirth.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(dateOfBirth, setCooridnates(gb, 1, 2));
		
		// ===== KUCNA ADRESA =====
		p.add(new JLabel("KUCNA ADRESA: "), setCooridnates(gb, 0, 3));
		
		p.add(new JLabel("Ulica: "), setCooridnates(gb, 0, 4));
		p.add(homeStreet, setCooridnates(gb, 1, 4));
		p.add(new JLabel("Broj: "), setCooridnates(gb, 0, 5));
		p.add(homeNumber, setCooridnates(gb, 1, 5));
		p.add(new JLabel("Grad: "), setCooridnates(gb, 0, 6));
		p.add(homeCity, setCooridnates(gb, 1, 6));
		p.add(new JLabel("Drzava: "), setCooridnates(gb, 0, 7));
		p.add(homeCountry, setCooridnates(gb, 1, 7));
		homeStreet.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		homeNumber.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		homeCity.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		homeCountry.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		
		// ===== ADRESA KANCELARIJE =====
		p.add(new JLabel("ADRESA KANCELARIJE: "), setCooridnates(gb, 0, 8));
		
		p.add(new JLabel("Ulica: "), setCooridnates(gb, 0, 9));
		p.add(officeStreet, setCooridnates(gb, 1, 9));
		p.add(new JLabel("Broj: "), setCooridnates(gb, 0, 10));
		p.add(officeNumber, setCooridnates(gb, 1, 10));
		p.add(new JLabel("Grad: "), setCooridnates(gb, 0, 11));
		p.add(officeCity, setCooridnates(gb, 1, 11));
		p.add(new JLabel("Drzava: "), setCooridnates(gb, 0, 12));
		p.add(officeCountry, setCooridnates(gb, 1, 12));
		officeStreet.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		officeNumber.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		officeCity.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		officeCountry.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		
		// ===== BROJ TELEFONA =====
		p.add(new JLabel("Broj telefona: "), setCooridnates(gb, 0, 13));
		
		phoneNumber = new JTextField(20);
		phoneNumber.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(phoneNumber, setCooridnates(gb, 1, 13));
		
		// ==== EMAIL =====
		p.add(new JLabel("E-mail: "), setCooridnates(gb, 0, 14));
		
		email = new JTextField(20);
		email.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(email, setCooridnates(gb, 1, 14));
		
		// ===== BROJ LICNE KARTE =====
		p.add(new JLabel("Broj licne karte: "), setCooridnates(gb, 0, 15));
		
		idNumber = new JTextField(20);
		idNumber.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(idNumber, setCooridnates(gb, 1, 15));
		
		// ===== ZVANJE =====
		p.add(new JLabel("Zvanje: "), setCooridnates(gb, 0, 16));
		
		title = new JComboBox<>();
		title.setModel(new DefaultComboBoxModel<>(Professor.Title.values()));
		p.add(title, setCooridnates(gb, 1, 16));
		
		// ===== GODINE STAZA =====
		p.add(new JLabel("Godine staza: "), setCooridnates(gb, 0, 17));
		
		yearsOfExperience = new JTextField(5);
		yearsOfExperience.getDocument().addDocumentListener(new ProfessorAddDocumentListener());
		p.add(yearsOfExperience, setCooridnates(gb, 1, 17));
		
		// BUTTONS
		confirm = new JButton("Potvrdi");
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Professor p = new Professor();
				p.setFirstName(firstName.getText());
				p.setLastName(lastName.getText());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				p.setDateOfBirth(LocalDate.parse(dateOfBirth.getText(), formatter));
				p.setEmail(email.getText());
				Address homeAddress = new Address(homeStreet.getText(), 
						Integer.parseInt(homeNumber.getText()),//TODO: change street number to string
						homeCity.getText(),
						homeCountry.getText());
				p.setHomeAddress(homeAddress);
				Address officeAddress = new Address(officeStreet.getText(), 
						Integer.parseInt(officeNumber.getText()),	//TODO: change street number to string
						officeCity.getText(),
						officeCountry.getText());
				p.setOfficeAddress(officeAddress);
				p.setPhoneNumber(phoneNumber.getText());
				p.setIdNumber(idNumber.getText());
				p.setTitle((Title)title.getSelectedItem());
				// had to add try catch but the value has already been validated
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
				}else {
					JOptionPane.showMessageDialog(getParent(), "Profesor sa datim brojem LK vec postoji!");
				}
			}
		});
		p.add(confirm, setCooridnates(gb, 0, 18));
		
		cancel = new JButton("Otkaži");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		p.add(cancel, setCooridnates(gb, 1, 18));
		
		add(p);
		setResizable(false);
		setVisible(true);
	}
	
	public GridBagConstraints setCooridnates(GridBagConstraints gb, int x, int y) {
		gb.gridx = x;
		gb.gridy = y;
		return gb;
	}
	
}
