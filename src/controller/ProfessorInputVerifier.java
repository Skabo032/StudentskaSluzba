package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorDialog;

public class ProfessorInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkPhoneNumber() 
			//&& checkAddressNumber()
			//&& checkEmail()
			) {
			ProfessorDialog.confirm.setEnabled(true);
		}
		else {
			ProfessorDialog.confirm.setEnabled(false);
		}
	}
	
	private static boolean checkEmpty() {
		if(ProfessorDialog.firstName.getText().isEmpty() ||
			ProfessorDialog.lastName.getText().isEmpty() ||
			ProfessorDialog.dateOfBirth.getText().isEmpty() ||
			ProfessorDialog.phoneNumber.getText().isEmpty() ||
			ProfessorDialog.email.getText().isEmpty() ||
			ProfessorDialog.idNumber.getText().isEmpty() ||
			ProfessorDialog.yearsOfExperience.getText().isEmpty() ||
			ProfessorDialog.homeCity.getText().isEmpty() ||
			ProfessorDialog.homeStreet.getText().isEmpty() ||
			ProfessorDialog.homeNumber.getText().isEmpty() ||
			ProfessorDialog.homeCountry.getText().isEmpty() ||
			ProfessorDialog.officeCity.getText().isEmpty() ||
			ProfessorDialog.officeStreet.getText().isEmpty() ||
			ProfessorDialog.officeNumber.getText().isEmpty() ||
			ProfessorDialog.officeCountry.getText().isEmpty() )
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate date = LocalDate.parse(ProfessorDialog.dateOfBirth.getText(), formatter);
			return true;
			
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	private static boolean checkAddressNumber() {
		try {
			Integer.parseInt(ProfessorDialog.homeNumber.getText());
			Integer.parseInt(ProfessorDialog.officeNumber.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	private static boolean checkIdNumber() {
													//only numbers allowed
		Pattern idNumberPattern = Pattern.compile("[0-9]+");
		Matcher matcher = idNumberPattern.matcher(ProfessorDialog.idNumber.getText());
		return matcher.matches();
	}
	private static boolean checkYearsOfExperience() {
		try{
		    int years = Integer.parseInt(ProfessorDialog.yearsOfExperience.getText());
		    if(years >= 0)
		    	return true;
		    else
		    	return false;
		} catch(NumberFormatException exception) {
		    return false;
		}
	}
	private static boolean checkPhoneNumber() {
													//[+]1234567890....
		Pattern phoneNumberPattern = Pattern.compile("[+]?[0-9]+");
		Matcher matcher = phoneNumberPattern.matcher(ProfessorDialog.phoneNumber.getText());
		return matcher.matches();
	}
	private static boolean checkEmail() {
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\".\"_]+@[a-zA-Z0-9]+[.][a-zA-Z0-9]+");
		Matcher matcher = emailPattern.matcher(ProfessorDialog.email.getText());
		return matcher.matches();
	}
}
