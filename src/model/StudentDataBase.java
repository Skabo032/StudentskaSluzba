package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Course.Semester;
import model.Professor.Title;
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
		List<Grade> passedExams1 = new ArrayList<Grade>();
		//passedExams.add(new Grade(student, course, grade, dateOfExam))
		List<Grade> unfinishedExams1 = new ArrayList<Grade>();
		Address a1 = new Address("fafs", "5", "sds", "fsaf");
		//Student s1 = new Student("Najjaci", "Lik", LocalDate.now(), a1, "06633333", "bezveze@gmail.com", "RA 420/2019", 3, 3, Status.B, 9.12, passedExams, unfinishedExams);
		Student s1 = new Student();
		s1.setFirstName("Najjaci");
		s1.setLastName("Lik");
		s1.setDateOfBirth(LocalDate.now());
		s1.setAddress(a1);
		s1.setEmail("bezveze@gmail.com");
		s1.setIndexNumber("RA 420/2019");
		s1.setPhoneNumber("4234234234");
		s1.setAvgGrade(9.12);
		s1.setStatus(Status.B);
		s1.setCurrentYearOfStudies(3);
		s1.setYearOfEnrolment(2019);
		Professor p1 = new Professor("Peric", "Pera", LocalDate.now(), a1, "123", "email@asd.ac", a1, "22222", Title.PROFESSOR, 5, null);

		Course c1 = CourseDataBase.getInstance().getCourse(0);
		unfinishedExams1.add(new Grade(s1, c1, 5, LocalDate.now()));
		s1.setUnfinishedExams(unfinishedExams1);
		Course c2 = CourseDataBase.getInstance().getCourse(1);
		passedExams1.add(new Grade(s1, c2, 7, LocalDate.now()));
		s1.setPassedExams(passedExams1);
		
		
		Student s2 = new Student();
		s2.setFirstName("Matija");
		s2.setLastName("Jovic");
		s2.setDateOfBirth(LocalDate.now());
		s2.setAddress(a1);
		s2.setEmail("bezveze@gmail.com");
		s2.setIndexNumber("RA 20/2019");
		s2.setPhoneNumber("111");
		s2.setAvgGrade(9.12);
		s2.setStatus(Status.B);
		s2.setCurrentYearOfStudies(3);
		s2.setYearOfEnrolment(2019);
		List<Grade> passedExams2 = new ArrayList<Grade>();
		passedExams2.add(new Grade(s2, c1, 5, LocalDate.now()));
		List<Grade> unfinishedExams2 = new ArrayList<Grade>();
		unfinishedExams2.add(new Grade(s2, c2, 5, LocalDate.now()));
		s2.setPassedExams(passedExams2);
		s2.setUnfinishedExams(unfinishedExams2);

		this.students.add(s1);
		this.students.add(s2);
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
	
	public boolean editStudent(int rowNum, Student s) {
		return students.set(rowNum, s) != null;
	}
	
	public boolean existsById(String indexNumber) {
		for (Student stud : students) {
			if(stud.getIndexNumber().equals(indexNumber))
				return true;
		}
		return false;
	}
	
	public boolean removeStudentByRowNum(int i) {
		return students.remove(i) != null;
	}

}
