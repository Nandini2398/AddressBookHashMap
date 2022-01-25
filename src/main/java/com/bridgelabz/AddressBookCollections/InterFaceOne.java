package main.java.com.bridgelabz.AddressBookHashMap;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public interface InterFaceOne {
	
		void createContact();
		void addContact();
		void editContact();
		void deleteContact();
		void display();
		void displayBook();
		void addToBook();
		void operation();
		void searchPerson();
		void addContactByCity();
		void viewByCity();
		void addContactByState();
		void viewByState();
		void sortAddressBook();
		void sortByCity();
		void sortByState();
		void writeToAddressBookFile();
		public List<String> readDataFromFile();
		public void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
		public <CsvValidationException extends Throwable> void readDataFromCSV() throws IOException, CsvValidationException;
		public void writeDataToJson() throws IOException;
		public void readDataFromJson() throws IOException;
}