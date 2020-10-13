package com.capgemini.dto;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.service.AddressBookService;
//import com.capgemini.service.ContactService;
import com.capgemini.service.implementation.AddressBookServiceImpl;
//import com.capgemini.service.implementation.ContactServiceImpl;

public class AddressBook {
	 	
	public List<Contacts> contacts = new ArrayList<>();
	
	public void addContact(Contacts c) {
		contacts.add(c);
	}

	public void showOption(AddressBook addressbook) {
		AddressBookService addressbookservice = new AddressBookServiceImpl();
		addressbookservice.showOptions(addressbook);
	}
	
	public void printContacts() {
		for(Contacts i : contacts)
			System.out.println(i);
		}
	
	public void deleteContact(Contacts c) {
		contacts.remove(c);
	}
		
}
