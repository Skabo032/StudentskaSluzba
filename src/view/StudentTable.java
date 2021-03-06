package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentTable instance = null;
	
	public static StudentTable getInstance() {
		if(instance == null)
			instance = new StudentTable();
		return instance;
	}
	
	public void update() {
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent)instance.getModel();
		modelStudent.fireTableDataChanged();
		validate();
	}
	
	public void updateLanguage() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("index"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("firstName"));
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("lastName"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudies"));
		getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("status"));
		getColumnModel().getColumn(5).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("gradeAverage"));
	}
	
	private StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		this.setAutoCreateRowSorter(true);
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
