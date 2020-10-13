
package com.capgemini;

import java.util.Scanner;

import com.capgemini.dto.AddressBooks;

public class AddressBookMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AddressBooks books = new AddressBooks();

		System.out.println("Welcome to Address Book Program");

		int i = 1;

		while (i != 0) {
			System.out.println("Press 1 to Open Existing Contact Book \n" + "Press 2 to Create new address book \n"
					+ "Press 0 to Exit ");
			int options = sc.nextInt();
			switch (options) {
			case 0:
				System.out.println("Exit AddressBook Program");
				i = 0;
				break;
			case 1:
				books.openBook();
				break;
			case 2:
				books.createBook();
				break;
			default:
				System.out.println("Wrong input enter again");
				break;
			}
		}
	}
}