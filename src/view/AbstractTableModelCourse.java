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
		switch (column) {
		case 0:
			return MainFrame.getInstance().getResourceBundle().getString("courseId");
			
		case 1:
			return MainFrame.getInstance().getResourceBundle().getString("courseName");
			
		case 2:
			return MainFrame.getInstance().getResourceBundle().getString("espb");
			
		case 3:
			return MainFrame.getInstance().getResourceBundle().getString("year");
			
		case 4:
			return MainFrame.getInstance().getResourceBundle().getString("semester");
		default:
			return "";
			
		}
	}
	
}
