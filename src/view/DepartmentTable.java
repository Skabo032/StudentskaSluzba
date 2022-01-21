package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class DepartmentTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DepartmentTable instance = null;
	public static DepartmentTable getInstance() {
		if(instance == null)
			instance = new DepartmentTable();
		return instance;
	}
	
	private DepartmentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelDepartment());
		//this.setAutoCreateRowSorter(true);
	}
	
	public void update() {
		AbstractTableModelDepartment modelDepartment = (AbstractTableModelDepartment) instance.getModel();
		modelDepartment.fireTableDataChanged();
		validate();
	}
	
	public void updateLanguage() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("departmentId"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("departmentName"));
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("departmentCheif"));
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

}
