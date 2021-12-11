package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		// all of the icon images are imported and resized
		// TODO: make a separate method that handles resizing icons
		ImageIcon addImg = new ImageIcon("images/add.png");
		Image imgAdd = addImg.getImage();
		Image newImgAdd = imgAdd.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon addIco = new ImageIcon(newImgAdd);
		
		ImageIcon editImg = new ImageIcon("images/edit.png");
		Image imgEdit = editImg.getImage();
		Image newImgEdit = imgEdit.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon editIco = new ImageIcon(newImgEdit);
		
		ImageIcon deleteImg = new ImageIcon("images/delete.png");
		Image imgDelete = deleteImg.getImage();
		Image newImgDelete = imgDelete.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon deleteIco = new ImageIcon(newImgDelete);
	
		ImageIcon searchImg = new ImageIcon("images/search.png");
		Image imgSearch = searchImg.getImage();
		Image newImgSearch = imgSearch.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon searchIco = new ImageIcon(newImgSearch);
		
		MouseListener mAdd = new AddBtnMouseListener();
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add entity");
		btnAdd.setIcon(addIco);
		btnAdd.addMouseListener(mAdd);
		add(btnAdd);
		
		MouseListener mEdit = new EditBtnMouseListener();
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit entity");
		btnEdit.setIcon(editIco);
		btnEdit.addMouseListener(mEdit);
		add(btnEdit);
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(deleteIco);
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		
		JTextField textField = new JTextField(20); // had to limit the minimum size of textfield ...
		textField.setToolTipText("Search");
		textField.setMaximumSize(new Dimension(200, 30)); // ... and the maximum size of textfield
		add(textField);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(searchIco);
		add(btnSearch);
		setFloatable(false);
	}
		
		class AddBtnMouseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					
					break;
				case 1:	// PROFFESOR
					ProfessorDialog profDiag = new ProfessorDialog("Dodaj profesora");
					break;
				case 2:	// COURSE
					/* skip */
					break;
				default:
					/* skip */
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
		class EditBtnMouseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(MainViewTabbedPane.getInstance().getSelectedIndex()) {
				case 0:	// STUDENT
					
					break;
				case 1:	// PROFFESOR
					ProfessorDialog profDiag = new ProfessorDialog("Izmeni profesora");
					break;
				case 2:	// COURSE
					/* skip */
					break;
				default:
					/* skip */
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
}
