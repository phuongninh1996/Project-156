package com.airamerica;

public class CheckedBagage extends Services {
	private String ticketCode; 
	public CheckedBagage(String code, String type, String tickeCode){
		setProductCode(code);
		setType(type);
		this.ticketCode = ticketCode;
		
	}
}
