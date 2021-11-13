package main;

import java.time.LocalDate;

enum Status{
	B, //budzet
	S  //sammofinansiranje
}

public class Student {
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private String adress;
	private String phoneNumber;
	private String email;
	private String indexNumber;
	private int yearOfEnrolment;
	private int currentYearOfStudies;
	private Status status;
	private double avgGrade;
	//spisak polozenih ispita (spisak ocena)
	//spisak nepolozenih ispita
	
	

}
