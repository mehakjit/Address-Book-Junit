package com.capgemini.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//import com.capgemini.service.AddressBookService;
//import com.capgemini.service.implementation.AddressBookServiceImpl;

//import com.capgemini.service.ContactService;
//import com.capgemini.service.implementation.ContactServiceImpl;

public class AddressBooks {
	
	Scanner sc = new Scanner(System.in);
	HashMap<String, AddressBook > books = new HashMap<String, AddressBook>();
	AddressBook book;
	//AddressBookService addressBookService = new AddressBookServiceImpl();
	//ContactService contactService = new ContactServiceImpl();
	
	public void createBook() {
		book = new AddressBook();
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
	
	public List<Contacts> searchByCity(String cityName) {
		return book.contacts.stream().filter(contacts -> contacts.getCity().equals(cityName)).collect(Collectors.toList());
	}
	
	public List<Contacts> searchPersonsByState(String state) {
		return book.contacts.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}

	public int countByCity(String cityName) {
		return book.contacts.stream().filter(person -> person.getCity().equals(cityName)).collect(Collectors.toList()).size();
	}
	
	public int countPersonsByState(String stateName) {
		return book.contacts.stream().filter(person -> person.getState().equals(stateName)).collect(Collectors.toList()).size();
	}
	public List<Contacts> sortAlphabetically(){
		return book.contacts.stream().sorted((n1, n2) -> n1.getFirstName().compareTo(n2.getFirstName())).collect(Collectors.toList());
	}
}
