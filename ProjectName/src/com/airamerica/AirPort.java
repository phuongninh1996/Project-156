package com.airamerica;

public class AirPort {
	private String airportCode;
	private String name;
	private Address address;
	private Coordinates coordinates;
	private String passengerFacilityFee;
	
	public AirPort(String airportCode, String name, Address address, Coordinates coordinates, String passengerFacilityFee){
		this.airportCode = airportCode;
		this.name = name;
		this.address = address;
		this.coordinates= coordinates;
		this.passengerFacilityFee = passengerFacilityFee;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getPassengerFacilityFee() {
		return passengerFacilityFee;
	}

	public void setPassengerFacilityFee(String passengerFacilityFee) {
		this.passengerFacilityFee = passengerFacilityFee;
	}
	
	
	
}
