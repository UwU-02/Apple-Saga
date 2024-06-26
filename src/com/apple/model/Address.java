package com.apple.model;

public class Address{
	private int number;
	private String road;
	private int postcode;
	private String state;
	private int tel;
	
	public Address(int number,String road,int postcode,String state,int tel){
		this.number=number;
		this.road=road;
		this.postcode=postcode;
		this.state=state;
		this.tel=tel;
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
	public int getTel(){
		return tel;
	}
}