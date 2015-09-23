package com.airamerica;

public class Refreshment extends Services {
	private String name;
	private String cost;
	public Refreshment(String code, String type, String name, String cost){
		setProductCode(code);
		setType(type);
		this.name= name;
		this.cost= cost; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
}

