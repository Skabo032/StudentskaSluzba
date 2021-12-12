package model;

import java.time.LocalDate;
import java.util.List;

public class ProfessorDataBase {
	private static ProfessorDataBase instance = null;
	private List<Professor> professors;
	private List<String> columnNames;
	
	private ProfessorDataBase() {
		initialise();
		
		Address a1 = new Address("abc", 5, "abv", "ab");
		Professor p1 = new Professor("Peric", "Pera", LocalDate.now(), a1, "123", "email", a1, "22222", "dr", 5, null);
		professors.add(p1);
	}
	private void initialise() {
		// adding column names
		this.columnNames.add("Ime");
		this.columnNames.add("Prezime");
		this.columnNames.add("Zvanje");
		this.columnNames.add("E-mail");
		
		// read from CSV and add to database
	}
	public static ProfessorDataBase getInstance() {
		if(instance == null)
			instance = new ProfessorDataBase();
		return instance;
	}
	public int getColumnCount() {
		return professors.size();
	}
	public void addProfessor(Professor p) {
		this.professors.add(p);
	}
	public void removeProfessor(int index) {
		professors.remove(index);
	}
	// add changeProfessor
	// add searchProfessor
}
