package com.capgemini.service;

public interface Validate {
	boolean firstNameValidation(String firstName);
	boolean lastNameValidation(String lastName);
	boolean stateValidation(String state);
	boolean cityValidation(String city);
	boolean phoneNumberValidation(String phoneNumber);
	boolean emailValidation(String email);
	boolean zipValidation(String zip);
}
