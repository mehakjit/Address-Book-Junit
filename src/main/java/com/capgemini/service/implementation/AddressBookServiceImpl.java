package com.capgemini.service.implementation;

import java.util.Scanner;

import com.capgemini.service.AddressBookService;
import com.capgemini.service.ContactService;

public class AddressBookServiceImpl implements AddressBookService{
	
	Scanner sc = new Scanner(System.in);

	public void showOptions() {
		int i=1;
		while (i!=0) {
		System.out.println("Press 1 to add contacts \n"+"Press 0 to Exit");
		int options = sc.nextInt();
			switch (options) {
			case 0:
				System.out.println("Exit.");
				i=0;
				break;
			case 1:
				createPerson();
				break;
			default:
				System.out.println("Wrong input enter again");
			}
		}
	}

	public void createPerson() {
		ContactService contactservice =new ContactServiceImpl();
		contactservice.createPerson();
	}

	}
