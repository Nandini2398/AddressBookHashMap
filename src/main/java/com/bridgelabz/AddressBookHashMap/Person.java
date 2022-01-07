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
	    public void display() {
	        System.out.println("Created contact list is");
	        for(Map.Entry m : detailsBook.entrySet()) {
	        	System.out.println(m.getKey()+"--> "+m.getValue());
	        }
	    }