package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PassedExamsTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static PassedExamsTable instance = null;
	
	public static PassedExamsTable getInstance() {
		if (instance == null)
			instance = new PassedExamsTable();
		return instance;
	}
	
	private PassedExamsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPassedExams());
	}
	
	public void update() {
		AbstractTableModelPassedExams model = (AbstractTableModelPassedExams) instance.getModel();
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
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("espb"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("grade"));
		getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("date"));
	}

}
