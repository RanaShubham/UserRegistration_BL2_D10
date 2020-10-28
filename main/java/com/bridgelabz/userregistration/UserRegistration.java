package com.bridgelabz.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.userregistration.InvalidUserDetailException.ExceptionType;

@FunctionalInterface
interface MatchGivenString
{
	public boolean matchGivenString(String stringToMatch, String regexToMatchWith);
}

public class UserRegistration {
	
	static Scanner input = new Scanner (System.in).useDelimiter("\n");
	
	//Variables
	static String firstName;
	static String lastName;
	static String email;
	static String phoneNumber;
	static String password;
	
	//Regex patterns
	static String FIRST_NAME = "^[A-Z]{1}[a-z]{2,}$";
	static String LAST_NAME = "^[A-Z]{1}[a-z]{2,}$";
	static String EMAIL = "^[[a-z]]{1,}([._+-][0-9]{1,})*[0-9]{0,}@([0-9]|[[a-z]]){1,}[.][[a-z]]{2,4}([.][[a-z]]{2,4}){0,1}$";
	static String PHONE_NUMBER = "^(91 ){0,1}[7-9][0-9]{9}$";
	static String PASSWORD = "\"^(?=.*[A-Z](?=.*\\\\d))(?=.*[\\\\@\\\\$\\\\!\\\\%\\\\*\\\\?\\\\&])[A-Za-z\\\\d\\\\@\\\\$\\\\!\\\\%\\\\*\\\\?\\\\&]{8,}$\";";
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to user registration program");
		

		System.out.println("Enter first name");
		UserRegistration.firstName = input.next();
		System.out.println("Enter last name");
		UserRegistration.lastName = input.next();
		System.out.println("Enter email");
		UserRegistration.email = input.next();
		System.out.println("Enter mobile number");
		UserRegistration.phoneNumber = input.next();
		System.out.println("Enter password");
		UserRegistration.password = input.next();
		
		check.matchGivenString(UserRegistration.password, UserRegistration.PASSWORD);
		check.matchGivenString(UserRegistration.email, UserRegistration.EMAIL);
		check.matchGivenString(UserRegistration.phoneNumber, UserRegistration.PHONE_NUMBER);
		check.matchGivenString(UserRegistration.lastName, UserRegistration.LAST_NAME);
		check.matchGivenString(UserRegistration.firstName, UserRegistration.FIRST_NAME);
		
	}
	
	//Checking phoneNumber
	static MatchGivenString check = (stringToMatch, regexToMatchWith) -> {

		try {
			Pattern pattern = Pattern.compile(regexToMatchWith);
			Matcher match = pattern.matcher(stringToMatch);
			if (stringToMatch.isBlank()) {
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY, "This field cannot be empty");
			}
			return match.find();
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_NULL, "This field cannot be null");
		}
	
	};
}
