package controller;


import view.CourseAddDialog;


public class CourseAddInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
				//checkCourseId() &&
				checkYearOfStudy() &&
				checkEctsPoints()
				) 
			{
				CourseAddDialog.confirm.setEnabled(true);
			}
			else {
				CourseAddDialog.confirm.setEnabled(false);
			}
	
	}
	
	private static boolean checkEmpty() {
		if(CourseAddDialog.courseId.getText().isEmpty() ||
				CourseAddDialog.courseName.getText().isEmpty() ||
				CourseAddDialog.yearOfStudy.getText().isEmpty() ||
				CourseAddDialog.professorId.getText().isEmpty() ||
				CourseAddDialog.ectsPoints.getText().isEmpty()
				) 
			return true;
		else {
			return false;
		}
	}
	
	
//	private static boolean checkCourseId() {
//		try{
//		    int id = Integer.parseInt(CourseAddDialog.courseId.getText());
//		    if(id >= 0)
//		    	return true;
//		    else
//		    	return false;
//		} catch(NumberFormatException exception) {
//		    return false;
//		}
//	}
	
	private static boolean checkYearOfStudy() {
		try{
		    int id = Integer.parseInt(CourseAddDialog.yearOfStudy.getText());
		    if(id >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	
	private static boolean checkEctsPoints() {
		try{
		    int id = Integer.parseInt(CourseAddDialog.ectsPoints.getText());
		    if(id >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	
//	private static boolean checkProfessorId() {
//		try{
//		    int id = Integer.parseInt(CourseAddDialog.courseId.getText());
//		    if(id >= 0)
//		    	return true;
//		    else
//		    	return false;
//		} catch(NumberFormatException exception) {
//		    return false;
//		}
//	}
}
