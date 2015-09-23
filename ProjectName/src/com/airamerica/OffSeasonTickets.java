package com.airamerica;

import org.joda.time.DateTime;

public class OffSeasonTickets extends ProductTypes{
	private DateTime seasonStartDate;
	private DateTime seasonEndDate;
	private AirPort depAirportCode; 
	private AirPort arrAirportCode;
	private DateTime depTime;
	private DateTime arrTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	private String rebate; 
	
	public OffSeasonTickets(String code, String type, DateTime seasonStartDate, DateTime seasonEndDate, AirPort depAirportCode, AirPort arrAirportCode, DateTime depTime,
	DateTime arrTime,
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

	public DateTime getSeasonStartDate() {
		return seasonStartDate;
	}

	public void setSeasonStartDate(DateTime seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	public DateTime getSeasonEndDate() {
		return seasonEndDate;
	}

	public void setSeasonEndDate(DateTime seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
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

	public String getRebate() {
		return rebate;
	}

	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	
	
}

