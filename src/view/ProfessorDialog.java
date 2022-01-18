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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ProfessorController;
import controller.ProfessorDocumentListener;
import model.Address;
import model.Professor;
import model.ProfessorDataBase;
import model.Professor.Title;

public class ProfessorDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField dateOfBirth;
	public static JTextField homeStreet;
	public static JTextField homeNumber;
	public static JTextField homeCity;
	public static JTextField homeCountry;
	public static JTextField phoneNumber;
	public static JTextField email;
	public static JTextField officeStreet;
	public static JTextField officeNumber;
	public static JTextField officeCity;
	public static JTextField officeCountry;
	public static JTextField idNumber;
	public static JComboBox<Professor.Title> title;
	public static JTextField yearsOfExperience;
	public static JButton confirm;
	public static JButton cancel;
	
	public ProfessorDialog(boolean isAdd) {
		super(MainFrame.getInstance(), isAdd ? 
				MainFrame.getInstance().getResourceBundle().getString("addProfessor") : 
					MainFrame.getInstance().getResourceBundle().getString("editProfessor"), true);
		
		int sizeX = 500;
		int sizeY = 700;
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// constructors for fields need to be called in class constructor because otherwise 
		// text stays in the fields even if the dialog is closed
		firstName = new JTextField(20);
		lastName = new JTextField(20);
		dateOfBirth = new JTextField(20);
		homeStreet = new JTextField(20);
		homeNumber = new JTextField(5);
		homeCity = new JTextField(20);
		homeCountry = new JTextField(20);
		phoneNumber = new JTextField(20);
		email = new JTextField(20);
		officeStreet = new JTextField(20);
		officeNumber = new JTextField(5);
		officeCity = new JTextField(20);
		officeCountry = new JTextField(20);
		idNumber = new JTextField(20);
		title = new JComboBox<Professor.Title>();
		yearsOfExperience = new JTextField(5);
		confirm = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		
		if(!isAdd) {
			int selectedIndex = ProfessorTable.getInstance().getSelectedRow();
			Professor selectedProf = ProfessorController.getInstance().getProfessor(selectedIndex);
			if(selectedIndex == -1) {
				dispose();
			}else if(selectedIndex >= 0) {
				
				firstName.setText(selectedProf.getFirstName());
				lastName.setText(selectedProf.getLastName());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				dateOfBirth.setText(selectedProf.getDateOfBirth().format(formatter));

				homeStreet.setText(selectedProf.getHomeAddress().getStreet());
				homeNumber.setText(selectedProf.getHomeAddress().getNumber());
				homeCity.setText(selectedProf.getHomeAddress().getCity());
				homeCountry.setText(selectedProf.getHomeAddress().getCountry());
				
				officeStreet.setText(selectedProf.getOfficeAddress().getStreet());
				officeNumber.setText(selectedProf.getOfficeAddress().getNumber());
				officeCity.setText(selectedProf.getOfficeAddress().getCity());
				officeCountry.setText(selectedProf.getOfficeAddress().getCountry());
				
				phoneNumber.setText(selectedProf.getPhoneNumber());
				email.setText(selectedProf.getEmail());
				idNumber.setText(selectedProf.getIdNumber());
				title.getModel().setSelectedItem(selectedProf.getTitle());
				yearsOfExperience.setText(Integer.toString(selectedProf.getYearsOfExperience()));
			}
		}
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel pInfo = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		ProfessorDocumentListener pdl = new ProfessorDocumentListener();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== IME =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("firstName")), setCooridnates(gb, 0, 0));
		
		firstName.getDocument().addDocumentListener(pdl);
		pInfo.add(firstName, setCooridnates(gb, 1, 0));
		
		// ===== PREZIME =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("lastName")), setCooridnates(gb, 0, 1));
		
		lastName.getDocument().addDocumentListener(pdl);
		pInfo.add(lastName, setCooridnates(gb, 1, 1));
		
		// ===== DATUM RODJENJA =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("dateOfBirth")), setCooridnates(gb, 0, 2));
		
		dateOfBirth.getDocument().addDocumentListener(pdl);
		pInfo.add(dateOfBirth, setCooridnates(gb, 1, 2));
		pInfo.add(new JLabel("dd.MM.yyyy"), setCooridnates(gb, 2, 2));
		// ===== KUCNA ADRESA =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("homeAddress")), setCooridnates(gb, 0, 3));
		
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("street")), setCooridnates(gb, 0, 4));
		pInfo.add(homeStreet, setCooridnates(gb, 1, 4));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("number")), setCooridnates(gb, 0, 5));
		pInfo.add(homeNumber, setCooridnates(gb, 1, 5));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("city")), setCooridnates(gb, 0, 6));
		pInfo.add(homeCity, setCooridnates(gb, 1, 6));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("country")), setCooridnates(gb, 0, 7));
		pInfo.add(homeCountry, setCooridnates(gb, 1, 7));
		
		homeStreet.getDocument().addDocumentListener(pdl);
		homeNumber.getDocument().addDocumentListener(pdl);
		homeCity.getDocument().addDocumentListener(pdl);
		homeCountry.getDocument().addDocumentListener(pdl);
		
		// ===== ADRESA KANCELARIJE =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("officeAddress")), setCooridnates(gb, 0, 8));
		
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("street")), setCooridnates(gb, 0, 9));
		pInfo.add(officeStreet, setCooridnates(gb, 1, 9));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("number")), setCooridnates(gb, 0, 10));
		pInfo.add(officeNumber, setCooridnates(gb, 1, 10));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("city")), setCooridnates(gb, 0, 11));
		pInfo.add(officeCity, setCooridnates(gb, 1, 11));
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("country")), setCooridnates(gb, 0, 12));
		pInfo.add(officeCountry, setCooridnates(gb, 1, 12));
		
		officeStreet.getDocument().addDocumentListener(pdl);
		officeNumber.getDocument().addDocumentListener(pdl);
		officeCity.getDocument().addDocumentListener(pdl);
		officeCountry.getDocument().addDocumentListener(pdl);
		
		// ===== BROJ TELEFONA =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("phoneNumber")), setCooridnates(gb, 0, 13));
		
		phoneNumber.getDocument().addDocumentListener(pdl);
		pInfo.add(phoneNumber, setCooridnates(gb, 1, 13));
		
		// ==== EMAIL =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("email")), setCooridnates(gb, 0, 14));
		
		email.getDocument().addDocumentListener(pdl);
		pInfo.add(email, setCooridnates(gb, 1, 14));
		
		// ===== BROJ LICNE KARTE =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("idNumber")), setCooridnates(gb, 0, 15));
		
		idNumber.getDocument().addDocumentListener(pdl);
		pInfo.add(idNumber, setCooridnates(gb, 1, 15));
		
		// ===== ZVANJE =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("title")), setCooridnates(gb, 0, 17));
		
		title = new JComboBox<>();
		title.setModel(new DefaultComboBoxModel<>(Professor.Title.values()));
		pInfo.add(title, setCooridnates(gb, 1, 17));
		
		// ===== GODINE STAZA =====
		pInfo.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearsOfExperience")), setCooridnates(gb, 0, 18));
		
		yearsOfExperience.getDocument().addDocumentListener(pdl);
		pInfo.add(yearsOfExperience, setCooridnates(gb, 1, 18));
		
		// BUTTONS
		
		
		if(isAdd)
			confirm.setEnabled(false);
		else 
			confirm.setEnabled(true);
		
		
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
						homeNumber.getText(),
						homeCity.getText(),
						homeCountry.getText());
				p.setHomeAddress(homeAddress);
				Address officeAddress = new Address(officeStreet.getText(), 
						officeNumber.getText(),	
						officeCity.getText(),
						officeCountry.getText());
				p.setOfficeAddress(officeAddress);
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
				
				
				if(!isAdd) {
					int selectedIndex = ProfessorTable.getInstance().getSelectedRow();
					Professor selectedProf = ProfessorController.getInstance().getProfessor(selectedIndex);
					if(ProfessorController.getInstance().existsById(p.getIdNumber()) && !selectedProf.getIdNumber().equals(p.getIdNumber())) {
						JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("professorExists"));
					}else if(ProfessorDataBase.getInstance().editProfessor(p, ProfessorTable.getInstance().getSelectedRow())) {
						ProfessorTable.getInstance().update();
						dispose();
					}
				}else {
					if(ProfessorDataBase.getInstance().addProfessor(p)) {
						ProfessorTable.getInstance().update();
						dispose();
					}else {
						JOptionPane.showMessageDialog(getParent(), MainFrame.getInstance().getResourceBundle().getString("professorExists"));
					}
				}
			}
		});
		pInfo.add(confirm, setCooridnates(gb, 0, 19));
		
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		pInfo.add(cancel, setCooridnates(gb, 1, 19));
		
		if(isAdd) {
			add(pInfo);
		}
		else {
			JTabbedPane editTabbedPane = new JTabbedPane();
			editTabbedPane.addTab("Info", pInfo);
			editTabbedPane.addTab(MainFrame.getInstance().getResourceBundle().getString("courses"), new JLabel("Predmeti"));
			add(editTabbedPane);
		}
		setResizable(false);
		setVisible(true);
		
	}
	public GridBagConstraints setCooridnates(GridBagConstraints gb, int x, int y) {
		gb.gridx = x;
		gb.gridy = y;
		return gb;
	}
}
