package model;

import java.time.LocalDate;
import java.util.List;



public class Professor {
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private Address homeAddress;
	private String phoneNumber;
	private String email;
	private Address officeAddress;
	private String idNumber; // professor id number can start with 00...
	private Title title;
	private int yearsOfExperience;
	private List<Course> courses;
	
	public enum Title{
		PROFESSOR,
		DOCENT,
		ASSISTANT,
		INSTRUCTOR
	}
	
	public Professor() {
		super();
	}
	public Professor(String lastName, String firstName, LocalDate dateOfBirth, Address homeAddress, String phoneNumber,
			String email, Address officeAddress, String idNumber, Title title, int yearsOfExperience,
			List<Course> courses) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.officeAddress = officeAddress;
		this.idNumber = idNumber;
		this.title = title;
		this.yearsOfExperience = yearsOfExperience;
		this.courses = courses;
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
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
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) throws Exception{
		if(yearsOfExperience >= 0)
			this.yearsOfExperience = yearsOfExperience;
		else
			throw new Exception("Invalid value for professor years of experience, cannot be less than 0!");
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
