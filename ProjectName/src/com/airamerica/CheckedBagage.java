package com.airamerica;

public class CheckedBagage extends Services {
	private String ticketCode; 
	private int quantity;
	public CheckedBagage(String code, String type, String tickeCode){
		setProductCode(code);
		setType(type);
		this.ticketCode = ticketCode;
		
	}
	public CheckedBagage(String code, int quantity){
		setProductCode(code);
		this.quantity = quantity;		
	}
}
