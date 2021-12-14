package model;

import java.util.ArrayList;
import java.util.List;

public class CourseDataBase {
	
	private static CourseDataBase instance = null;
	private List<Course> courses;
	private List<String> columnNames;
	
	private CourseDataBase() {
		this.columnNames = new ArrayList<String>();
		
		this.columnNames.add("Sifra predmeta");
		this.columnNames.add("Naziv predmeta");
		this.columnNames.add("ESPB");
		this.columnNames.add("Godina");
		this.columnNames.add("Semestar");
		
		this.courses = new ArrayList<Course>();
		Course c1 = new Course();
		this.courses.add(c1);
		
	}
	public static CourseDataBase getInstance() {
		if(instance == null)
			instance = new CourseDataBase();
		return instance;
	}
	public int getColumnCount() {
		return columnNames.size();
	}
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
	public int getRowCount() {
		return courses.size();
	}
	public Object getValueAt(int row, int column) {
		Course course = this.courses.get(row);
		switch (column) {
		case 0:
			return course.getCourseID();
		case 1:
			return course.getCourseName();
		case 2:
			return course.getEctsPoints();
		case 3:
			return course.getYearOfStudy();
		case 4:
			return course.getSemester();
		default:
			return null;
		}
	}
}
