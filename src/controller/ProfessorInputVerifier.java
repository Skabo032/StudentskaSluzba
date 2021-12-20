package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorDialog;

public class ProfessorInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkAddress(ProfessorDialog.homeAddress.getText()) &&
			checkAddress(ProfessorDialog.officeAddress.getText()) &&
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkPhoneNumber() && 
			checkEmail()
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
		   ProfessorDialog.homeAddress.getText().isEmpty() ||
		   ProfessorDialog.phoneNumber.getText().isEmpty() ||
		   ProfessorDialog.email.getText().isEmpty() ||
		   ProfessorDialog.officeAddress.getText().isEmpty() ||
		   ProfessorDialog.idNumber.getText().isEmpty() ||
		   ProfessorDialog.yearsOfExperience.getText().isEmpty())
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
												//YYYY-[M]M-[D]D
		Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9]?[0-9]-[0-9]?[0-9]");
		Matcher matcher = datePattern.matcher(ProfessorDialog.dateOfBirth.getText());
		return matcher.matches();
	}
	private static boolean checkAddress(String address) {
													//street,number,city,country
		Pattern addressPattern = Pattern.compile("[a-zA-ZšđčćžŠĐČĆŽ]+,[0-9]*,[a-zA-ZšđčćžŠĐČĆŽ]+,[a-zA-ZšđčćžŠĐČĆŽ]+");
		Matcher matcher = addressPattern.matcher(address);
		return matcher.matches();
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
		Pattern emailPattern = Pattern.compile("[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]+");
		Matcher matcher = emailPattern.matcher(ProfessorDialog.email.getText());
		return matcher.matches();
	}
}
