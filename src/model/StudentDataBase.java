package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class StudentDataBase {
	private static StudentDataBase instance = null;
	
	public static StudentDataBase getInstance() {
		if(instance == null)
			instance = new StudentDataBase();
		return instance;
	}
	
	private List<Student> students;
	private List<String> columnNames;
	
	private StudentDataBase() {
		this.columnNames = new ArrayList<String>();
		this.columnNames.add("Indeks");
		this.columnNames.add("Ime");
		this.columnNames.add("Prezime");
		this.columnNames.add("Godina studija");
		this.columnNames.add("Status");
		this.columnNames.add("Prosek");
		
		this.students = new ArrayList<Student>();
		List<Grade> ispiti1 = new ArrayList<Grade>();
		Address a1 = new Address("fafs", 5, "sds", "fsaf");
		Student s1 = new Student("Najjaci", "Lik", LocalDate.now(), a1, "06633333", "bezveze@gmail.com", "RA 420/2019", 3, 3, Status.B, 9.12, ispiti1, ispiti1);
		this.students.add(s1);
	}
	
	public int getColumnCount() {
		return columnNames.size();
	}
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
	public int getRowCount() {
		return students.size();
	}
	
	public Object getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndexNumber();
		case 1:
			return student.getFirstName();
		case 2:
			return student.getLastName();
		case 3:
			return student.getCurrentYearOfStudies();
		case 4:
			return student.getStatus();
		case 5:
			return student.getAvgGrade();
		default:
			return null;
		}
	}
	
	public boolean addStudent(Student s) {
		//return this.professors.add(p);
		for (Student stud : students) {
			if(stud.getIndexNumber().equals(s.getIndexNumber()))
				return false;
		}
		return this.students.add(s);
	}
	
	public Student getStudent(int i) {
		try {
			return students.get(i);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean editStudent(Student s) {
		int i = 0;
		for (Student stud : students) {
			
			if(stud.getIndexNumber().equals(s.getIndexNumber())) {
				students.set(i, s);
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean removeStudentByRowNum(int i) {
		return students.remove(i) != null;
	}

}
