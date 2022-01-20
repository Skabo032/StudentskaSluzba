package model;

import java.util.List;


public class Course {
	private String courseID;
	private String courseName;
	private Semester semester;
	private int yearOfStudy;
	private Professor courseProffesor;
	private int ectsPoints; // ESPB poeni
	private List<Student> studentsPassed;
	private List<Student> studentsFailed;
	
	public enum Semester{
		SUMMER,
		WINTER
	}
	
	
	public Course() {
		super();
	}
	
	
	public Course(String courseID, String courseName, int yearOfStudy, int ectsPoints, Professor courseProffesor, Semester semester) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.courseProffesor = courseProffesor;
		this.ectsPoints = ectsPoints;
	}


	public Course(String courseID, String courseName, Semester semester, int yearOfStudy, Professor courseProffesor,
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
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) throws Exception{
		
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
	public void setYearOfStudy(int yearOfStudy) throws Exception {
		if (yearOfStudy >= 0)
			this.yearOfStudy = yearOfStudy;
		else 
			throw new Exception("Invalid value for course year of study, cannot be less than zero!");
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
	public void setEctsPoints(int ectsPoints) throws Exception {
		if (ectsPoints >= 0)
			this.ectsPoints = ectsPoints;
		else 
			throw new Exception("Invalid value for course ECTS points, cannot be less than zero!");
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
