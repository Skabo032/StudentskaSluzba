package model;

import java.util.List;

public class Department {
	private String departmentID;
	private String departmentName;
	private Professor departmentCheif;
	private List<Professor> professors;
	
	public Department(String departmentID, String departmentName, Professor departmentCheif,
			List<Professor> professors) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentCheif = departmentCheif;
		this.professors = professors;
	}
	public Department() {
		super();
	}
	
	
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Professor getDepartmentCheif() {
		return departmentCheif;
	}
	public void setDepartmentCheif(Professor departmentCheif) {
		this.departmentCheif = departmentCheif;
	}
	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
}
