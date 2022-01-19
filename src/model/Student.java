package model;

import java.time.LocalDate;
import java.util.List;


public class Student {
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private Address address;
	private String phoneNumber;
	private String email;
	private String indexNumber;
	private int yearOfEnrolment;
	private int currentYearOfStudies;
	private Status status;
	private double avgGrade;
	private List<Grade> passedExams;
	private List<Grade> unfinishedExams;
	
	public enum Status{
		B, //budzet
		S  //sammofinansiranje
	}


	
	public Student(String lastName, String firstName, LocalDate dateOfBirth, Address address, String phoneNumber,
			String email, String indexNumber, int yearOfEnrolment, int currentYearOfStudies, Status status,
			double avgGrade, List<Grade> passedExams, List<Grade> unfinishedExams) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.indexNumber = indexNumber;
		this.yearOfEnrolment = yearOfEnrolment;
		this.currentYearOfStudies = currentYearOfStudies;
		this.status = status;
		this.avgGrade = avgGrade;
		this.passedExams = passedExams;
		this.unfinishedExams = unfinishedExams;
	}
	
	
	public Student() {
		super();
	}


	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndexNumber() {
		return indexNumber;
	}
	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
	public int getYearOfEnrolment() {
		return yearOfEnrolment;
	}
	public void setYearOfEnrolment(int yearOfEnrolment) {
		this.yearOfEnrolment = yearOfEnrolment;
	}
	public int getCurrentYearOfStudies() {
		return currentYearOfStudies;
	}
	public void setCurrentYearOfStudies(int currentYearOfStudies) {
		this.currentYearOfStudies = currentYearOfStudies;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	public List<Grade> getPassedExams() {
		return passedExams;
	}
	public void setPassedExams(List<Grade> passedExams) {
		this.passedExams = passedExams;
	}
	public List<Grade> getUnfinishedExams() {
		return unfinishedExams;
	}
	public void setUnfinishedExams(List<Grade> unfinishedExams) {
		this.unfinishedExams = unfinishedExams;
	}
	
	public double calcAvgGrade() {
		double sum = 0;
		for(Grade ocena : passedExams) {
			sum += ocena.getGrade();
		}
		double avg = sum / passedExams.size();
		return avg;
	}
	
	public int calcEcts() {
		int sum = 0;
		for(Grade ocena : passedExams) {
			sum += ocena.getCourse().getEctsPoints();
		}
		return sum;
	}
	
	
	

}
