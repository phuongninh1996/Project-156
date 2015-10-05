package com.airamerica;

public class Invoice {
	private String Code;
	private DateTime Date;
	private String PNR;
	private Ticket ListOfTickets;
	private Customer Customer;
	private Person Salesperson;
	public Invoice(String code, DateTime date, String PNR,
			Ticket listOfTickets, com.airamerica.Customer customer,
			Person salesperson, Services listOfService) {
		super();
		Code = code;
		Date = date;
		PNR = PNR;
		ListOfTickets = listOfTickets;
		Customer = customer;
		Salesperson = salesperson;
		ListOfService = listOfService;
	}
	private Services ListOfService;
}
