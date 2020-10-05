package com.capgemini.dto;

import com.capgemini.service.ContactService;
import com.capgemini.service.implementation.ContactServiceImpl;

public class AddressBook {
	public void addPerson() {
		ContactService contactService = new ContactServiceImpl();
		contactService.createPerson();
	}
}
