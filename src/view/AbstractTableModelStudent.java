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
		switch (column) {
		case 0:
			return MainFrame.getInstance().getResourceBundle().getString("index");
			
		case 1:
			return MainFrame.getInstance().getResourceBundle().getString("firstName");
			
		case 2:
			return MainFrame.getInstance().getResourceBundle().getString("lastName");
			
		case 3:
			return MainFrame.getInstance().getResourceBundle().getString("yearOfStudies");
			
		case 4:
			return MainFrame.getInstance().getResourceBundle().getString("status");
			
		case 5:
			return MainFrame.getInstance().getResourceBundle().getString("gradeAverage");
			

		default:
			return "";
			
		}
	}

}
