package com.capgemini.service.implementation;

import java.util.Scanner;

import com.capgemini.dto.AddressBook;
import com.capgemini.dto.Contacts;
import com.capgemini.service.ContactService;
import com.capgemini.service.Validate;

public class ContactServiceImpl implements ContactService {

	Scanner sc = new Scanner(System.in);
	Validate validate = new Validation();
	//AddressBook addressbook = new AddressBook();
	Contacts contact;

	public void createPerson(AddressBook addressbook ) {
		System.out.print("Enter First Name : " + "\n"
				+ "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.\n");
		String firstName = validatedFirstName();
		System.out.println("Enter Last Name : " + "\n"
				+ "Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.");
		String lastName = validatedLastName();
		System.out.print("Enter Address : ");
		String address = validatedAddress();
		System.out.print("Enter City : " + "\n"
				+ "Inside city name all words should start with first alphabet as Upper Case followed by all lower case \n");
		String city = validatedCity();
		System.out.print("Enter State : " + "\n"
				+ "Inside state name all words should start with first alphabet as Upper Case followed by all lower case \n");
		String state = validatedState();
		System.out.print(
				"Enter Zip : \n" + "Pin Code should be 6 digit long with an optional space after 3rd chracter \n");
		String zip = validatedZip();
		System.out.print("Enter Phone : " + "\n"
				+ "Correct number should start with country code followed by space and 10 digit no. \n");
		String phoneNumber = validatedPhoneNumber();
		System.out
				.print("Enter Email : \n" + "Correct email should be in Lower Case and it should have valid TLD's \n");
		String email = validatedEmail();
		contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
		addressbook.addContact(contact);
		addressbook.printContacts();
	}

	public void editPerson(AddressBook addressbook) {
		addressbook.printContacts();
		System.out.println("Enter the first name of the contact you want to edit.");
		String firstName = sc.nextLine();
		int count = 0;
		for (Contacts i : addressbook.contacts) {
			if (firstName.equalsIgnoreCase(i.getFirstName())) {
				count = count + 1;
				int a = 0;
				while (a != 1) {
					System.out.println("Press 1 to edit First Name \n" + "Press 2 to edit LastName \n"
							+ "Press 3 to edit Address \n" + "Press 4 to edit City Name \n"
							+ "Press 5 to edit State Name \n" + "Press 6 to edit Zip \n"
							+ "Press 7 to edit Phone Number \n" + "Press 8 to edit email \n" + "Press 0 to exit.");
					int option = sc.nextInt();
					sc.nextLine();
					switch (option) {
					case 0:
						System.out.println("Updated Contact");
						System.out.println("Exit Edit Person tab");
						a = 1;
						break;
					case 1:
						System.out.println(
								"Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.");
						i.setFirstName(validatedFirstName());
						System.out.println(i);
						break;
					case 2:
						System.out.println(
								"Correct name should start with Upper Case alphabet and should have min 3 charcaters with rest in Lower Case.");
						i.setLastName(validatedLastName());
						System.out.println(i);
						break;
					case 3:
						System.out.println("Enter address ");
						i.setAddress(validatedAddress());
						System.out.println(i);
						break;
					case 4:
						System.out.println(
								"Inside city name all words should start with first alphabet as Upper Case followed by all lower case ");
						i.setCity(validatedCity());
						System.out.println(i);
						break;
					case 5:
						System.out.println(
								"Inside state name all words should start with first alphabet as Upper Case followed by all lower case ");
						i.setState(validatedState());
						System.out.println(i);
						break;
					case 6:
						System.out
								.println("Pin Code should be 6 digit long with an optional space after 3rd chracter ");
						i.setZip(validatedZip());
						System.out.println(i);
						break;
					case 7:
						System.out.println(
								"Correct number should start with country code followed by space and 10 digit no. ");
						i.setPhoneNumber(validatedPhoneNumber());
						System.out.println(i);
						break;
					case 8:
						System.out.println("Correct email should be in Lower Case and it should have valid TLD's ");
						i.setEmail(validatedEmail());
						System.out.println(i);
						break;
					default:
						System.out.println("Wrong Input, Enter again ");
						System.out.println(i);
						break;
					}
				}
			}
		}
		if (count == 0)
			System.out.println("No Such Contact found");
	}

	@Override
	public void deletePerson(AddressBook addressbook) {
		addressbook.printContacts();
		System.out.println("Enter the first name of the contact you want to delete.");
		String firstName = sc.nextLine();
		int count = 0;
		for (Contacts i : addressbook.contacts) {
			if (firstName.equalsIgnoreCase(i.getFirstName())) {
				System.out.println(i);
				System.out.println("Press 1 to delete this Contact \n" + "Press 2 to skip");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					addressbook.deleteContact(i);
					System.out.println("Deleted Contact. ");
					break;
				case 2:
					break;
				default:
					System.out.println("Wrong Input");
					break;
				}
			}
		}
		if (count == 0)
			System.out.println("No such contact Found");
		addressbook.printContacts();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String validatedFirstName() {
		String firstName;
		for (;;) {
			try {
				firstName = sc.nextLine();
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
		return firstName;
	}

	private String validatedLastName() {
		String lastName;
		for (;;) {
			try {
				lastName = sc.nextLine();
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
		return lastName;
	}

	private String validatedAddress() {
		String address;
		try {
			for (;;) {
				address = sc.nextLine();
				if (address == "") {
					System.out.println("Invalid Entry, Try again \n");
					continue;
				} else
					break;
			}
		} catch (Exception e) {
			throw e;
		}
		return address;
	}

	private String validatedCity() {
		String city;
		for (;;) {
			try {
				city = sc.nextLine();
				if (validate.cityValidation(city)) {
					System.out.println("Validated City");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Inside city name all words should start with first alphabet as Upper Case followed by all lower case");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return city;
	}

	private String validatedState() {
		String state;
		for (;;) {
			try {
				state = sc.nextLine();
				if (validate.stateValidation(state)) {
					System.out.println("Validated City");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Inside state name all words should start with first alphabet as Upper Case followed by all lower case");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return state;
	}

	private String validatedZip() {
		String zip;
		for (;;) {
			try {
				zip = sc.nextLine();
				if (validate.zipValidation(zip)) {
					System.out.println("Validated Zip Code");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Pin Code should be 6 digit long with an optional space after 3rd chracter");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return zip;
	}

	private String validatedPhoneNumber() {
		String phoneNumber;
		for (;;) {
			try {
				phoneNumber = sc.nextLine();
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
		return phoneNumber;
	}

	private String validatedEmail() {
		String email;
		for (;;) {
			try {
				email = sc.nextLine();
				if (validate.emailValidation(email)) {
					System.out.println("Validated Email");
					break;
				} else {
					System.out.println("Wrong Input, Enter again" + "\n"
							+ "Correct email should be in Lower Case and it should have valid TLD's");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return email;
	}

}
