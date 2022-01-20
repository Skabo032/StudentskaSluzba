package view;

import javax.swing.table.AbstractTableModel;

import model.Course;
import model.Professor;
import model.ProfessorDataBase;

public class AbstractTableModelProfessorTeaching extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int getRowCount() {
		int index = ProfessorTable.getInstance().getSelectedRow();
		Professor selectedProf = ProfessorDataBase.getInstance().getProfessor(ProfessorTable.getInstance().convertRowIndexToModel(index));
		return selectedProf.getCourses().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int index = ProfessorTable.getInstance().getSelectedRow();
		Professor selectedProf = ProfessorDataBase.getInstance().getProfessor(ProfessorTable.getInstance().convertRowIndexToModel(index));
		Course course = selectedProf.getCourses().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return course.getCourseID();
		case 1:
			return course.getCourseName();
		case 2:
			return course.getYearOfStudy();
		case 3:
			return course.getSemester();
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
			return MainFrame.getInstance().getResourceBundle().getString("yearOfStudies");
		case 3:
			return MainFrame.getInstance().getResourceBundle().getString("semester");
		default:
			return "";
		}
	}

}
