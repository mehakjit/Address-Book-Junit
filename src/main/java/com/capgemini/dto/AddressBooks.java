package com.capgemini.dto;

import java.util.HashMap;
import java.util.Scanner;

//import com.capgemini.service.AddressBookService;
//import com.capgemini.service.implementation.AddressBookServiceImpl;

//import com.capgemini.service.ContactService;
//import com.capgemini.service.implementation.ContactServiceImpl;

public class AddressBooks {
	
	Scanner sc = new Scanner(System.in);
	HashMap<String, AddressBook > books = new HashMap<String, AddressBook>();
	//AddressBookService addressBookService = new AddressBookServiceImpl();
	//ContactService contactService = new ContactServiceImpl();
	
	public void createBook() {
		AddressBook book = new AddressBook();
		System.out.println("Enter name of new book: ");
		String bookName = sc.nextLine();
		while(books.containsKey(bookName)) {
			System.out.println("Book already present \n Enter another name");
			bookName = sc.nextLine();
		}
		books.put(bookName, book);	
		System.out.println(books);
	}

	public void openBook() {
		System.out.println(books);
		System.out.println("Enter name of addressbook you want to open");
		String name = sc.nextLine();
		if(books.containsKey(name)) {
			AddressBook addressbook = books.get(name);
			addressbook.showOption(addressbook);
		}	
	}
	
	public void searchByCityOrState() {
		
	}
	
}
