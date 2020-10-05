package com.capgemini.service.implementation;

import java.util.Scanner;

import com.capgemini.dto.Contacts;
import com.capgemini.service.ContactService;
import com.capgemini.service.Validate;

public class ContactServiceImpl implements ContactService{
	
	Scanner sc = new Scanner(System.in);
	
	public void createPerson() {
		
		System.out.print("Enter First Name : " + "\n" + "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.\n");
		String firstName;
		for (;;) {
			try {
				firstName = sc.nextLine();
				Validate validate = new Validation();
				if (validate.firstNameValidation(firstName)) {
					System.out.println("Validated First Name");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		
		System.out.print("Enter Last Name : "+ "\n" + "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.\n");
		String lastName;
		for (;;) {
			try {
				lastName = sc.nextLine();
				Validate validate = new Validation();
				if (validate.lastNameValidation(lastName)) {
					System.out.println("Validated Last Name");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.");
				}
			} catch (Exception e) {
				throw e;
			}
		}

		System.out.print("Enter Address : ");
		String address = sc.nextLine();
		
		System.out.print("Enter City : " + "\n"+"Inside city name all words should start with first alphabet as Upper Case followed by all lower case \n" );
		String city;
		for(;;) {
			try {
			city=sc.nextLine();
			Validate validate = new Validation();
			if (validate.cityValidation(city)) {
				System.out.println("Validated City");
				break;
			} 
			else {
				System.out.println("Wrong Input, Enter again"+"\n"+"Inside city name all words should start with first alphabet as Upper Case followed by all lower case");				
			}
			} catch (Exception e) {
				throw e;
			}
		}
		
		System.out.print("Enter State : "+"\n"+"Inside state name all words should start with first alphabet as Upper Case followed by all lower case");
		String state;
		for(;;) {
			try {
			state=sc.nextLine();
			Validate validate = new Validation();
			if (validate.stateValidation(state)) {
				System.out.println("Validated City");
				break;
			} 
			else {
				System.out.println("Wrong Input, Enter again"+"\n"+"Inside state name all words should start with first alphabet as Upper Case followed by all lower case");				
			}
		} catch (Exception e) {
			throw e;
		}
		}
		
		System.out.print("Enter Zip : ");
		String zip = sc.nextLine();
		for(;;) {
			try {
			zip=sc.nextLine();
			Validate validate = new Validation();
			if (validate.zipValidation(zip)) {
				System.out.println("Validated Zip Code");
				break;
			} 
			else {
				System.out.println("Wrong Input, Enter again"+"\n"+"Inside state name all words should start with first alphabet as Upper Case followed by all lower case");				
			}
			} catch (Exception e) {
				throw e;
			}
		}
		
		System.out.print("Enter Phone : "+"\n"
				+ "Correct number should start with country code followed by space and 10 digit no.");
		String phoneNumber;
		for (;;) {
			try {
				phoneNumber = sc.nextLine();
				Validate validate = new Validation();
				if (validate.phoneNumberValidation(phoneNumber)) {
					System.out.println("Validated Phone Number");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Correct number should start with country code followed by space and 10 digit no.");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		
		System.out.print("Enter Email : ");
		String email;
		for (;;) {
			try {
				email = sc.nextLine();
				Validate validate = new Validation();
				if (validate.emailValidation(email)) {
					System.out.println("Validated Email");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Correct number should start with country code followed by space and 10 digit no.");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		
		sc.close();
		Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(contact);
	}
}
