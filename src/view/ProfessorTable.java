package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class ProfessorTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProfessorTable instance = null;
	
	private ProfessorTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessor());
		
	}
	
	public static ProfessorTable getInstance() {
		if(instance == null)
			instance = new ProfessorTable();
		return instance;
	}
	
	public void update() {
		AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor)instance.getModel();
		modelProfessor.fireTableDataChanged();
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
