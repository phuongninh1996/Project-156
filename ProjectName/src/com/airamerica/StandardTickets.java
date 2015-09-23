package com.airamerica;

import org.joda.time.DateTime;

public class StandardTickets extends ProductTypes {
	private AirPort depAirportCode; 
	private AirPort arrAirportCode;
	private DateTime depTime;
	private DateTime arrTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	
	public StandardTickets(String code, String type, AirPort depAirportCode, AirPort arrAirportCode,DateTime depTime,DateTime arrTime,String flightNo,String flightClass,String aircraftType){
	setProductCode(code);
	setType(type);
	this.depAirportCode = depAirportCode;
	this.arrAirportCode = arrAirportCode; 
	this.depTime= depTime;
	this.arrTime = arrTime;
	this.flightNo= flightNo;
	this.flightClass = flightClass;
	this.aircraftType = aircraftType;

	
}




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




	public DateTime getDepTime() {
		return depTime;
	}

	public void setDepTime(DateTime depTime) {
		this.depTime = depTime;
	}

	public DateTime getArrTime() {
		return arrTime;
	}

	public void setArrTime(DateTime arrTime) {
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

}
