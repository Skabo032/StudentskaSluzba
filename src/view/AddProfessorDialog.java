package view;

import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfessorDialog extends JDialog{
	public AddProfessorDialog() {
		super(MainFrame.getInstance(), "Dodaj profesora", true);  
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 500;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX+ (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		
		
		JPanel p = new JPanel();
		
		JLabel l1 = new JLabel("Ime: ");
		JTextField firstName = new JTextField(20);
		l1.setLabelFor(firstName);
		p.add(l1);
		p.add(firstName);
		
		p.add(Box.createVerticalGlue());
		
		JLabel l2 = new JLabel("Prezime: ");
		JTextField lastName = new JTextField(20);
		l2.setLabelFor(lastName);
		p.add(l2);
		p.add(lastName);
		
		
		add(p);
		setVisible(true);
	}
}
