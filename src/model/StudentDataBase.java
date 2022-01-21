package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class StudentDataBase {
	private static StudentDataBase instance = null;
	
	public static StudentDataBase getInstance() {
		if(instance == null)
			instance = new StudentDataBase();
		return instance;
	}
	
	private List<Student> students;
	
	private StudentDataBase() {
		
		this.students = new ArrayList<Student>();
		Address l1 = new Address("Šafarikova","2","Novi Sad","Srbija");
		Address l2 = new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address l3 = new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Address l4 = new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address l5 = new Address("Nikole Pašića","2d","Kikinda","Srbija");
		Address l6 = new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address l7 = new Address("Tolstojeva","31","Novi Sad","Srbija");
		Address l8 = new Address("Marićeva","11","Kragujevac","Srbija");
		Address l9 = new Address("Stražilovska","3","Beograd","Srbija");
		Address l10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		Address l11 = new Address("Bulevar Kralja Petra","2d","Niš","Srbija");
		Address l12 = new Address("Knez Mihajlova","22","Beograd","Srbija");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		
		
		
		students.add(new Student("RA 2/2020",  "Marko","Milosevic",1,	LocalDate.parse("12.03.2001.",formatter),	l1	  , "021/333-555","marko.milosevic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Grade>()));
		students.add(new Student("RA 3/2019",  "Marija","Milić",2,	LocalDate.parse("12.01.2000.",formatter),	l2	  , "021/555-2222","marija.milic@mailinator.com",Status.S,	2019,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 3/2017" , "Nikola","Nikolic",1,	LocalDate.parse("30.08.2001.",formatter),	l3	  , "021/135-463","nikola.nikolic@mailinator.com",Status.B,	2017,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 134/2015",	  "Pera","Peric",3,	LocalDate.parse("07.06.1995.",formatter),	l4	  , " 021/903-463","pera.peric@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 5/2019",  "Sofija","Ilic",3,	LocalDate.parse("06.05.1999.",formatter),	l5	  , " 021/731-067","sofija.ilic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 8/2018",	  "Martina","Lukic",3,	LocalDate.parse("16.05.1999.",formatter),	l6	  , "011/4333-800","martina.lukic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 10/2017",	  "Stojan","Stojakovic",1,	LocalDate.parse("19.10.2001.",formatter),	l7	  , "011/3130-007","stojan.stojakovic@mailinator.com",Status.B,	2017,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 12/2017", 	  "Milan","Milanovic",2,	LocalDate.parse("02.11.2000.",formatter),	l8	  , "015/313-061","milan.milanovic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 16/2019",	  "Miroslav","Milic",2,	LocalDate.parse("11.10.2000.",formatter),	l9	  , "021/351-091","miroslav.milic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 21/2015",	  "Stefan","Gojic",3,	LocalDate.parse("01.05.1999.",formatter),	l10	 , "015/324-500","stefan.gojic@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 9/2020",  "Anastasija","Jokic",3,	LocalDate.parse("11.07.1999.",formatter),	l11	 , "011/2333-900","anastasija.jokic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 4/2017" , "Bogdan","Bogdanovic",3,	LocalDate.parse("23.07.1999.",formatter),	l12	 , "021/231-231","bogdan.bogdanovic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 30/2019",	  "Ana","Dabovic",1,	LocalDate.parse("12.12.2001.",formatter),	null,	"014/303-007","ana.dabovic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 1/2020",  "Mika","Mikic",1,	LocalDate.parse("05.11.2001.",formatter),	l2	  , "015/101-909","mika.mikic@mailinator.com",Status.S,	2020,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 11/2018",	  "Jovan","Deretic",4,	LocalDate.parse("10.09.1998.",formatter),	l3	  , "002/200-300","jovan.deretic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(), new ArrayList<Grade>()));	
		students.add(new Student("RA 12/2018",	  "Nikola","Miskovic",4,	LocalDate.parse("03.08.1998.",formatter),	l4	  , "022/123-456","nikola.miskovic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(), new ArrayList<Grade>()));	
		students.add(new Student("RA 13/2018",	  "Martin","Stojanovic",4,	LocalDate.parse("01.05.1998.",formatter),	null,	"024/321-775","martin.stojanovic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 14/2018",    "Tomislav","Novakovic",4,	LocalDate.parse("25.02.1996.",formatter),	l6	  , "011/1188-379","tomislav.novakovic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 154/2016",	  "Lena","Ivic",4,	LocalDate.parse("11.05.1998.",formatter),	l7	  , "024/333-555","lena.ivic@mailinator.com",Status.B,	2016,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 23/2020"	, "Jovan","Lazic",1,	LocalDate.parse("22.01.2001.",formatter),	l8	  , "025/1189-479","jovan.lazic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 1/2019" , "Isidora","Mikic",2,	LocalDate.parse("31.12.2000.",formatter),	l9	  , "011/1122-366","isidora.mikic@mailinator.com ",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("SW 4/2014" , "Vladimir","Ilic",4,	LocalDate.parse("31.08.1998.",formatter),	l10	 , "0211122-367","vladimir.ilic@mailinator.com",Status.B,	2014,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("SW 17/2015",	  "Mirko","Alicic",3,	LocalDate.parse("21.07.1999.",formatter),	l11	 , "012/1122-368","mirko.alicic@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("SW 17/2016",	  "Milisav","Perković",4,	LocalDate.parse("28.09.1998.",formatter),	l12	 , "012/1122-369","milisav.pejkovic@mailinator.com",Status.S,	2016,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("SW 27/2018",	  "Purisa","Djordjević",2,	LocalDate.parse("29.02.2000.",formatter),	l3	  , "011/1543-370","purisa.djordjevic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("RA 226/2017",	  "Mikica","Kovacević",3,	LocalDate.parse("23.03.1999.",formatter),	l5	  , "011/1992-371","mikica.kovacevic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		students.add(new Student("SW 12/2021",	  "Miloš","Milić",1,	LocalDate.parse("21.10.2001.",formatter),	l2	  , "011/8172-372","milos.milic@mailinator.com",Status.S,	2021,new ArrayList<Grade>(),new ArrayList<Grade>()));	
		
		
		
		List<Grade> student4 = new ArrayList<Grade>();
		student4.add(new Grade(students.get(3), CourseDataBase.getInstance().getCourse(1), 5, null));
		student4.add(new Grade(students.get(3), CourseDataBase.getInstance().getCourse(3), 5, null));
		students.get(3).setUnfinishedExams(student4);
		List<Grade> student17 = new ArrayList<Grade>();
		student17.add(new Grade(students.get(16), CourseDataBase.getInstance().getCourse(14), 5, null));
		students.get(16).setUnfinishedExams(student17);
		List<Grade> student18 = new ArrayList<Grade>();
		student18.add(new Grade(students.get(17), CourseDataBase.getInstance().getCourse(14), 5, null));
		students.get(17).setUnfinishedExams(student18);
		List<Grade> student22 = new ArrayList<Grade>();
		student22.add(new Grade(students.get(21), CourseDataBase.getInstance().getCourse(17), 5, null));
		student22.add(new Grade(students.get(21), CourseDataBase.getInstance().getCourse(18), 5, null));
		students.get(21).setUnfinishedExams(student22);
		List<Grade> student23 = new ArrayList<Grade>();
		student23.add(new Grade(students.get(22), CourseDataBase.getInstance().getCourse(17), 5, null));
		student23.add(new Grade(students.get(22), CourseDataBase.getInstance().getCourse(18), 5, null));
		students.get(22).setUnfinishedExams(student23);
		List<Grade> student24 = new ArrayList<Grade>();
		student24.add(new Grade(students.get(23), CourseDataBase.getInstance().getCourse(17), 5, null));
		student24.add(new Grade(students.get(23), CourseDataBase.getInstance().getCourse(18), 5, null));
		students.get(23).setUnfinishedExams(student24);
		List<Grade> student26 = new ArrayList<Grade>();
		student26.add(new Grade(students.get(25), CourseDataBase.getInstance().getCourse(17), 5, null));
		student26.add(new Grade(students.get(25), CourseDataBase.getInstance().getCourse(18), 5, null));
		students.get(25).setUnfinishedExams(student26);
		
		
		List<Grade> studGrade4 = new ArrayList<Grade>();
		studGrade4.add(new Grade(students.get(3),CourseDataBase.getInstance().getCourse(4),10,LocalDate.parse("12.12.2017.",formatter)));
		studGrade4.add(new Grade(students.get(3),CourseDataBase.getInstance().getCourse(2),9,LocalDate.parse("10.11.2019.",formatter)));
		studGrade4.add(new Grade(students.get(3),CourseDataBase.getInstance().getCourse(0),8,LocalDate.parse("11.11.2020.",formatter)));
		students.get(3).setPassedExams(studGrade4);
		List<Grade> studGrade2 = new ArrayList<Grade>();
		studGrade2.add(new Grade(students.get(1),CourseDataBase.getInstance().getCourse(0),10,LocalDate.parse("20.11.2020.",formatter)));
		studGrade2.add(new Grade(students.get(1),CourseDataBase.getInstance().getCourse(4),10,LocalDate.parse("30.10.2021.",formatter)));
		students.get(1).setPassedExams(studGrade2);
		List<Grade> studGrade15 = new ArrayList<Grade>();
		studGrade15.add(new Grade(students.get(14),CourseDataBase.getInstance().getCourse(14),7,LocalDate.parse("10.01.2021.",formatter)));
		studGrade15.add(new Grade(students.get(14),CourseDataBase.getInstance().getCourse(15),10,LocalDate.parse("01.01.2021.",formatter)));
		//getStudWithKey(15).setGrade(studGrade15);
		students.get(14).setPassedExams(studGrade15);
		List<Grade> studGrade16 = new ArrayList<Grade>();
		studGrade16.add(new Grade(students.get(15),CourseDataBase.getInstance().getCourse(14),10,LocalDate.parse("12.01.2018.",formatter)));
		studGrade16.add(new Grade(students.get(15),CourseDataBase.getInstance().getCourse(15),9,LocalDate.parse("04.02.2019.",formatter)));
		//getStudWithKey(16).setGrade(studGrade16);
		students.get(15).setPassedExams(studGrade16);
		
		/*List<Grade> passedExams1 = new ArrayList<Grade>();
		//passedExams.add(new Grade(student, course, grade, dateOfExam))
		List<Grade> unfinishedExams1 = new ArrayList<Grade>();
		Address a1 = new Address("fafs", "5", "sds", "fsaf");
		//Student s1 = new Student("Najjaci", "Lik", LocalDate.now(), a1, "06633333", "bezveze@gmail.com", "RA 420/2019", 3, 3, Status.B, 9.12, passedExams, unfinishedExams);
		Student s1 = new Student();
		s1.setFirstName("Najjaci");
		s1.setLastName("Lik");
		s1.setDateOfBirth(LocalDate.now());
		s1.setAddress(a1);
		s1.setEmail("bezveze@gmail.com");
		s1.setIndexNumber("RA 420/2019");
		s1.setPhoneNumber("4234234234");
		s1.setAvgGrade(9.12);
		s1.setStatus(Status.B);
		s1.setCurrentYearOfStudies(3);
		s1.setYearOfEnrolment(2019);
		Professor p1 = new Professor("22222", "Pera", "Peric",  LocalDate.now(), a1, "123", "email@asd.ac", a1, 5, Title.REDOVNI_PROFESOR, null);

		Course c1 = CourseDataBase.getInstance().getCourse(0);
		unfinishedExams1.add(new Grade(s1, c1, 5, LocalDate.now()));
		s1.setUnfinishedExams(unfinishedExams1);
		Course c2 = CourseDataBase.getInstance().getCourse(1);
		passedExams1.add(new Grade(s1, c2, 7, LocalDate.now()));
		s1.setPassedExams(passedExams1);
		
		
		Student s2 = new Student();
		s2.setFirstName("Matija");
		s2.setLastName("Jovic");
		s2.setDateOfBirth(LocalDate.now());
		s2.setAddress(a1);
		s2.setEmail("bezveze@gmail.com");
		s2.setIndexNumber("RA 20/2019");
		s2.setPhoneNumber("111");
		s2.setAvgGrade(9.12);
		s2.setStatus(Status.B);
		s2.setCurrentYearOfStudies(3);
		s2.setYearOfEnrolment(2019);
		List<Grade> passedExams2 = new ArrayList<Grade>();
		passedExams2.add(new Grade(s2, c1, 5, LocalDate.now()));
		List<Grade> unfinishedExams2 = new ArrayList<Grade>();
		unfinishedExams2.add(new Grade(s2, c2, 5, LocalDate.now()));
		s2.setPassedExams(passedExams2);
		s2.setUnfinishedExams(unfinishedExams2);

		this.students.add(s1);
		this.students.add(s2);*/
	}
	
	public int getColumnCount() {
		return 6;
	}
	public int getRowCount() {
		return students.size();
	}
	
	public Object getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndexNumber();
		case 1:
			return student.getFirstName();
		case 2:
			return student.getLastName();
		case 3:
			return student.getCurrentYearOfStudies();
		case 4:
			return student.getStatus();
		case 5:
			return student.calcAvgGrade();
		default:
			return null;
		}
	}
	
	public List<Student> getStudents(){
		return this.students;
	}
	
	public boolean addStudent(Student s) {
		for (Student stud : students) {
			if(stud.getIndexNumber().equals(s.getIndexNumber()))
				return false;
		}
		return this.students.add(s);
	}
	
	public Student getStudent(int i) {
		try {
			return students.get(i);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean editStudent(int rowNum, Student s) {
		return students.set(rowNum, s) != null;
	}
	
	public boolean existsById(String indexNumber) {
		for (Student stud : students) {
			if(stud.getIndexNumber().equals(indexNumber))
				return true;
		}
		return false;
	}
	
	public boolean removeStudentByRowNum(int i) {
		return students.remove(i) != null;
	}

}
