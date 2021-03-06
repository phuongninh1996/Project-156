package com.airamerica;

import com.airamerica.utils.Haversine;

public abstract class  Ticket extends Product {
	private String travelDate;
	private String flightClass;
	private AirPort departureCity;
	private DateTime dateTime;
	private AirPort arrivalCity;
	private String aircraftType;
	private String arrivalDateTime;
	private String listOfSeatNumber;
	private Passenger listOfPassengers;
	private String ticketNote;
	
	
	public Ticket(String travelDate, String flightClass, AirPort departureCity, DateTime dateTime,
			AirPort arrivalCity, String aircraftType, String arrivalDateTime, String listOfSeatNumber,     
			Passenger listOfPassenger, String ticketNote){
		this.travelDate= travelDate  ;
		this.flightClass = flightClass ;
		this.departureCity= departureCity ;
		this.dateTime= dateTime ;
		this.arrivalCity= arrivalCity;
		this.aircraftType= aircraftType;
		this.arrivalDateTime = arrivalDateTime;
		this.listOfSeatNumber= listOfSeatNumber;
		this.listOfPassengers= listOfPassenger;
		this.ticketNote= ticketNote;
		
	} 
	public abstract void airPortsDistance();
	public abstract void baseFair();
		
	
	public abstract void taxRate();
		
	
	public abstract void segmentTax();
		
	public abstract void securityFee();
		
	public abstract void passengerFacilityFee();
		
	public  abstract void totalTax();
		
	public abstract void  printTax();
	
}
