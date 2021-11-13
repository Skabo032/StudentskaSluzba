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
	
	
}
