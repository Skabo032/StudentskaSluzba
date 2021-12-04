package main;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add entity");
		btnAdd.setIcon(addIco);
		add(btnAdd);
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit entity");
		btnEdit.setIcon(editIco);
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
}
