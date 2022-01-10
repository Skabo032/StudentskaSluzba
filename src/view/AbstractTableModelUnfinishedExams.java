package view;

import javax.swing.table.AbstractTableModel;

import model.Grade;
import model.Student;
import model.StudentDataBase;



public class AbstractTableModelUnfinishedExams extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		int index = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(index);
		return selectedStudent.getUnfinishedExams().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		int index = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(index);
		Grade grade = selectedStudent.getUnfinishedExams().get(row);
		switch (column) {
		case 0:
			return grade.getCourse().getCourseID();
		case 1:
			return grade.getCourse().getCourseName();
		case 2:
			return grade.getCourse().getEctsPoints();
		case 3:
			return grade.getStudent().getCurrentYearOfStudies();
		case 4:
			return grade.getCourse().getSemester();
		default:
			return null;
		}	
	}
	
	@Override
	public String getColumnName(int column) {
		//return ;
		switch (column) {
		case 0:
			return "Sifra predmeta";
		case 1:
			return "Naziv predmeta";
		case 2:
			return "ESPB";
		case 3:
			return "Godina studija";
		case 4:
			return "Semestar";
		default:
			return "";
		}
	}

}
