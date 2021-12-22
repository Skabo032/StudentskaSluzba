package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		// all of the icon images are imported and resized
		ImageIcon addIco = new ResizeIcon("images/add.png", 20, 20).getIcon();
		ImageIcon editIco = new ResizeIcon("images/edit.png", 20, 20).getIcon();
		ImageIcon deleteIco = new ResizeIcon("images/delete.png", 20, 20).getIcon();
		ImageIcon searchIco = new ResizeIcon("images/search.png", 20, 20).getIcon();

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
					//ProfessorAddDialog.getInstance();
					new ProfessorAddDialog();
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
					if(ProfessorTable.getInstance().getSelectedRow() != -1)
						new ProfessorEditDialog();
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
