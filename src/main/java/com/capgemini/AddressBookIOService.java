package com.capgemini;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.*;
public class AddressBookIOService {
	
	
	public static void main(String[] args) {
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Mehakjit", "Singh", "Patiala", "Patiala", "Punjab", "12345",
				"91 9999999999", "xyz@google.com");
		Contacts contact2 = new Contacts("Mehak", "Singh", "Pat", "Pay", "Pun", "213546",
				"91 8888888888", "xyz@gmail.com");
		Contacts contact3 = new Contacts("Mehk", "Jit", "Hja", "Lov", "Best", "987345",
				"91 8888888880", "zyz@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		contactList.add(contact3);
		writeData(contactList);
		readData();

	}
	
	private List<Contacts> contactList;
	public static String CONTACT_FILE_NAME = "contactfile.txt";
	
	public AddressBookIOService() {

	}

	public AddressBookIOService(List<Contacts> contactList) {

		this.contactList = contactList;
	}


	public static List<Contacts> readData() {
		List<Contacts> contactsListRead = new ArrayList<>();
		try {
			Files.lines(new File(CONTACT_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,:]+");

				Contacts contact = new Contacts();
				contact.setFirstName(words[1]);
				contact.setLastName(words[3]);
				contact.setAddress(words[5]);
				contact.setCity(words[7]);
				contact.setState(words[9]);
				contact.setZip(words[11]);
				contact.setPhoneNumber(words[13]);
				contact.setEmail(words[15]);

				contactsListRead.add(contact);
			});
		} catch (Exception e) {
			}
		return contactsListRead;
	}

	public static void writeData(List<Contacts> contactList) {
		StringBuffer empBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(CONTACT_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(CONTACT_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}
