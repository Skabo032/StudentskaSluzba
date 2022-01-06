package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class CourseTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CourseTable instance = null;
	
	public static CourseTable getInstance() {
		if(instance == null)
			instance = new CourseTable();
		return instance;
	}
	
	public void update() {
		AbstractTableModelCourse modelCourse = (AbstractTableModelCourse)instance.getModel();
		modelCourse.fireTableDataChanged();
		validate();
	}
	
	public CourseTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelCourse());
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
