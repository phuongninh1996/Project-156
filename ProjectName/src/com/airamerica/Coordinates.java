package com.airamerica;

public class Coordinates {
	private String latdges;
	private String latmins;
	private String londegs;
	private String lonmins;
	
	public Coordinates(String latdges, String latmins, String londegs, String lonmins){
		this.latdges = latdges;
		this.latmins = latmins;
		this.londegs = londegs;
		this.lonmins = lonmins;
	}
	public String getLatdges() {
		return latdges;
	}
	public void setLatdges(String latdges) {
		this.latdges = latdges;
	}
	public String getLatmins() {
		return latmins;
	}
	public void setLatmins(String latmins) {
		this.latmins = latmins;
	}
	public String getLondegs() {
		return londegs;
	}
	public void setLondegs(String londegs) {
		this.londegs = londegs;
	}
	public String getLonmins() {
		return lonmins;
	}
	public void setLonmins(String lonmins) {
		this.lonmins = lonmins;
	}
	
}
