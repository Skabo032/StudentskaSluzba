package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.StudentAddDialog;

public class StudentAddInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
				checkDate() && 
				checkAddressStreet() &&
				//checkAddressNumber() &&
				checkAddressCity() &&
				checkAddressCountry() &&
				//checkIndexNumber() &&
				checkYearOfEnrolment() &&
				checkCurrentYearOfStudies() &&
				checkPhoneNumber() 
				//&& checkEmail()
				) 
			{
				StudentAddDialog.confirm.setEnabled(true);
			}
			else {
				StudentAddDialog.confirm.setEnabled(false);
			}
	
	}
	
	private static boolean checkEmpty() {
		if(StudentAddDialog.firstName.getText().isEmpty() ||
				StudentAddDialog.lastName.getText().isEmpty() ||
				StudentAddDialog.dateOfBirth.getText().isEmpty() ||
				StudentAddDialog.addressStreet.getText().isEmpty() ||
				StudentAddDialog.addressNumber.getText().isEmpty() ||
				StudentAddDialog.addressCity.getText().isEmpty() ||
				StudentAddDialog.addressCountry.getText().isEmpty() ||
				StudentAddDialog.phoneNumber.getText().isEmpty() ||
				StudentAddDialog.email.getText().isEmpty() ||
				StudentAddDialog.indexNumber.getText().isEmpty() ||
				StudentAddDialog.yearOfEnrolment.getText().isEmpty() ||
				StudentAddDialog.currentYearOfStudies.getText().isEmpty()
				) 
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			LocalDate.parse(StudentAddDialog.dateOfBirth.getText(), formatter);
			return true;
			
		} catch (DateTimeParseException e) {
			return false;
		}
		
	}
	

	private static boolean checkAddressStreet() {
		Pattern streetPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = streetPattern.matcher(StudentAddDialog.addressStreet.getText());
		return matcher.matches();
	}
//	private static boolean checkAddressNumber() {
//		Pattern numberPattern = Pattern.compile("[0-9]*");
//		Matcher matcher = numberPattern.matcher(StudentAddDialog.addressNumber.getText());
//		return matcher.matches();
//	}
	private static boolean checkAddressCity() {
		Pattern cityPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = cityPattern.matcher(StudentAddDialog.addressCity.getText());
		return matcher.matches();
	}
	private static boolean checkAddressCountry() {
		Pattern countryPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = countryPattern.matcher(StudentAddDialog.addressCountry.getText());
		return matcher.matches();
	}
	
//	private static boolean checkIndexNumber() {
//		//proveri dal valja
//		Pattern indexNumberPattern = Pattern.compile("[A-Z]+ [0-9]+//[0-9]+");
//		Matcher matcher = indexNumberPattern.matcher(StudentAddDialog.indexNumber.getText());
//		return matcher.matches();
//	}
//	
	private static boolean checkPhoneNumber() {
		//[+]1234567890....
		Pattern phoneNumberPattern = Pattern.compile("[+]?[0-9]+");
		Matcher matcher = phoneNumberPattern.matcher(StudentAddDialog.phoneNumber.getText());
		return matcher.matches();
	}
	
//	private static boolean checkEmail() {
//		Pattern emailPattern = Pattern.compile("[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]+");
//		Matcher matcher = emailPattern.matcher(StudentAddDialog.email.getText());
//		return matcher.matches();
//	}
	
	private static boolean checkYearOfEnrolment() {
		try{
		    int year = Integer.parseInt(StudentAddDialog.yearOfEnrolment.getText());
		    if(year >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	
	private static boolean checkCurrentYearOfStudies() {
		try{
		    int year = Integer.parseInt(StudentAddDialog.currentYearOfStudies.getText());
		    if(year >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	

}
