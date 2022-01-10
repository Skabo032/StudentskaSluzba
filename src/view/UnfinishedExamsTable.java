package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class UnfinishedExamsTable extends JTable{
	
	private static UnfinishedExamsTable instance = null;
	
	public static UnfinishedExamsTable getInstance() {
		if (instance == null)
			instance = new UnfinishedExamsTable();
		return instance;
	}
	
	private UnfinishedExamsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelUnfinishedExams());
	}
	
	public void update() {
		AbstractTableModelUnfinishedExams model = new AbstractTableModelUnfinishedExams();
		model.fireTableDataChanged();
		validate();
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
