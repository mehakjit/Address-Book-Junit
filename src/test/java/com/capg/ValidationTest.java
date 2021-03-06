package com.capg;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.service.implementation.Validation;

public class ValidationTest {
 
	Validation validation = new Validation();
	
	@Test
	public void When_First_Name_Is_Valid_Return_True() {
		boolean result = validation.firstNameValidation("Mehak");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_First_Name_Is_Invalid_Return_False() {
		boolean result = validation.firstNameValidation("mehak");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = Exception.class)
	public void When_First_Name_Is_Null_Return_True(){
		validation.firstNameValidation(null);
	}
	@Test
	public void When_Last_Name_Is_Valid_Return_True() {
		boolean result = validation.lastNameValidation("Mehak");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_Last_Name_Is_Invalid_Return_False() {
		boolean result = validation.lastNameValidation("mehak");
		Assert.assertEquals(false, result);
	}
	@Test(expected = Exception.class)
	public void When_Last_Name_Is_Null_Return_True(){
		validation.lastNameValidation(null);
	}
	@Test
	public void When_State_Is_Valid_Return_True() {
		boolean result = validation.stateValidation("Andra Pradesh");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_State_Is_Invalid_Return_False() {
		boolean result = validation.stateValidation("Andra pradesh");
		Assert.assertEquals(false, result);
	}
	@Test(expected = Exception.class)
	public void When_State_Is_Null_Return_True(){
		validation.stateValidation(null);
	}
	@Test
	public void When_City_Is_Valid_Return_True() {
		boolean result = validation.cityValidation("Ambala Cantt");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_City_Is_Invalid_Return_False() {
		boolean result = validation.cityValidation("ambala Cantt");
		Assert.assertEquals(false, result);
	}
	@Test(expected = Exception.class)
	public void When_City_Is_Null_Return_True(){
		validation.cityValidation(null);
	}
	@Test
	public void When_Zip_Is_Valid_Return_True() {
		boolean result = validation.zipValidation("123 456");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_Zip_Is_Invalid_Return_False() {
		boolean result = validation.zipValidation("012456");
		Assert.assertEquals(false, result);
	}
	@Test(expected = Exception.class)
	public void When_Zip_Is_Null_Return_True(){
		validation.zipValidation(null);
	}
	@Test
	public void When_Phone_Number_Is_Valid_Return_True() {
		boolean result = validation.phoneNumberValidation("91 9456175436");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_Phone_Number_Is_Invalid_Return_False() {
		boolean result = validation.phoneNumberValidation("9456175436");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = Exception.class)
	public void When_Phone_Number_Is_Null_Return_True(){
		validation.phoneNumberValidation(null);
	}
	@Test
	public void When_Email_Is_Valid_Return_True() {
		boolean result = validation.emailValidation("msingh@gmail.com");
		Assert.assertEquals(true, result);
	}
	@Test
	public void When_Email_Is_Invalid_Return_False() {
		boolean result = validation.emailValidation("ama@gmail@.com");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = Exception.class)
	public void When_Email_Is_Null_Return_True(){
		validation.emailValidation(null);
	}
}
