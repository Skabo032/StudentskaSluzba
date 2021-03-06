package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDataBase;

public class AbstractTableModelProfessor extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelProfessor() {
	}
	@Override
	public int getColumnCount() {
		return ProfessorDataBase.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return ProfessorDataBase.getInstance().getRowCount();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return ProfessorDataBase.getInstance().getValueAt(arg0, arg1);
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return MainFrame.getInstance().getResourceBundle().getString("firstName");
			
		case 1:
			return MainFrame.getInstance().getResourceBundle().getString("lastName");
			
		case 2:
			return MainFrame.getInstance().getResourceBundle().getString("title");
			
		case 3:
			return MainFrame.getInstance().getResourceBundle().getString("email");
			
		default:
			return "";
			
		}
	}
	
}
