package com.capgemini.service;

import com.capgemini.dto.*;

public interface AddressBookService{
	void showOptions(AddressBook addressbook);
	void createPerson(AddressBook addressbook );
	void editPerson(AddressBook addressbook );
}
