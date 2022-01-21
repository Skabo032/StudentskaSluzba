package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Course.Semester;
import model.Professor.Title;

public class ProfessorDataBase {
	private static ProfessorDataBase instance = null;
	
	public static ProfessorDataBase getInstance() {
		if(instance == null)
			instance = new ProfessorDataBase();
		return instance;
	}
	
	private List<Professor> professors;
	
	private ProfessorDataBase() {
		
		List<Course> profCourses1 = new ArrayList<Course>();
		profCourses1.add(CourseDataBase.getInstance().getCourse(0));
		profCourses1.add(CourseDataBase.getInstance().getCourse(1));
		profCourses1.add(CourseDataBase.getInstance().getCourse(2));
		profCourses1.add(CourseDataBase.getInstance().getCourse(3));
		List<Course> profCourses4 = new ArrayList<Course>();
		profCourses4.add(CourseDataBase.getInstance().getCourse(7));
		profCourses4.add(CourseDataBase.getInstance().getCourse(8));
		profCourses4.add(CourseDataBase.getInstance().getCourse(9));
		List<Course> profCourses5 = new ArrayList<Course>();
		profCourses5.add(CourseDataBase.getInstance().getCourse(11));
		profCourses5.add(CourseDataBase.getInstance().getCourse(12));
		profCourses5.add(CourseDataBase.getInstance().getCourse(13));
		List<Course> profCourses6 = new ArrayList<Course>();
		profCourses6.add(CourseDataBase.getInstance().getCourse(14));
		profCourses6.add(CourseDataBase.getInstance().getCourse(15));
		List<Course> profCourses16 = new ArrayList<Course>();
		profCourses16.add(CourseDataBase.getInstance().getCourse(24));
		profCourses16.add(CourseDataBase.getInstance().getCourse(28));
		List<Course> profCourses17 = new ArrayList<Course>();
		profCourses17.add(CourseDataBase.getInstance().getCourse(25));
		profCourses17.add(CourseDataBase.getInstance().getCourse(27));
		List<Course> profCourses18 = new ArrayList<Course>();
		profCourses18.add(CourseDataBase.getInstance().getCourse(26));
		
		this.professors = new ArrayList<Professor>();
		Address ak1 = new Address("Šafarikova","2","Novi Sad","Srbija");
		Address ak2 = new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address ak3 = new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Address ak4 = new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address ak5 = new Address("Nikole Pašića","2d","Kikinda","Srbija");
		Address ak6 = new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address ak7 = new Address("Tolstojeva","31","Novi Sad","Srbija");
		Address ak8 = new Address("Marićeva","11","Kragujevac","Srbija");
		Address ak9 = new Address("Stražilovska","3","Beograd","Srbija");
		Address ak10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		Address ak11 = new Address("Bulevar Kralja Petra","2d","Niš","Srbija");
		Address ak12 = new Address("Knez Mihajlova","22","Beograd","Srbija");
		
		Address ap10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		
		professors.add(new Professor("123123123",	"Milos"	,"Nikolic",	LocalDate.parse("12.12.1965.",formatter)	,ak1,	"021/356-785",	"milos.nikolic@mailinator.com",	ap10,	30,	Title.REDOVNI_PROFESOR,new ArrayList<Course>()));
		professors.add(new Professor("321321321",	"Nikola"	,"Mirkovic",	LocalDate.parse("01.01.1978.",formatter)	,ak2,	"021/368-456",	"nikola.mirkovic@mailinator.com",	ap10,	22,	Title.REDOVNI_PROFESOR,profCourses1));
		professors.add(new Professor("456456456",	"Ilija"	,"Petkovic",	LocalDate.parse("03.09.1988.",formatter)	,ak3,	"021/215-314",	"ilija.petkovic@mailinator.com",	ap10,	22,	Title.VANREDNI_PROFESOR,new ArrayList<Course>()));
		professors.add(new Professor("789789789",	"Mitar"	,"Petrovic",	LocalDate.parse("25.07.1976.",formatter)	,ak4,	"021/884-640",	"mitar.petrovic@mailinator.com",	ap10,	27,	Title.VANREDNI_PROFESOR,new ArrayList<Course>()));
		professors.add(new Professor("100100144",	"Vasa"	,"Micic",	LocalDate.parse("14.02.1970.",formatter)	,ak5,	"021/212-114",	"vasa.micic@mailinator.com",	ap10,	24,	Title.DOCENT,profCourses4));
		professors.add(new Professor("200020244",	"Srdjan"	,"Miletic",	LocalDate.parse("20.04.1966.",formatter)	,ak6,	"021/978-225",	"srdjan.miletic@mailinator.com",	ap10,	31,	Title.DOCENT,profCourses5));
		professors.add(new Professor("559585632",	"Branislav"	,"Mihajlovic",	LocalDate.parse("28.06.1980.",formatter)	,ak7,	"021/778-323",	"branislav.mihajlovic@mailinator.com",	ap10,	13,	Title.REDOVNI_PROFESOR	,profCourses6));
		professors.add(new Professor("334968855",	"Marko"	,"Marković",	LocalDate.parse("31.01.1985.",formatter)	,ak8,	"021/899-659",	"marko.markovic@mailinator.com",	ap10,	17,	Title.REDOVNI_PROFESOR	,new ArrayList<Course>()));
		professors.add(new Professor("730703654",	"Miloš"	,"Milaković",	LocalDate.parse("21.09.1975.",formatter)	,ak9,	"021/122-326",	"milos.milakovic@mailinator.com",	ap10,	12,	Title.VANREDNI_PROFESOR	,new ArrayList<Course>()));
		professors.add(new Professor("600378644",	"Lazar"	,"Bratić",	LocalDate.parse("13.11.1973.",formatter)	,ak10,	"021/156-326",	"lazar.bratic@mailinator.com",	ap10,	3,	Title.VANREDNI_PROFESOR	,new ArrayList<Course>()));
		professors.add(new Professor("158496152",	"Ljeposava"	,"Dražić",	LocalDate.parse("11.08.1964.",formatter)	,ak11,	"021/888-156",	"ljeposava.drazic@mailinator.com",	ap10,	31,	Title.DOCENT	,new ArrayList<Course>()));
		professors.add(new Professor("777348595",	"Miroljub"	,"Dragić",	LocalDate.parse("02.03.1959.",formatter)	,ak12,	"021/456-125",	"miroljub.dragic@mailinator.com",	ap10,	42,	Title.DOCENT	,new ArrayList<Course>()));
		professors.add(new Professor("721254363",	"Bogdan"	,"Rekavić",	LocalDate.parse("23.06.1977.",formatter)	,ak6,	"021/886-455",	"bogdan.rekavic@mailinator.com",	ap10,	18,	Title.VANREDNI_PROFESOR	,new ArrayList<Course>()));
		professors.add(new Professor("225533448",	"Stanka"	,"Milić",	LocalDate.parse("03.03.1991.",formatter)	,ak3,	"021/945-155",	"stanka.milic@mailinator.com",	ap10,	7,	Title.DOCENT	,new ArrayList<Course>()));
		professors.add(new Professor("111555888",	"Milica"	,"Vuković",	LocalDate.parse("18.10.1967.",formatter)	,ak8,	"021/746-659",	"milica.vukovic@mailinator.com",	ap10,	14,	Title.VANREDNI_PROFESOR	,new ArrayList<Course>()));
		professors.add(new Professor("300300344",	"Miša"	,"Mišić",	LocalDate.parse("20.10.1969.",formatter)	,ak1,	"021/489-326",	"misa.misic@mailinator.com",	ap10,	19,	Title.DOCENT	,new ArrayList<Course>()));
		professors.add(new Professor("400400444",	"Branko"	,"Maricić",	LocalDate.parse("18.01.1973.",formatter)	,ak2,	"021/487-265",	"branko.maricic@mailinator.com",	ap10,	22,	Title.DOCENT	,profCourses16));
		professors.add(new Professor("500500544",	"Branislav"	,"Lukovic",	LocalDate.parse("08.04.1982.",formatter)	,ak3,	"021/159-478",	"branislav.lukovic@mailinator.com",	ap10,	9,	Title.REDOVNI_PROFESOR	,profCourses17));
		professors.add(new Professor("600600644",	"Branimir"	,"Obradović",	LocalDate.parse("07.01.1979.",formatter)	,ak1,	"021/922-333",	"branimir.obradovic@mailinator.com",	ap10,	17,	Title.DOCENT	,profCourses18));
		
		
		
		/*Address a1 = new Address("abc", "5", "abv", "ab");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate date = LocalDate.parse("11.11.2020.", formatter);
		
		Professor p1 = new Professor("Peric", "Pera", date, a1, "123", "email@asd.ac", a1, "22221", Title.PROFESSOR, 5, null);

		Professor p2 = new Professor("Ivanovic", "Ivan", date, a1, "123", "email@asd.ac", a1, "22222", Title.PROFESSOR, 5, null);
		
		ArrayList<Course> predaje1 = new ArrayList<Course>();
		Course c1 = new Course(1, "OISISI", Semester.SUMMER, 3, p1, 5, null, null );
		predaje1.add(c1);
		p1.setCourses(predaje1);
		
		ArrayList<Course> predaje2 = new ArrayList<Course>();
		p2.setCourses(predaje2);
//		predaje1.add(c1);
//		for(int i = 0; i< CourseDataBase.getInstance().getRowCount();i++)
//		{
//			if(CourseDataBase.getInstance().getCourse(i).getCourseProffesor().getIdNumber().equals("22221"))
//			{
//				predaje1.add(CourseDataBase.getInstance().getCourse(i));
//			}
//		}
		//p1.setCourses(predaje1);
		
		this.professors.add(p1);
		this.professors.add(p2);*/
//		for(int i = 0; i < CourseDataBase.getInstance().getRowCount(); i++) 
//		{
//			Course c = CourseDataBase.getInstance().getCourse(i);
//			for(int j = 0; j < professors.size(); j++)
//			{
//				if(professors.get(j).equals(c.getCourseProffesor())) {
//					professors.get(j).addCourse(c);
//				}
//			}
//		}
	}
	
	public int getColumnCount() {
		return 4;
	}
	public int getRowCount() {
		return professors.size();
	}
	public Object getValueAt(int row, int column) {
		Professor professor = this.professors.get(row);
		switch (column) {
		case 0:
			return professor.getFirstName();
		case 1:
			return professor.getLastName();
		case 2:
			return professor.getTitle();
		case 3:
			return professor.getEmail();
		default:
			return null;
		}
	}
	public Professor getProfessor(int i) {
		try {
			return professors.get(i);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public List<Professor> getProfessors(){
		return professors;
	}	
	public Professor getProfessorById(String idNumber) {
		for (Professor prof: professors) {
			if(prof.getIdNumber().equals(idNumber)) {
				return prof;
			}
		}
		return null;
	}
	
	public boolean addProfessor(Professor p) {
		//return this.professors.add(p);
		for (Professor prof : professors) {
			if(prof.getIdNumber().equals(p.getIdNumber()))
				return false;
		}
		return this.professors.add(p);
	}
	public void removeProfessorById(String idNumber) {
		for (Professor prof : professors) {
			if(prof.getIdNumber().equals(idNumber)) {
				professors.remove(prof);
				break;
			}
		}
	}
	public boolean removeProfessorByRowNum(int i) {
		return professors.remove(i) != null;
	}
	
	public boolean existsById(String idNumber) {
		for (Professor prof : professors) {
			if(prof.getIdNumber().equals(idNumber))
				return true;
		}
		return false;
	}
	
	public boolean editProfessor(Professor p, int index) {
		return professors.set(index, p) != null;
		
	}
}
