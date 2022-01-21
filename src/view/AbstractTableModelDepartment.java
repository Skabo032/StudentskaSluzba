package view;

import javax.swing.table.AbstractTableModel;

import model.DepartmentDataBase;

public class AbstractTableModelDepartment extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return DepartmentDataBase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return DepartmentDataBase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return DepartmentDataBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return MainFrame.getInstance().getResourceBundle().getString("departmentId");	
		case 1:
			return MainFrame.getInstance().getResourceBundle().getString("departmentName");
		case 2:
			return MainFrame.getInstance().getResourceBundle().getString("departmentCheif");
		default:
			return "";
		
		}
	}

}
