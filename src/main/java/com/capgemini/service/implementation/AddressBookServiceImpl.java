package com.capgemini.service.implementation;

import java.util.Scanner;

import com.capgemini.dto.*;
import com.capgemini.service.AddressBookService;
import com.capgemini.service.ContactService;

public class AddressBookServiceImpl implements AddressBookService{
	
	Scanner sc = new Scanner(System.in);
	ContactService contactService = new ContactServiceImpl();

	public void showOptions(AddressBook addressbook ) {
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
				createPerson(addressbook);
				break;
			case 2:
				editPerson(addressbook);
				break;
			case 3:
				deletePerson(addressbook);
				break;
			default:
				System.out.println("Wrong input enter again");
				break;
			}
		}
	}
	
	
	public void deletePerson(AddressBook addressbook ) {
		contactService.deletePerson(addressbook );
		
	}
	@Override
	public void createPerson(AddressBook addressbook ) {
		contactService.createPerson(addressbook);
	}

	@Override
	public void editPerson(AddressBook addressbook ) {
		contactService.editPerson(addressbook);		
	}
}
