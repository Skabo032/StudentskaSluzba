package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ProfessorAddDialog;

public class ProfessorAddInputVerifier {
	public static void verify() {
		if(!checkEmpty() && 
			checkDate() && 
			checkAddress(ProfessorAddDialog.homeAddress.getText()) &&
			checkAddress(ProfessorAddDialog.officeAddress.getText()) &&
			checkIdNumber() &&
			checkYearsOfExperience() &&
			checkPhoneNumber() && 
			checkEmail()
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
		   ProfessorAddDialog.homeAddress.getText().isEmpty() ||
		   ProfessorAddDialog.phoneNumber.getText().isEmpty() ||
		   ProfessorAddDialog.email.getText().isEmpty() ||
		   ProfessorAddDialog.officeAddress.getText().isEmpty() ||
		   ProfessorAddDialog.idNumber.getText().isEmpty() ||
		   ProfessorAddDialog.yearsOfExperience.getText().isEmpty())
			return true;
		else {
			return false;
		}
	}
	
	private static boolean checkDate() {
												//YYYY-[M]M-[D]D
		Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]");
		Matcher matcher = datePattern.matcher(ProfessorAddDialog.dateOfBirth.getText());
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
		Pattern emailPattern = Pattern.compile("[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]+");
		Matcher matcher = emailPattern.matcher(ProfessorAddDialog.email.getText());
		return matcher.matches();
	}
}
