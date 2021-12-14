package model;

import java.util.List;

enum Semester{
	SUMMER,
	WINTER
}

public class Course {
	private int courseID;
	private String courseName;
	private Semester semester;
	private int yearOfStudy;
	private Professor courseProffesor;
	private int ectsPoints; // ESPB poeni
	private List<Student> studentsPassed;
	private List<Student> studentsFailed;
	
	
	public Course() {
		super();
		this.courseID = 1;
		this.courseName = "oisisi";
		this.semester = Semester.WINTER;
		this.yearOfStudy = 3;
		this.ectsPoints = 5;
	}
	public Course(int courseID, String courseName, Semester semester, int yearOfStudy, Professor courseProffesor,
			int ectsPoints, List<Student> studentsPassed, List<Student> studentsFailed) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.courseProffesor = courseProffesor;
		this.ectsPoints = ectsPoints;
		this.studentsPassed = studentsPassed;
		this.studentsFailed = studentsFailed;
	}
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public Professor getCourseProffesor() {
		return courseProffesor;
	}
	public void setCourseProffesor(Professor courseProffesor) {
		this.courseProffesor = courseProffesor;
	}
	public int getEctsPoints() {
		return ectsPoints;
	}
	public void setEctsPoints(int ectsPoints) {
		this.ectsPoints = ectsPoints;
	}
	public List<Student> getStudentsPassed() {
		return studentsPassed;
	}
	public void setStudentsPassed(List<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}
	public List<Student> getStudentsFailed() {
		return studentsFailed;
	}
	public void setStudentsFailed(List<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}
	
	
}
