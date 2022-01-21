package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("help"), true);
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 800;
		int sizeY = 300;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		GridBagLayout gbl = new GridBagLayout();
		JPanel p = new JPanel(gbl);
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.insets = new Insets(0,0,10,0);	// sets bottom padding to 10px for every component
		gb.anchor = GridBagConstraints.WEST;
		
		gb.gridx = 0;
		gb.gridy = 0;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help1")), gb);
		
		gb.gridx = 0;
		gb.gridy = 1;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help2")), gb);
		
		gb.gridx = 0;
		gb.gridy = 2;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help3")), gb);
		
		gb.gridx = 0;
		gb.gridy = 3;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help4")), gb);
		
		gb.gridx = 0;
		gb.gridy = 4;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help5")), gb);
		
		gb.gridx = 0;
		gb.gridy = 5;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help6")), gb);
		
		gb.gridx = 0;
		gb.gridy = 6;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help7")), gb);
		
		gb.gridx = 0;
		gb.gridy = 7;
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("help8")), gb);
		
		
		add(p);
		setVisible(true);
	}
}
