package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Course.Semester;
import model.Professor.Title;

public class CourseDataBase {
	
	private static CourseDataBase instance = null;
	private List<Course> courses;
	
	public static CourseDataBase getInstance() {
		if(instance == null)
			instance = new CourseDataBase();
		return instance;
	}
	
	private CourseDataBase() {
		
		Address ak1 = new Address("Šafarikova","2","Novi Sad","Srbija");
		Address ak2 = new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address ak3 = new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Address ak4 = new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address ak6 = new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address ak7 = new Address("Tolstojeva","31","Novi Sad","Srbija");
		
		Address ap10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		Professor p1 = new Professor("321321321",	"Nikola"	,"Mirkovic",	LocalDate.parse("01.01.1978.",formatter)	,ak2,	"021/368-456",	"nikola.mirkovic@mailinator.com",	ap10,	22,	Title.REDOVNI_PROFESOR,new ArrayList<Course>());
		Professor p4 = new Professor("789789789",	"Mitar"	,"Petrovic",	LocalDate.parse("25.07.1976.",formatter)	,ak4,	"021/884-640",	"mitar.petrovic@mailinator.com",	ap10,	27,	Title.VANREDNI_PROFESOR,new ArrayList<Course>());
		Professor p5 = new Professor("200020244",	"Srdjan"	,"Miletic",	LocalDate.parse("20.04.1966.",formatter)	,ak6,	"021/978-225",	"srdjan.miletic@mailinator.com",	ap10,	31,	Title.DOCENT,new ArrayList<Course>());
		Professor p6 = new Professor("559585632",	"Branislav"	,"Mihajlovic",	LocalDate.parse("28.06.1980.",formatter)	,ak7,	"021/778-323",	"branislav.mihajlovic@mailinator.com",	ap10,	13,	Title.REDOVNI_PROFESOR	,new ArrayList<Course>());
		Professor p16 = new Professor("400400444",	"Branko"	,"Maricić",	LocalDate.parse("18.01.1973.",formatter)	,ak2,	"021/487-265",	"branko.maricic@mailinator.com",	ap10,	22,	Title.DOCENT	,new ArrayList<Course>());
		Professor p17 = new Professor("500500544",	"Branislav"	,"Lukovic",	LocalDate.parse("08.04.1982.",formatter)	,ak3,	"021/159-478",	"branislav.lukovic@mailinator.com",	ap10,	9,	Title.REDOVNI_PROFESOR	,new ArrayList<Course>());
		Professor p18 = new Professor("600600644",	"Branimir"	,"Obradović",	LocalDate.parse("07.01.1979.",formatter)	,ak1,	"021/922-333",	"branimir.obradovic@mailinator.com",	ap10,	17,	Title.DOCENT	,new ArrayList<Course>());
		
		
		
		this.courses = new ArrayList<Course>();
		courses.add(new Course("p1"    ,"osnove programiranja"	    	    ,1,	7	,p1,Semester.WINTER));
		courses.add(new Course("p2"    ,"statistika"		        	    ,3,	8	,p1,Semester.SUMMER));
		courses.add(new Course("p3"    ,"algoritmi i strukture podataka"	,2,	9	,p1,Semester.SUMMER));
		courses.add(new Course("p4"    ,"LPRS"				                ,3,	7	,p1,Semester.WINTER));
		courses.add(new Course("p5"    ,"matematika"			            ,1,	11	,null,Semester.SUMMER));
		courses.add(new Course("p6"    ,"xml i web servisi"	           		,4,	6	,null,Semester.SUMMER));
		courses.add(new Course("p7"    ,"Metode optimizacije"		        ,3,	6	,null	,Semester.WINTER));
		courses.add(new Course("p8"    ,"osnove elektortehnike"		    	,1,	11	,p4,Semester.SUMMER));
		courses.add(new Course("p9"    ,"Sociologija"			            ,1,	10	,p4,Semester.WINTER));
		courses.add(new Course("p10"	,"Filozofija"		            	,1,	4	,p4,Semester.WINTER));
		courses.add(new Course("p11"	,"ORT"				                ,2,	7	,null	,Semester.SUMMER));
		courses.add(new Course("p12"	,"NANS"				                ,2,	5	,p5,Semester.SUMMER));
		courses.add(new Course("p13"	,"Organizacija podataka"		    ,2,	7	,p5,Semester.WINTER));
		courses.add(new Course("p14"	,"Baze podataka"			        ,2,	6	,p5,Semester.WINTER));
		courses.add(new Course("p15"	,"paralelno programiranje"		    ,2,	8	,p6,Semester.WINTER));
		courses.add(new Course("p16"	,"konkurentno programiranje"	    ,2,	9	,p6,Semester.SUMMER));
		courses.add(new Course("p17"	,"Operativni sistemi"		        ,2,	8	,null	,Semester.SUMMER));
		courses.add(new Course("p18"	,"Algebra"				            ,1,	15	,null	,Semester.WINTER));
		courses.add(new Course("p19"	,"Diskretna matematika"		        ,3,	14	,null	,Semester.SUMMER));
		courses.add(new Course("ps20"	,"Upravljacki sistemi"		        ,3,	8	,null	,Semester.SUMMER));
		courses.add(new Course("ps21"	,"Osnovi elektronike"		        ,2,	7	,null	,Semester.WINTER));
		courses.add(new Course("ps22"	,"Slucajni procesi"		            ,4,	9	,null	,Semester.SUMMER));
		courses.add(new Course("ps23"	,"Racunarstvo visokih performansi"	,4,	10	,null	,Semester.SUMMER));
		courses.add(new Course("p24"	,"Analiza 1"			            ,1,	20	,null	,Semester.WINTER));
		courses.add(new Course("it25"	,"Informaciona bezbednost"		    ,4,	9	,p16,Semester.SUMMER));
		courses.add(new Course("it26"	,"Elektronsko placanje"		        ,3,	8	,p17,Semester.WINTER));
		courses.add(new Course("it27"	,"Distribuirani sistemi"		    ,4,	6	,p18,Semester.SUMMER));
		courses.add(new Course("p28"	,"Projektovanje softvera"		    ,3,	5	,p17,Semester.WINTER));
		courses.add(new Course("p29"	,"Informacioni sistemi"		        ,4,	6	,p16,Semester.WINTER));
		courses.add(new Course("p30"	,"Masinsko ucenje"			        ,4,	7	,null	,Semester.SUMMER));
		
		/*Professor p1 = ProfessorDataBase.getInstance().getProfessor(0);
		Course c1 = new Course("1", "OISISI", Semester.SUMMER, 3, p1, 5, null, null );
		Course c2 = new Course("2", "NANS", Semester.SUMMER, 3, p1, 5, null, null );
		Course c3 = new Course("3", "BAZE2 ", Semester.SUMMER, 3, p1, 5, null, null );

		Professor p1 = ProfessorDataBase.getInstance().getProfessor(0);
		Professor p2 = ProfessorDataBase.getInstance().getProfessor(1);
		Course c1 = new Course(1, "OISISI", Semester.SUMMER, 3, p1, 5, null, null );
		Course c2 = new Course(2, "NANS", Semester.SUMMER, 3, p2, 5, null, null );
		Course c3 = new Course(3, "BAZE2 ", Semester.SUMMER, 3, p1, 5, null, null );
		this.courses.add(c1);
		this.courses.add(c2);
		this.courses.add(c3);*/			
		
	}

	public int getColumnCount() {
		return 5;
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
	public List<Course> getCourses(){
		return this.courses;
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
