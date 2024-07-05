package com.apple.model;

public class Address{
	private int number;
	private String road;
	private int postcode;
	private String state;
	
	public Address(int number, String road, int postcode, String state){
		this.number=number;
		this.road=road;
		this.postcode=postcode;
		this.state=state;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getRoad(){
		return road;
	}
	
	public int getPostcode(){
		return postcode;
	}
	
	public String getState(){
		return state;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
