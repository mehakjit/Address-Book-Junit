package com.capgemini.service.implementation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.service.Validate;

public class Validation implements Validate{
	public final String firstName = "^[A-Z]{1}[a-z]{2,}$";
	public final String lastName = "^[A-Z]{1}[a-z]{2,}$";
	public final String state = "^[A-Z]{1}[a-z]{2,}\s?([A-Z]{1}[a-z]{2,})?$";
	public final String city = "^[A-Z]{1}[a-z]{2,}\s?([A-Z]{1}[a-z]{2,})?$";
	public final String zip = "^[1-9]{1}[0-9]{2}\s?{0,1}[0-9]{3}$";
	public final String phoneNumber = "^[1-9][0-9]\s[1-9]{1}[0-9]{9}$";
	public final String email = "^[a-z]+([-+-.]{0,1}[a-zA-z0-9]{1,})?@[a-z]{2,}\\.[a-z]{2,4}(\\.[a-z]{2})?$";

	public boolean validate(String pattern1,String matcher1) {
		Pattern pattern = Pattern.compile(pattern1); 
		Matcher matcher = pattern.matcher(matcher1);
		return matcher.find();
	}

	@Override
	public boolean firstNameValidation(String firstName) {
		return validate(this.firstName,firstName);
	}
	@Override
	public boolean lastNameValidation(String lastName) {
		return validate(this.lastName,lastName);
	}
	@Override
	public boolean stateValidation(String state) {
		return validate(this.state,state);
	}
	@Override
	public boolean cityValidation(String city) {
		return validate(this.city,city);
	}
	@Override
	public boolean phoneNumberValidation(String phoneNumber) {
		return validate(this.phoneNumber,phoneNumber);
	}
	@Override
	public boolean emailValidation(String email) {
		return validate(this.email,email);
	}
	@Override
	public boolean zipValidation(String zip) {
		return validate(this.zip,zip);
	}
}
