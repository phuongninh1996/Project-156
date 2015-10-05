package com.airamerica;

public class Insurance extends Services {
	private String name;
	private String ageClass;
	private String costPerMile;
	private int quantity; 
	private String ticketCode;

	public Insurance(String code, String type, String name, String ageClass, String costPerMiles){
		setProductCode(code);
		setType(type);
		this.name =name;
		this.ageClass=ageClass;
		this.costPerMile= costPerMiles;
	
	}
	public Insurance(String code, int quantity, String ticketCode){
		setProductCode(code);
		this.quantity = quantity;
		this.ticketCode = ticketCode;
		
	}
}	

