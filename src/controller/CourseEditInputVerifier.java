package controller;

import view.CourseEditDialog;

public class CourseEditInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
				//checkCourseId() &&
				checkYearOfStudy() &&
				checkEctsPoints()
				) 
			{
				CourseEditDialog.confirm.setEnabled(true);
			}
			else {
				CourseEditDialog.confirm.setEnabled(false);
			}
	
	}
	
	private static boolean checkEmpty() {
		if(CourseEditDialog.courseId.getText().isEmpty() ||
				CourseEditDialog.courseName.getText().isEmpty() ||
				CourseEditDialog.yearOfStudy.getText().isEmpty() ||
				CourseEditDialog.ectsPoints.getText().isEmpty()
				) 
			return true;
		else {
			return false;
		}
	}
	
	
	private static boolean checkCourseId() {
		try{
		    int id = Integer.parseInt(CourseEditDialog.courseId.getText());
		    if(id >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	
	private static boolean checkYearOfStudy() {
		try{
		    int id = Integer.parseInt(CourseEditDialog.yearOfStudy.getText());
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
		    int id = Integer.parseInt(CourseEditDialog.ectsPoints.getText());
		    if(id >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	
	private static boolean checkProfessorId() {
		try{
		    int id = Integer.parseInt(CourseEditDialog.courseId.getText());
		    if(id >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
}
