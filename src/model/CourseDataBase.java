package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Course.Semester;
import model.Professor.Title;

public class CourseDataBase {
	
	private static CourseDataBase instance = null;
	private List<Course> courses;
	private List<String> columnNames;
	
	public static CourseDataBase getInstance() {
		if(instance == null)
			instance = new CourseDataBase();
		return instance;
	}
	
	private CourseDataBase() {
		this.columnNames = new ArrayList<String>();
		
		this.columnNames.add("Sifra predmeta");
		this.columnNames.add("Naziv predmeta");
		this.columnNames.add("ESPB");
		this.columnNames.add("Godina");
		this.columnNames.add("Semestar");
		
		this.courses = new ArrayList<Course>();
		Professor p1 = ProfessorDataBase.getInstance().getProfessor(0);
		Course c1 = new Course(1, "OISISI", Semester.SUMMER, 3, p1, 5, null, null );
		this.courses.add(c1);
		
		
		
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
	public void removeCourse(int id) {
		for(Course c : courses) {
			if(c.getCourseID() == id) {
				courses.remove(c);
				break;
			}
		}
	}
	
	public boolean addCourse(Course c) {
		for (Course course : courses) {
			if(course.getCourseID() == c.getCourseID())
				return false;
		}
		return this.courses.add(c);
	}
	
	public Course getCourse(int i) {
		try {
			return courses.get(i);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean existsById(int courseId) {
		for (Course course : courses) {
			//if(course.getCourseID().equals(courseId))
			if(course.getCourseID() == courseId)
				return true;
		}
		return false;
	}
	
	public boolean editCourse(int rowNum, Course c) {
		return courses.set(rowNum, c) != null;
	}
	
	public boolean removeCourseByRowNum(int i) {
		return courses.remove(i) != null;
	}
}
