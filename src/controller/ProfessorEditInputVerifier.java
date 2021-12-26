package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorEditDialog;

public class ProfessorEditInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkPhoneNumber() &&
			checkAddressNumber()
			//&& checkEmail()
			) {
			ProfessorEditDialog.confirm.setEnabled(true);
		}
		else {
			ProfessorEditDialog.confirm.setEnabled(false);
		}
	}
	
	private static boolean checkEmpty() {
		if(ProfessorEditDialog.firstName.getText().isEmpty() ||
			ProfessorEditDialog.lastName.getText().isEmpty() ||
			ProfessorEditDialog.dateOfBirth.getText().isEmpty() ||
			ProfessorEditDialog.phoneNumber.getText().isEmpty() ||
			ProfessorEditDialog.email.getText().isEmpty() ||
			ProfessorEditDialog.idNumber.getText().isEmpty() ||
			ProfessorEditDialog.yearsOfExperience.getText().isEmpty() ||
			ProfessorEditDialog.homeCity.getText().isEmpty() ||
			ProfessorEditDialog.homeStreet.getText().isEmpty() ||
			ProfessorEditDialog.homeNumber.getText().isEmpty() ||
			ProfessorEditDialog.homeCountry.getText().isEmpty() ||
			ProfessorEditDialog.officeCity.getText().isEmpty() ||
			ProfessorEditDialog.officeStreet.getText().isEmpty() ||
			ProfessorEditDialog.officeNumber.getText().isEmpty() ||
			ProfessorEditDialog.officeCountry.getText().isEmpty() )
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
												//YYYY-[M]M-[D]D
		/*Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]");
		Matcher matcher = datePattern.matcher(ProfessorEditDialog.dateOfBirth.getText());
		return matcher.matches();*/
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate date = LocalDate.parse(ProfessorEditDialog.dateOfBirth.getText(), formatter);
			return true;
			
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	private static boolean checkAddressNumber() {
		try {
			Integer.parseInt(ProfessorEditDialog.homeNumber.getText());
			Integer.parseInt(ProfessorEditDialog.officeNumber.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	private static boolean checkIdNumber() {
													//only numbers allowed
		Pattern idNumberPattern = Pattern.compile("[0-9]+");
		Matcher matcher = idNumberPattern.matcher(ProfessorEditDialog.idNumber.getText());
		return matcher.matches();
	}
	private static boolean checkYearsOfExperience() {
		try{
		    int years = Integer.parseInt(ProfessorEditDialog.yearsOfExperience.getText());
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
		Matcher matcher = phoneNumberPattern.matcher(ProfessorEditDialog.phoneNumber.getText());
		return matcher.matches();
	}
	private static boolean checkEmail() {
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\".\"_]+@[a-zA-Z0-9]+[.][a-zA-Z0-9]+");
		Matcher matcher = emailPattern.matcher(ProfessorEditDialog.email.getText());
		return matcher.matches();
	}
}
