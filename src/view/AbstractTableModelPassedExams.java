package view;

import javax.swing.table.AbstractTableModel;

import model.Grade;
import model.Student;
import model.StudentDataBase;

public class AbstractTableModelPassedExams extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		int index = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(StudentTable.getInstance().convertRowIndexToModel(index));
		return selectedStudent.getPassedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int index = StudentTable.getInstance().getSelectedRow();
		Student selectedStudent = StudentDataBase.getInstance().getStudent(StudentTable.getInstance().convertRowIndexToModel(index));
		Grade grade = selectedStudent.getPassedExams().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return grade.getCourse().getCourseID();
		case 1:
			return grade.getCourse().getCourseName();
		case 2:
			return grade.getCourse().getEctsPoints();
		case 3:
			return grade.getGrade();
		case 4:
			return grade.getDateOfExam();
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
			return MainFrame.getInstance().getResourceBundle().getString("grade");
		case 4:
			return MainFrame.getInstance().getResourceBundle().getString("date");
		default:
			return "";
		}
	}
}
