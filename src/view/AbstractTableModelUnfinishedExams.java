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
		Student selectedStudent = StudentDataBase.getInstance().getStudent(StudentTable.getInstance().convertRowIndexToModel(index));
		if(selectedStudent.getUnfinishedExams() == null)
			return 0;
		return selectedStudent.getUnfinishedExams().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		int index = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(StudentTable.getInstance().convertRowIndexToModel(index));
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
			return MainFrame.getInstance().getResourceBundle().getString("courseId");
		case 1:
			return MainFrame.getInstance().getResourceBundle().getString("courseName");
		case 2:
			return MainFrame.getInstance().getResourceBundle().getString("espb");
		case 3:
			return MainFrame.getInstance().getResourceBundle().getString("yearOfStudies");
		case 4:
			return MainFrame.getInstance().getResourceBundle().getString("semester");
		default:
			return "";
		}
	}

}
