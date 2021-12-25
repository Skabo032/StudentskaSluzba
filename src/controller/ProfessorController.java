package controller;

import model.Professor;
import model.ProfessorDataBase;

public class ProfessorController {
	public static ProfessorController instance = null;
	
	private ProfessorController() {}
	
	public static ProfessorController getInstance() {
		if(instance == null)
			instance = new ProfessorController();
		return instance;
	}
	
	public boolean addProfessor(Professor p) {
		return ProfessorDataBase.getInstance().addProfessor(p);
	}
	
	public boolean removeProfessorByRowNum(int id) {
		return ProfessorDataBase.getInstance().removeProfessorByRowNum(id);
	}
	public void removeProfessorById(String idNumber) {
		ProfessorDataBase.getInstance().removeProfessorById(idNumber);
	}
	public boolean editProfessor(Professor p) {
		return ProfessorDataBase.getInstance().editProfessor(p);
	}
	public Professor getProfessor(int i) {
		return ProfessorDataBase.getInstance().getProfessor(i);
	}
}
