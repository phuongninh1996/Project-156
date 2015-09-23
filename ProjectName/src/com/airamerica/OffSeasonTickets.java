package com.airamerica;

import org.joda.time.DateTime;

public class OffSeasonTickets extends ProductTypes{
	private String seasonStartDate;
	private String seasonEndDate;
	private AirPort depAirportCode; 
	private AirPort arrAirportCode;
	private String depTime;
	private String arrTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	private String rebate; 
	
	public OffSeasonTickets(String code, String type, String seasonStartDate, String seasonEndDate, AirPort depAirportCode, AirPort arrAirportCode, String depTime,
	String arrTime,
	String flightNo,
	String flightClass,
	String aircraftType,
	String rebate ){
		
		this.seasonStartDate =seasonStartDate;
		this.seasonEndDate=seasonEndDate;
		this.depAirportCode= depAirportCode;
		this.arrAirportCode= arrAirportCode;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.flightNo= flightNo;
		this.flightClass= flightClass;
		this.aircraftType = aircraftType;
		this.rebate = rebate;
		setProductCode(code);
		setType(type);
		
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


	public String getSeasonStartDate() {
		return seasonStartDate;
	}


	public void setSeasonStartDate(String seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}


	public String getSeasonEndDate() {
		return seasonEndDate;
	}


	public void setSeasonEndDate(String seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
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

	public String getRebate() {
		return rebate;
	}

	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	
	
}

