package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorAddDialog;

public class ProfessorAddInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkAddressNumber() &&
			checkPhoneNumber() 
			) {
			/*System.out.println(checkEmpty());
			System.out.println(checkDate());
			System.out.println(checkAddress(ProfessorAddDialog.homeAddress.getText()) );
			System.out.println(checkAddress(ProfessorAddDialog.officeAddress.getText()) );
			System.out.println(checkIdNumber());
			System.out.println(checkYearsOfExperience());
			System.out.println(checkPhoneNumber());
			System.out.println(checkEmail());*/
			ProfessorAddDialog.confirm.setEnabled(true);
		}
		else {
			ProfessorAddDialog.confirm.setEnabled(false);
		}
	}
	
	private static boolean checkEmpty() {
		if(ProfessorAddDialog.firstName.getText().isEmpty() ||
		   ProfessorAddDialog.lastName.getText().isEmpty() ||
		   ProfessorAddDialog.dateOfBirth.getText().isEmpty() ||
		   ProfessorAddDialog.homeCity.getText().isEmpty() ||
		   ProfessorAddDialog.homeStreet.getText().isEmpty() ||
		   ProfessorAddDialog.homeNumber.getText().isEmpty() ||
		   ProfessorAddDialog.homeCountry.getText().isEmpty() ||
		   ProfessorAddDialog.officeCity.getText().isEmpty() ||
		   ProfessorAddDialog.officeStreet.getText().isEmpty() ||
		   ProfessorAddDialog.officeNumber.getText().isEmpty() ||
		   ProfessorAddDialog.officeCountry.getText().isEmpty() ||
		   ProfessorAddDialog.phoneNumber.getText().isEmpty() ||
		   ProfessorAddDialog.email.getText().isEmpty() ||
		   ProfessorAddDialog.idNumber.getText().isEmpty() ||
		   ProfessorAddDialog.yearsOfExperience.getText().isEmpty())
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
												//YYYY-[M]M-[D]D
		/*Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]");
		Matcher matcher = datePattern.matcher(ProfessorAddDialog.dateOfBirth.getText());
		return matcher.matches();*/
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate date = LocalDate.parse(ProfessorAddDialog.dateOfBirth.getText(), formatter);
			return true;
			
		} catch (DateTimeParseException e) {
			return false;
		}
		
	}
	private static boolean checkAddressNumber() {
		try {
			Integer.parseInt(ProfessorAddDialog.homeNumber.getText());
			Integer.parseInt(ProfessorAddDialog.officeNumber.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	private static boolean checkIdNumber() {
													//only numbers allowed
		Pattern idNumberPattern = Pattern.compile("[0-9]+");
		Matcher matcher = idNumberPattern.matcher(ProfessorAddDialog.idNumber.getText());
		return matcher.matches();
	}
	private static boolean checkYearsOfExperience() {
		try{
		    int years = Integer.parseInt(ProfessorAddDialog.yearsOfExperience.getText());
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
		Matcher matcher = phoneNumberPattern.matcher(ProfessorAddDialog.phoneNumber.getText());
		return matcher.matches();
	}
	private static boolean checkEmail() {
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\".\"_]+@[a-zA-Z0-9]+[.][a-zA-Z0-9]+");
		Matcher matcher = emailPattern.matcher(ProfessorAddDialog.email.getText());
		return matcher.matches();
	}
}
