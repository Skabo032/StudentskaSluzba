package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfessorDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorDialog(String dialogTitle) {
		super(MainFrame.getInstance(), dialogTitle, true); 
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 500;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX+ (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		// ===== IME =====
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel("Ime: "), gb);
		
		JTextField firstName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		p.add(firstName, gb);
		
		// ===== PREZIME =====
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel("Prezime: "), gb);
		
		JTextField lastName = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		p.add(lastName, gb);
		
		// ===== DATUM RODJENJA =====
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel("Datum rodjenja: "), gb);
		
		JTextField dateOfBirth = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 2;
		p.add(dateOfBirth, gb);
		
		// ===== KUCNA ADRESA =====
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel("Kucna adresa: "), gb);
		
		JTextField homeAddress = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 3;
		p.add(homeAddress, gb);
		
		// ===== BROJ TELEFONA =====
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel("Broj telefona: "), gb);
		
		JTextField phoneNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 4;
		p.add(phoneNumber, gb);
		
		// ==== EMAIL =====
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel("E-mail: "), gb);
		
		JTextField email = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 5;
		p.add(email, gb);
		
		// ===== ADRESA KANCELARIJE =====
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel("Adresa kancelarije: "), gb);
		
		JTextField officeAddress = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 6;
		p.add(officeAddress, gb);
		
		// ===== BROJ LICNE KARTE =====
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel("Broj licne karte: "), gb);
		
		JTextField idNumber = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 7;
		p.add(idNumber, gb);
		
		// ===== ZVANJE =====
		gb.gridx = 0;
		gb.gridy = 8;
		p.add(new JLabel("Zvanje: "), gb);
		
		JTextField title = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 8;
		p.add(title, gb);
		
		// ===== GODINE STAZA =====
		gb.gridx = 0;
		gb.gridy = 9;
		p.add(new JLabel("Godine staza: "), gb);
		
		JTextField yearsOfExperience = new JTextField(5);
		gb.gridx = 1;
		gb.gridy = 9;
		p.add(yearsOfExperience, gb);
		
		// BUTTONS
		gb.gridx = 0;
		gb.gridy = 10;
		JButton confirm = new JButton("Potvrdi");
		p.add(confirm, gb);
		
		gb.gridx = 1;
		gb.gridy = 10;
		JButton cancel = new JButton("Otkazi");
		p.add(cancel, gb);
		
		add(p);
		setVisible(true);
	}
}
