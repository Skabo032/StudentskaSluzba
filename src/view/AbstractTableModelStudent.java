package view;

import javax.swing.table.AbstractTableModel;

import model.StudentDataBase;

public class AbstractTableModelStudent extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AbstractTableModelStudent() {
		
	}

	@Override
	public int getRowCount() {
		return StudentDataBase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return StudentDataBase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDataBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return StudentDataBase.getInstance().getColumnName(column);
	}

}
