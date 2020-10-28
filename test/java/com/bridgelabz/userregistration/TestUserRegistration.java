package com.bridgelabz.userregistration;

import org.junit.Assert;
import org.junit.Test;

public class TestUserRegistration {
	
	static UserRegistration registartion  = new UserRegistration();
	
	//FirstName test cases_______________________________________________________________________
	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() 
	{
		boolean result = UserRegistration.check.matchGivenString("Shubham",UserRegistration.FIRST_NAME);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenFirstName_WhenImproper_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("shubham",UserRegistration.FIRST_NAME);
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenFirstName_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString("",UserRegistration.FIRST_NAME);
	}

	
	//LastName test cases_______________________________________________________________________
	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue()
	{
		boolean result = UserRegistration.check.matchGivenString("Rana",UserRegistration.LAST_NAME);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenLastName_WhenImporper_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("rana",UserRegistration.LAST_NAME);
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenLastName_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString("",UserRegistration.LAST_NAME);
	}
	
	
	//Password test cases_______________________________________________________________________
	
	@Test
	public void givenPassword_WhenNoCapitalChar_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("abcd123",UserRegistration.PASSWORD);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoSpecialChar_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("Abcd1234",UserRegistration.PASSWORD);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoNumberinPassword_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("Abcdefgh",UserRegistration.PASSWORD);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenMoreThanOneScpecialChar_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("Abcd12#$",UserRegistration.PASSWORD);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenPasswordLengthShortThan8_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("Abd12#$",UserRegistration.PASSWORD);
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPassword_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString("",UserRegistration.PASSWORD);
	}
	
	//PhoneNumber test cases_______________________________________________________________________
	@Test
	public void givenPhoneNumber_WhenProper_ShouldReturnTrue()
	{
		boolean result = UserRegistration.check.matchGivenString("91 8249167495",UserRegistration.PHONE_NUMBER);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenWithoutCountryCode_ShouldReturnTrue()
	{
		boolean result = UserRegistration.check.matchGivenString("8249167495",UserRegistration.PHONE_NUMBER);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenNoSpaceAfterCountryCode_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("918249167495",UserRegistration.PHONE_NUMBER);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenImproper_ShouldReturnFalse()
	{
		boolean result = UserRegistration.check.matchGivenString("495",UserRegistration.PHONE_NUMBER);
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPhoneNumber_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString("",UserRegistration.PHONE_NUMBER);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPhoneNumber_WhenNull_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString(null,UserRegistration.PHONE_NUMBER);
	}
	
	//Email exception test cases_____________________________________________________________
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenEmail_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString("",UserRegistration.EMAIL);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenEmail_WhenNull_ShouldThrowInvalidUserDetailException()
	{
		UserRegistration.check.matchGivenString(null,UserRegistration.EMAIL);
	}
}

