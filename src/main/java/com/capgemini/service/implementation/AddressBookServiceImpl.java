package com.capgemini.service.implementation;

import java.util.Scanner;

import com.capgemini.service.AddressBookService;
import com.capgemini.service.ContactService;

public class AddressBookServiceImpl implements AddressBookService{
	
	Scanner sc = new Scanner(System.in);
	ContactService contactService = new ContactServiceImpl();

	public void showOptions() {
		int i=1;
		
		while (i!=0) {
		System.out.println("Press 1 to add contacts \n"+"Press 2 to edit contact \n"+
						   "Press 3 to delete contact \n"+"Press 0 to Exit ");
		int options = sc.nextInt();
			switch (options) {
			case 0:
				System.out.println("Exit.");
				i=0;
				break;
			case 1:
				createPerson();
				break;
			case 2:
				editPerson();
				break;
			case 3:
				deletePerson();
				break;
			default:
				System.out.println("Wrong input enter again");
			}
		}
	}
	
	
	public void deletePerson() {
		contactService.deletePerson();
	}
	@Override
	public void createPerson() {
		contactService.createPerson();
	}

	@Override
	public void editPerson() {
		contactService.editPerson();		
	}
}
