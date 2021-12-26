package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.StudentEditDialog;

public class StudentEditInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
				checkDate() && 
				checkAddressStreet() &&
				checkAddressNumber() &&
				checkAddressCity() &&
				checkAddressCountry() &&
				//checkIndexNumber() &&
				checkYearOfEnrolment() &&
				checkCurrentYearOfStudies() &&
				checkPhoneNumber() 
				//&& checkEmail()
				) 
			{
				StudentEditDialog.confirm.setEnabled(true);
			}
			else {
				StudentEditDialog.confirm.setEnabled(false);
			}
	
	}
	
	private static boolean checkEmpty() {
		if(StudentEditDialog.firstName.getText().isEmpty() ||
				StudentEditDialog.lastName.getText().isEmpty() ||
				StudentEditDialog.dateOfBirth.getText().isEmpty() ||
				StudentEditDialog.addressStreet.getText().isEmpty() ||
				StudentEditDialog.addressNumber.getText().isEmpty() ||
				StudentEditDialog.addressCity.getText().isEmpty() ||
				StudentEditDialog.addressCountry.getText().isEmpty() ||
				StudentEditDialog.phoneNumber.getText().isEmpty() ||
				StudentEditDialog.email.getText().isEmpty() ||
				StudentEditDialog.indexNumber.getText().isEmpty() ||
				StudentEditDialog.yearOfEnrolment.getText().isEmpty() ||
				StudentEditDialog.currentYearOfStudies.getText().isEmpty()
				) 
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate date = LocalDate.parse(StudentEditDialog.dateOfBirth.getText(), formatter);
			return true;
			
		} catch (DateTimeParseException e) {
			return false;
		}
		
	}
	

	private static boolean checkAddressStreet() {
		Pattern streetPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = streetPattern.matcher(StudentEditDialog.addressStreet.getText());
		return matcher.matches();
	}
	private static boolean checkAddressNumber() {
		Pattern numberPattern = Pattern.compile("[0-9]*");
		Matcher matcher = numberPattern.matcher(StudentEditDialog.addressNumber.getText());
		return matcher.matches();
	}
	private static boolean checkAddressCity() {
		Pattern cityPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = cityPattern.matcher(StudentEditDialog.addressCity.getText());
		return matcher.matches();
	}
	private static boolean checkAddressCountry() {
		Pattern countryPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ ]+");
		Matcher matcher = countryPattern.matcher(StudentEditDialog.addressCountry.getText());
		return matcher.matches();
	}
	
	private static boolean checkIndexNumber() {
		//proveri dal valja
		Pattern indexNumberPattern = Pattern.compile("[A-Z]+ [0-9]+//[0-9]+");
		Matcher matcher = indexNumberPattern.matcher(StudentEditDialog.indexNumber.getText());
		return matcher.matches();
	}
	
	private static boolean checkPhoneNumber() {
		//[+]1234567890....
		Pattern phoneNumberPattern = Pattern.compile("[+]?[0-9]+");
		Matcher matcher = phoneNumberPattern.matcher(StudentEditDialog.phoneNumber.getText());
		return matcher.matches();
	}
	
	private static boolean checkEmail() {
		Pattern emailPattern = Pattern.compile("[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]+");
		Matcher matcher = emailPattern.matcher(StudentEditDialog.email.getText());
		return matcher.matches();
	}
	
	private static boolean checkYearOfEnrolment() {
		try{
		    int year = Integer.parseInt(StudentEditDialog.yearOfEnrolment.getText());
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
		    int year = Integer.parseInt(StudentEditDialog.currentYearOfStudies.getText());
		    if(year >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}

}
