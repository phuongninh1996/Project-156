package com.airamerica;

public class Customer {
	
	
	private String customerCode;
	
	/* Note how Person has been used as 
	 * primary contact(Composition Relationship) */ 
	private Person primaryContact;

	/*TODO: Add other fields as necessary (eg. firstName, lastName,
	phoneNo etc) */
	private String type;
	private String name;
	private String airlineMiles;
	
	
	// TODO: Add constructor(s)
	public Customer (String customerCode, Person primaryContact, String type, String name, String airlineMiles ){
		this.type = type;
		this.name = name;
		this.airlineMiles = airlineMiles;
		this.primaryContact= primaryContact;
	}
	
	/*TODO: Add Getters and setters */
	public Person getPrimaryContact() {
		return primaryContact;
	}

	//TODO: Add additional methods if needed */
}
