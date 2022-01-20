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
		courses.add(new Course("p1"    ,"osnove programiranja"	    	    ,1,	7	,ProfessorDataBase.getInstance().getProfessor(2),Semester.WINTER));
		courses.add(new Course("p2"    ,"statistika"		        	    ,3,	8	,ProfessorDataBase.getInstance().getProfessor(2),Semester.SUMMER));
		courses.add(new Course("p3"    ,"algoritmi i strukture podataka"	,2,	9	,ProfessorDataBase.getInstance().getProfessor(2),Semester.SUMMER));
		courses.add(new Course("p4"    ,"LPRS"				                ,3,	7	,ProfessorDataBase.getInstance().getProfessor(2),Semester.WINTER));
		courses.add(new Course("p5"    ,"matematika"			            ,1,	11	,null,Semester.SUMMER));
		courses.add(new Course("p6"    ,"xml i web servisi"	           		,4,	6	,null,Semester.SUMMER));
		courses.add(new Course("p7"    ,"Metode optimizacije"		        ,3,	6	,null	,Semester.WINTER));
		courses.add(new Course("p8"    ,"osnove elektortehnike"		    	,1,	11	,ProfessorDataBase.getInstance().getProfessor(5),Semester.SUMMER));
		courses.add(new Course("p9"    ,"Sociologija"			            ,1,	10	,ProfessorDataBase.getInstance().getProfessor(5),Semester.WINTER));
		courses.add(new Course("p10"	,"Filozofija"		            	,1,	4	,ProfessorDataBase.getInstance().getProfessor(5),Semester.WINTER));
		courses.add(new Course("p11"	,"ORT"				                ,2,	7	,null	,Semester.SUMMER));
		courses.add(new Course("p12"	,"NANS"				                ,2,	5	,ProfessorDataBase.getInstance().getProfessor(6),Semester.SUMMER));
		courses.add(new Course("p13"	,"Organizacija podataka"		    ,2,	7	,ProfessorDataBase.getInstance().getProfessor(6),Semester.WINTER));
		courses.add(new Course("p14"	,"Baze podataka"			        ,2,	6	,ProfessorDataBase.getInstance().getProfessor(6),Semester.WINTER));
		courses.add(new Course("p15"	,"paralelno programiranje"		    ,2,	8	,ProfessorDataBase.getInstance().getProfessor(7),Semester.WINTER));
		courses.add(new Course("p16"	,"konkurentno programiranje"	    ,2,	9	,ProfessorDataBase.getInstance().getProfessor(7),Semester.SUMMER));
		courses.add(new Course("p17"	,"Operativni sistemi"		        ,2,	8	,null	,Semester.SUMMER));
		courses.add(new Course("p18"	,"Algebra"				            ,1,	15	,null	,Semester.WINTER));
		courses.add(new Course("p19"	,"Diskretna matematika"		        ,3,	14	,null	,Semester.SUMMER));
		courses.add(new Course("ps20"	,"Upravljacki sistemi"		        ,3,	8	,null	,Semester.SUMMER));
		courses.add(new Course("ps21"	,"Osnovi elektronike"		        ,2,	7	,null	,Semester.WINTER));
		courses.add(new Course("ps22"	,"Slucajni procesi"		            ,4,	9	,null	,Semester.SUMMER));
		courses.add(new Course("ps23"	,"Racunarstvo visokih performansi"	,4,	10	,null	,Semester.SUMMER));
		courses.add(new Course("p24"	,"Analiza 1"			            ,1,	20	,null	,Semester.WINTER));
		courses.add(new Course("it25"	,"Informaciona bezbednost"		    ,4,	9	,ProfessorDataBase.getInstance().getProfessor(17),Semester.SUMMER));
		courses.add(new Course("it26"	,"Elektronsko placanje"		        ,3,	8	,ProfessorDataBase.getInstance().getProfessor(18),Semester.WINTER));
		courses.add(new Course("it27"	,"Distribuirani sistemi"		    ,4,	6	,ProfessorDataBase.getInstance().getProfessor(19),Semester.SUMMER));
		courses.add(new Course("p28"	,"Projektovanje softvera"		    ,3,	5	,ProfessorDataBase.getInstance().getProfessor(18),Semester.WINTER));
		courses.add(new Course("p29"	,"Informacioni sistemi"		        ,4,	6	,ProfessorDataBase.getInstance().getProfessor(17),Semester.WINTER));
		courses.add(new Course("p30"	,"Masinsko ucenje"			        ,4,	7	,null	,Semester.SUMMER));
		
		/*Professor p1 = ProfessorDataBase.getInstance().getProfessor(0);
		Course c1 = new Course("1", "OISISI", Semester.SUMMER, 3, p1, 5, null, null );
		Course c2 = new Course("2", "NANS", Semester.SUMMER, 3, p1, 5, null, null );
		Course c3 = new Course("3", "BAZE2 ", Semester.SUMMER, 3, p1, 5, null, null );
		this.courses.add(c1);
		this.courses.add(c2);
		this.courses.add(c3);*/			
		
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
	public void removeCourse(String id) {
		for(Course c : courses) {
			if(c.getCourseID().equals(id)) {
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
	
	public Course getCourseByName(String name) {
		try {
			for(Course kurs: courses)
			{
				if(kurs.getCourseName().equals(name))
					return kurs;
			}
			return null;
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean existsById(String courseId) {
		for (Course course : courses) {
			//if(course.getCourseID().equals(courseId))
			if(course.getCourseID().equals(courseId))
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
