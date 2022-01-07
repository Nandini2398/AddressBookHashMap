package main.java.com.bridgelabz.AddressBookHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person implements InterfaceOne  {
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	public class Person implements InterfaceOne  {

	    static Scanner sc = new Scanner(System.in);
	    static String firstName,lastName,address,state,email,city;
	    static int zip;
	    static long phoneNumber;
	    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		Map<String,Contact> detailsBook = new HashMap<>();
		
		public void createContact() {
			detailsBook.put("one",new Contact("Nandini","Spm","New residency","rjy","Ap", 23, 9876543210,"nandu@one.com"));
			detailsBook.put("two",new Contact("Prudhvi","raj","cycle colony", "SaiDurga", "Ap", 11, 8676247876,"prudhvi@two.com"));
			detailsBook.put("three",new Contact("Bablu","kumar","Hb colony","Ts", 20, 8328606571,"bablu@three.com"));
		}        
		public void addContact()  {
	    	System.out.println("Enter how many contacts you want to add");
	    	int numOfContacts = sc.nextInt();
	    	while(numOfContacts > 0) {
		    	System.out.println("Enter id of person");
				String id = sc.next();
		    	if(detailsBook.containsKey(id)) {
		    		System.out.println("Contact already exists!");
		    		return;
		    	}
		    	else {
		    		System.out.println("Enter First Name :");
		        	String fName = sc.next();
		        	System.out.println("Enter Last Name :");
		        	String lName = sc.next();
		        	System.out.println("Enter Address :");
		        	String address = sc.next();
		        	System.out.println("Enter City :");
		        	String city = sc.next();
		        	System.out.println("Enter State :");
		        	String state = sc.next();
		        	System.out.println("Enter Zip :");
		        	int zip = sc.nextInt();
		        	System.out.println("Enter Phone Number :");
		        	long number = sc.nextLong();
		        	System.out.println("Enter Email :");
		        	String mail = sc.next();
		    		detailsBook.put(id,new Contact(fName, lName, address, city, state, zip, number, mail));
		    		numOfContacts--;
		    	}
	    	}
	    }
	        
	    
	 public void editContact()  {
	    	System.out.println("Enter name of person whose contact you want to edit");
				String name = sc.next();
		    	if(detailsBook.containsKey(name)) {
		    		System.out.println("Enter First Name :");
		        	String fName = sc.next();
		        	System.out.println("Enter Last Name :");
		        	String lName = sc.next();
		        	System.out.println("Enter Address :");
		        	String address = sc.next();
		        	System.out.println("Enter City :");
		        	String city = sc.next();
		        	System.out.println("Enter State :");
		        	String state = sc.next();
		        	System.out.println("Enter Zip :");
		        	int zip = sc.nextInt();
		        	System.out.println("Enter Phone Number :");
		        	long number = sc.nextLong();
		        	System.out.println("Enter Email :");
		        	String mail = sc.next();
		    		detailsBook.put(name,new Contact(fName, lName, address, city, state, zip, number, mail));
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
	   
	}