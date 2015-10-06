package com.airamerica;

import org.joda.time.DateTime;

public class AwardTickets extends Ticket{
	private AirPort depAirportCode; 
	private AirPort arrAirportCode;
	private String depTime;
	private String arrTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	private String pointsPerMile;	
	// Overwrite super class method
	public  void airPortsDistance(){
		
	}
	public  void baseFair(){
		
	}
		
	
	public  void taxRate(){
		
	}
		
	
	public  void segmentTax(){
		
	}
		
	public  void securityFee(){
		
	}
		
	public  void passengerFacilityFee(){
		
	}
		
	public   void totalTax(){
		
	}
		
	public  void  printTax(){
		
	}
	
	


// Get and set
	public AirPort getDepAirportCode() {
		return depAirportCode;
	}

	public void setDepAirportCode(AirPort depAirportCode) {
		this.depAirportCode = depAirportCode;
	}

	public AirPort getArrAirportCode() {
		return arrAirportCode;
	}

	public void setArrAirportCode(AirPort arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getPointsPerMile() {
		return pointsPerMile;
	}

	public void setPointsPerMile(String pointsPerMile) {
		this.pointsPerMile = pointsPerMile;
	}

	public AwardTickets(String code, String type, AirPort depAirportCode, AirPort arrAirportCode,String depTime,String arrTime,String flightNo,String flightClass,String aircraftType, String pointsPerMile){
		// add its super class 
		super(travelDate, flightClass, departureCity, dateTime,
				arrivalCity, aircraftType, arrivalDateTime,listOfSeatNumber,     
				listOfPassenger, ticketNote);
		setProductCode(code);
		setType(type);
		this.depAirportCode = depAirportCode;
		this.arrAirportCode = arrAirportCode; 
		this.depTime= depTime;
		this.arrTime = arrTime;
		this.flightNo= flightNo;
		this.flightClass = flightClass;
		this.aircraftType = aircraftType;
		this.pointsPerMile = pointsPerMile;
	}
}
