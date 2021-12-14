package view;

import javax.swing.table.AbstractTableModel;

import model.CourseDataBase;

public class AbstractTableModelCourse extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return CourseDataBase.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return CourseDataBase.getInstance().getRowCount();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return CourseDataBase.getInstance().getValueAt(arg0, arg1);
	}
	
	@Override
	public String getColumnName(int column) {
		return CourseDataBase.getInstance().getColumnName(column);
	}
	
}
