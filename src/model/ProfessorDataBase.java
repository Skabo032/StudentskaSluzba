package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDataBase {
	private static ProfessorDataBase instance = null;
	
	public static ProfessorDataBase getInstance() {
		if(instance == null)
			instance = new ProfessorDataBase();
		return instance;
	}
	
	private List<Professor> professors;
	private List<String> columnNames;
	
	private ProfessorDataBase() {
		
		this.columnNames = new ArrayList<String>();
		this.columnNames.add("Ime");
		this.columnNames.add("Prezime");
		this.columnNames.add("Zvanje");
		this.columnNames.add("E-mail");
		
		this.professors = new ArrayList<Professor>();
		Address a1 = new Address("abc", 5, "abv", "ab");
		Professor p1 = new Professor("Peric", "Pera", LocalDate.now(), a1, "123", "email", a1, "22222", "dr", 5, null);
		this.professors.add(p1);
	}
	
	public int getColumnCount() {
		return columnNames.size();
	}
	public void addProfessor(Professor p) {
		this.professors.add(p);
	}
	
	public void removeProfessor(int index) {
		professors.remove(index);
	}
	public int getRowCount() {
		return 1;
	}
	public String getValueAt(int row, int column) {
		Professor professor = this.professors.get(row);
		switch (column) {
		case 0:
			return professor.getFirstName();
		case 1:
			return professor.getLastName();
		case 2:
			return professor.getTitle();
		case 3:
			return professor.getEmail();
		default:
			return null;
		}
		
	}
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
	// add changeProfessor
	// add searchProfessor
}
