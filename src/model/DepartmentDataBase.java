package model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDataBase {
	
	private static DepartmentDataBase instance = null;
	private List<Department> departments;
	
	private DepartmentDataBase() {
		this.departments = new ArrayList<Department>();
		List<Professor> departmentProfessors1 = new ArrayList<Professor>();
		departmentProfessors1.add(ProfessorDataBase.getInstance().getProfessor(0));
		departmentProfessors1.add(ProfessorDataBase.getInstance().getProfessor(6));
		departmentProfessors1.add(ProfessorDataBase.getInstance().getProfessor(12));
		departmentProfessors1.add(ProfessorDataBase.getInstance().getProfessor(18));
		List<Professor> departmentProfessors2 = new ArrayList<Professor>();
		departmentProfessors2.add(ProfessorDataBase.getInstance().getProfessor(1));
		departmentProfessors2.add(ProfessorDataBase.getInstance().getProfessor(7));
		departmentProfessors2.add(ProfessorDataBase.getInstance().getProfessor(13));
		List<Professor> departmentProfessors3 = new ArrayList<Professor>();
		departmentProfessors3.add(ProfessorDataBase.getInstance().getProfessor(2));
		departmentProfessors3.add(ProfessorDataBase.getInstance().getProfessor(8));
		departmentProfessors3.add(ProfessorDataBase.getInstance().getProfessor(14));
		List<Professor> departmentProfessors4 = new ArrayList<Professor>();
		departmentProfessors4.add(ProfessorDataBase.getInstance().getProfessor(3));
		departmentProfessors4.add(ProfessorDataBase.getInstance().getProfessor(9));
		departmentProfessors4.add(ProfessorDataBase.getInstance().getProfessor(15));
		List<Professor> departmentProfessors5 = new ArrayList<Professor>();
		departmentProfessors5.add(ProfessorDataBase.getInstance().getProfessor(4));
		departmentProfessors5.add(ProfessorDataBase.getInstance().getProfessor(10));
		departmentProfessors5.add(ProfessorDataBase.getInstance().getProfessor(16));
		List<Professor> departmentProfessors6 = new ArrayList<Professor>();
		departmentProfessors6.add(ProfessorDataBase.getInstance().getProfessor(5));
		departmentProfessors6.add(ProfessorDataBase.getInstance().getProfessor(11));
		departmentProfessors6.add(ProfessorDataBase.getInstance().getProfessor(17));
		
		departments.add(new Department("e42", "Katedra za matematiku", ProfessorDataBase.getInstance().getProfessor(1), departmentProfessors1));
		departments.add(new Department("e43", "Katedra za fiziku", ProfessorDataBase.getInstance().getProfessor(2), departmentProfessors2));
		departments.add(new Department("e44", "Katedra za elektrotehniku", ProfessorDataBase.getInstance().getProfessor(3), departmentProfessors3));
		departments.add(new Department("e45", "Katedra za primenjene računarske nauke", ProfessorDataBase.getInstance().getProfessor(6), departmentProfessors4));
		departments.add(new Department("e46", "Katedra za informatiku", ProfessorDataBase.getInstance().getProfessor(12), departmentProfessors5));
		departments.add(new Department("e47", "Katedra za automatiku", ProfessorDataBase.getInstance().getProfessor(17), departmentProfessors6));
	}
	
}
