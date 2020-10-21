package com.capgemini;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookIOService {
	
	private static final String SAMPLE_JSON_FILE_PATH = "Jsoncontactfile.txt";
	private List<Contacts> contactList;
	public static String CONTACT_FILE_NAME = "contactfile.txt";
	public static String SAMPLE_CSV_FILE_PATH = "CSVcontactfie.txt";

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
		writeCSVData(contactList);
		readCSVData();
		writeJsonData(contactList);
		readJsonData();
	}
	
	
	
	public AddressBookIOService() {

	}

	public AddressBookIOService(List<Contacts> contactList) {

		this.contactList = contactList;
	}


	public static List<Contacts> readData() {
		List<Contacts> contactsListRead = new ArrayList<>();
		try {
			Files.lines(new File(CONTACT_FILE_NAME).toPath())//.map(line -> line.trim())
			.forEach(line -> {String[] words = line.split("[\\s,:]+");

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
	
	public static List<Contacts> readCSVData() {
		List<Contacts> contactsList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBean<Contacts> csvToBean = new CsvToBeanBuilder<Contacts>(reader)
					.withType(Contacts.class).withIgnoreLeadingWhiteSpace(true).build();

			contactsList = csvToBean.parse();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return contactsList;
	}

	public static boolean writeCSVData(List<Contacts> contactList) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH))) {
			StatefulBeanToCsv<Contacts> beanToCsv = new StatefulBeanToCsvBuilder<Contacts>(
					writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(contactList);
		} catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean writeJsonData(List<Contacts> contactList) {
		Gson gson = new Gson();
		String json = gson.toJson(contactList);
		try {
			FileWriter fileWriter = new FileWriter(SAMPLE_JSON_FILE_PATH);
			fileWriter.write(json);
			fileWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean readJsonData(){
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_JSON_FILE_PATH));
			JsonParser jsonParser = new JsonParser();
			JsonElement obj = jsonParser.parse(reader);
			JsonArray contactList = (JsonArray) obj;
			System.out.println(contactList);
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

