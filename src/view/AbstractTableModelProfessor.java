package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDataBase;

public class AbstractTableModelProfessor extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		//System.out.println(ProfessorDataBase.getInstance().getColumnCount());
		return ProfessorDataBase.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return ProfessorDataBase.getInstance().getRowCount();
	}
	@Override
	public String getColumnName(int column) {
		System.out.println(ProfessorDataBase.getInstance().getColumnName(column));
		return ProfessorDataBase.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		System.out.println(ProfessorDataBase.getInstance().getValueAt(arg0, arg1));
		return ProfessorDataBase.getInstance().getValueAt(arg0,  arg1);
	}
	
}
