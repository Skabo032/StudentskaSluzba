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

import controller.ProfessorAddDocumentListener;
import controller.ProfessorEditDocumentListener;
import model.Address;
import model.Professor;
import model.ProfessorDataBase;
import model.Professor.Title;

public class ProfessorEditDialog extends JDialog{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static JTextField firstName = new JTextField(20);
	public static JTextField lastName = new JTextField(20);
	public static JTextField dateOfBirth = new JTextField(20);
	public static JTextField homeAddress = new JTextField(20);
	public static JTextField phoneNumber = new JTextField(20);
	public static JTextField email = new JTextField(20);
	public static JTextField officeAddress = new JTextField(20);
	public static JTextField idNumber = new JTextField(20);
	public static JComboBox<Professor.Title> title = new JComboBox<Professor.Title>();
	public static JTextField yearsOfExperience = new JTextField(5);
	public static JButton confirm;
	public static JButton cancel;
	
	public ProfessorEditDialog() {
		super(MainFrame.getInstance(), "Izmeni profesora", true); 
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 500;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		int selectedIndex = ProfessorTable.getInstance().getSelectedRow();
		if(selectedIndex == -1) {
			dispose();
		}else if(selectedIndex >= 0) {
			Professor selectedProf = ProfessorDataBase.getInstance().getProfessor(selectedIndex);
			firstName.setText(selectedProf.getFirstName());
			lastName.setText(selectedProf.getLastName());
			dateOfBirth.setText(selectedProf.getDateOfBirth().toString());
			homeAddress.setText(selectedProf.getHomeAddress().toString());
			phoneNumber.setText(selectedProf.getPhoneNumber());
			email.setText(selectedProf.getEmail());
			officeAddress.setText(selectedProf.getOfficeAddress().toString());
			idNumber.setText(selectedProf.getIdNumber());
			title.getModel().setSelectedItem(selectedProf.getTitle());
			yearsOfExperience.setText(Integer.toString(selectedProf.getYearsOfExperience()));
		}
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		ProfessorEditDocumentListener pdl = new ProfessorEditDocumentListener();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel("Ime: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 0;
		firstName.getDocument().addDocumentListener(pdl);
		p.add(firstName, gb);
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel("Prezime: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 1;
		lastName.getDocument().addDocumentListener(pdl);
		p.add(lastName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel("Datum rodjenja: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		dateOfBirth.getDocument().addDocumentListener(pdl);
		p.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel("Kucna adresa: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		homeAddress.getDocument().addDocumentListener(pdl);
		p.add(homeAddress, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel("Broj telefona: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 4;
		phoneNumber.getDocument().addDocumentListener(pdl);
		p.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel("E-mail: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 5;
		email.getDocument().addDocumentListener(pdl);
		p.add(email, gb);
		
		// ===== ADRESA KANCELARIJE =====
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel("Adresa kancelarije: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 6;
		officeAddress.getDocument().addDocumentListener(pdl);
		p.add(officeAddress, gb);
		
		// ===== BROJ LICNE KARTE =====
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel("Broj licne karte: "), gb);
		
		gb.gridx = 1;
		gb.gridy = 7;
		idNumber.getDocument().addDocumentListener(pdl);
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
		
		gb.gridx = 1;
		gb.gridy = 9;
		yearsOfExperience.getDocument().addDocumentListener(pdl);
		p.add(yearsOfExperience, gb);
		
		// BUTTONS
		gb.gridx = 0;
		gb.gridy = 10;
		confirm = new JButton("Potvrdi");
		confirm.setEnabled(true);	// retrived data from the database SHOULD be correct
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
				String[] oAddrArr = officeAddress.getText().split(",");
				Address oAddress = new Address(oAddrArr[0], Integer.parseInt(oAddrArr[1]), oAddrArr[2], oAddrArr[3]);
				p.setOfficeAddress(oAddress);
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
				
				if(ProfessorDataBase.getInstance().editProfessor(p)) {
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
