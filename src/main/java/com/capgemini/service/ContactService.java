package com.capgemini.service;

import com.capgemini.dto.*;

public interface ContactService {
	public void createPerson(AddressBook addressbook );
	public void editPerson(AddressBook addressbook );
	public void deletePerson(AddressBook addressbook );
}
