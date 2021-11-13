package main;

import java.util.List;

enum Semester{
	SUMMER,
	WINTER
}

public class Course {
	private int courseID;
	private int courseName;
	private Semester semester;
	private int yearOfStudy;
	private Professor courseProffesor;
	private int ectsPoints; // ESPB poeni
	private List<Student> studentsPassed;
	private List<Student> studentsFailed;
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
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
