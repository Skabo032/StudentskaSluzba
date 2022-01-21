package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfessorTeachingTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static ProfessorTeachingTable instance = null;
	
	public static ProfessorTeachingTable getInstance() {
		if (instance == null)
			instance = new ProfessorTeachingTable();
		return instance;
	}
	
	public ProfessorTeachingTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessorTeaching());
		
		
	}
	
	public void update() {
		AbstractTableModelProfessorTeaching model = (AbstractTableModelProfessorTeaching) instance.getModel();
		model.fireTableDataChanged();
		validate();
	}	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void updateLanguage() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("courseId"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("courseName"));
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudies"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("semester"));
	}

}
