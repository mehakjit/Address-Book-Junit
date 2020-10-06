package com.capgemini.dto;

import com.capgemini.service.AddressBookService;
//import com.capgemini.service.ContactService;
import com.capgemini.service.implementation.AddressBookServiceImpl;
//import com.capgemini.service.implementation.ContactServiceImpl;

public class AddressBook {
	public void showOption() {
		AddressBookService addressbookservice = new AddressBookServiceImpl();
		addressbookservice.showOptions();
	}
	
}
