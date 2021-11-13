package main;

import java.time.LocalDate;

public class Grade {
	private Student student;
	private Course course;
	private int grade;
	private LocalDate dateOfExam;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade >= 6 && grade <= 10)
			this.grade = grade;
		else {
			//throw exception
		}
	}
	public LocalDate getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

}
