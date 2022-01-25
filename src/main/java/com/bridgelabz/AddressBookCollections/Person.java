package main.java.com.bridgelabz.AddressBookHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Person implements InterFaceOne  {
    static Scanner sc = new Scanner(System.in);
    static String firstName,lastName,address,state,email,city;
    static int zip;
    static long phoneNumber;
    ContactInfo infoContact = new ContactInfo();
    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    static Map<String,Contact> detailsBook = new HashMap<>();
    static Map<String,Contact> personByCity = new HashMap<>();
    Map<String,Contact> personByState = new HashMap<>();
	static Map<String,Map<String,Contact>> book = new HashMap<>();

	public void createContact() {
		System.out.println("Enter how many contacts you want to create");
    	int numOfContact = sc.nextInt();
    	while(numOfContact > 0) {
			System.out.println("Enter Name of person");
			String firstName = sc.next();
	    	if(!detailsBook.containsKey(firstName)) {
	    		infoContact.info();
				detailsBook.put(firstName,new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
				numOfContact--;
	    	}
	    	else {
	    		System.out.println("Contact already exists!");
	    	}
    	}
	}
    public void addContact()  {
    	System.out.println("Enter how many contacts you want to add");
    	int numOfContacts = sc.nextInt();
    	while(numOfContacts > 0) {
	    	System.out.println("Enter Name of person");
			String firstName = sc.next();
	    	if(detailsBook.containsKey(firstName)) {
	    		System.out.println("Contact already exists!");
	    		return;
	    	}
	    	else {
	    		infoContact.info();
	    		detailsBook.put(firstName,new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	    		numOfContacts--;
	    	}
    	}
    }
    public void editContact()  {
    	System.out.println("Enter name of person whose contact you want to edit");
			String firstName = sc.next();
	    	if(detailsBook.containsKey(firstName)) {
	        	infoContact.info();
	    		detailsBook.put(firstName,new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	    	}
	    	else {
	    		System.out.println("Contact is not present in book");
	    		return;
	    	}
    }
    public void deleteContact()  {
    	System.out.println("Enter name of person whose contact you want to delete");
			String name = sc.next();
	    	if(detailsBook.containsKey(name)) {
	    		detailsBook.remove(name);
	    	}
	    	else {
	    		System.out.println("Contact is not present in book");
	    		return;
	    	}
    }   
    public void display() {
        System.out.println("Created contact list is");
        for(Map.Entry m : detailsBook.entrySet()) {
        	System.out.println(m.getKey()+"--> "+m.getValue());
        }
    }
    public void addToBook() {
	    	System.out.println("Enter Name of Address Book");
	    	String bookName = sc.next();
	    	if(!book.containsKey(bookName)) {
		    	book.put(bookName, detailsBook);
		    	}
	    	else {
	    		System.out.println("Book already exists!");
	    	}
    }
    public void operation() {
    	System.out.println("Enter how many address books you want to add");
    	int noOfAddressBook = sc.nextInt();
    	while(noOfAddressBook > 0) {
    		addContact();
    		addToBook();
    		noOfAddressBook--;
    	}
    }
    public void searchPerson() {
    	System.out.println("Enter person name to search ");
    	String name = sc.next();
    	for(Map.Entry e : detailsBook.entrySet()) {
	    	if(detailsBook.get(name).equals(e.getValue())) {
	    		System.out.println(e.getValue());
	    	}
    	}
    }
    public void displayBook() {
    	System.out.println("Address Books are:");
    	for(Map.Entry e : book.entrySet()) {
        	System.out.println(e.getKey()+"--> "+e.getValue());
        }
    }
    public void addContactByCity()  {
    	System.out.println("Enter how many contacts you want to add");
    	int numOfContacts = sc.nextInt();
    	while(numOfContacts > 0) {
	    	System.out.println("Enter Name of city");
			String cityName = sc.next();
	    	if(personByCity.containsKey(cityName)) {
	    		System.out.println("Contact already exists!");
	    		return;
	    	}
	    	else {
	    		infoContact.info();
	    		personByCity.put(city,new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	    		numOfContacts--;
	    	}
    	}
    	System.out.println(personByCity);
    }
    public void addContactByState()  {
    	System.out.println("Enter how many contacts you want to add");
    	int numOfContacts = sc.nextInt();
    	while(numOfContacts > 0) {
	    	System.out.println("Enter Name of city");
			String stateName = sc.next();
	    	if(personByState.containsKey(stateName)) {
	    		System.out.println("Contact already exists!");
	    		return;
	    	}
	    	else {
	    		infoContact.info();
	    		personByState.put(state,new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	    		numOfContacts--;
	    	}
    	}
    }
    public void viewByCity() {
		Map<String,Contact> detailsByCity =personByCity.entrySet().stream().filter(e->e.getKey().equals("Pune")).collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		if(detailsByCity!=null) {
		    System.out.println(detailsByCity);
		    System.out.println("Number of person belonging to city is: "+detailsByCity.size());
		}else {
			System.out.println("Person having particular city is not present");
		}
    }
    public void viewByState() {
		Map<String,Contact> detailsByState =personByState.entrySet().stream().filter(e->e.getKey().equals("Karnataka")).collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		if(detailsByState!=null) {
		    System.out.println(detailsByState);
		    System.out.println("Number of person belonging to state is: "+detailsByState.size());
		}else {
			System.out.println("Person with particular state is not present");
		}
	 }
    public void sortAddressBook() {
		Map<String,Contact> sortedContact =detailsBook.entrySet().stream()
				      						.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue
				      							,(oldValue,newValue)->oldValue,LinkedHashMap::new));
		System.out.println("Sorted Address Book "+sortedContact);
	}
}