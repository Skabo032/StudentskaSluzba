package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorEditDialog;

public class ProfessorEditInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkAddress(ProfessorEditDialog.homeAddress.getText()) &&
			checkAddress(ProfessorEditDialog.officeAddress.getText()) &&
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkPhoneNumber() && 
			checkEmail()
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
				ProfessorEditDialog.homeAddress.getText().isEmpty() ||
				ProfessorEditDialog.phoneNumber.getText().isEmpty() ||
				ProfessorEditDialog.email.getText().isEmpty() ||
				ProfessorEditDialog.officeAddress.getText().isEmpty() ||
				ProfessorEditDialog.idNumber.getText().isEmpty() ||
				ProfessorEditDialog.yearsOfExperience.getText().isEmpty())
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
												//YYYY-[M]M-[D]D
		Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]");
		Matcher matcher = datePattern.matcher(ProfessorEditDialog.dateOfBirth.getText());
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
		Pattern emailPattern = Pattern.compile("[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]+");
		Matcher matcher = emailPattern.matcher(ProfessorEditDialog.email.getText());
		return matcher.matches();
	}
}
