package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("about"), true);
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 800;
		int sizeY = 100;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel p = new JPanel(new BorderLayout());
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("version")), BorderLayout.NORTH);
		p.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("description")), BorderLayout.CENTER);
		
		JPanel bio = new JPanel();
		bio.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("ratkoBio")));
		bio.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("boskoBio")));
		p.add(bio, BorderLayout.SOUTH);
		add(p);
		
		
		setVisible(true);
	}
}
