package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Course;
import model.CourseDataBase;
import model.Department;
import model.ProfessorDataBase;
import model.Professor.Title;
import model.DepartmentDataBase;
import model.Professor;

public class DepartmentEditDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DepartmentEditDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("chooseDepartmentCheif"), true);
		
		int mfLocX = (int)MainFrame.getInstance().getLocation().getX();
		int mfLocY = (int)MainFrame.getInstance().getLocation().getY();
		int mfW = MainFrame.getInstance().getSize().width;
		int mfH = MainFrame.getInstance().getSize().height;
		
		int sizeX = 300;
		int sizeY = 400;
		setSize(sizeX,sizeY);    
		setLocation(mfLocX + (mfW-sizeX)/2, mfLocY + (mfH - sizeY)/2);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel p = new JPanel(new BorderLayout());
		JPanel dugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		int selectedIndex = DepartmentTable.getInstance().getSelectedRow();
		Department selectedDep = DepartmentDataBase.getInstance().getDepartment(selectedIndex);
		
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i < selectedDep.getProfessors().size(); i++) {
			Professor prof = selectedDep.getProfessors().get(i);
			if(prof.getYearsOfExperience()>=5 &&(prof.getTitle().equals(Title.REDOVNI_PROFESOR) || prof.getTitle().equals(Title.VANREDNI_PROFESOR)))
			{
				listModel.addElement(prof.getIdNumber() + " " + prof.getFirstLastName());
			}
		}
		JList<String> profList = new JList<String>(listModel);
		JScrollPane profList2 = new JScrollPane(profList);
		p.add(profList2, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton(MainFrame.getInstance().getResourceBundle().getString("add"));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedProfIndex = profList.getSelectedIndex();
				if(selectedProfIndex != -1) {
					String words[] = profList.getSelectedValue().split(" ");
					Professor selectedProf = ProfessorDataBase.getInstance().getProfessorById(words[0]);
					
					selectedDep.setDepartmentCheif(selectedProf);
					DepartmentTable.getInstance().update();
					dispose();
				}
			}
		});
		JButton btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		dugmad.add(btnAdd);
		dugmad.add(btnCancel);
		p.add(dugmad, BorderLayout.SOUTH);
		add(p);
		setVisible(true);
	}

}
