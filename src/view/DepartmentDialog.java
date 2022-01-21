package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DepartmentDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("departmentDialog"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 400;
		int sizeY = 600;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(new JScrollPane(DepartmentTable.getInstance()), BorderLayout.CENTER);
		
		JButton btnIzmeni = new JButton(MainFrame.getInstance().getResourceBundle().getString("edit"));
		p.add(btnIzmeni, BorderLayout.NORTH);
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DepartmentTable.getInstance().getSelectedRow() != -1)
				{
					new DepartmentEditDialog();
				}
				
			}
		});
		
		add(p);
		setVisible(true);
	}

}
