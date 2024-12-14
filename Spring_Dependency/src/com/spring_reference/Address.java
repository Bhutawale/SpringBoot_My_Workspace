package com.spring_reference;

public class Address
{
	private String taluka;
	private String district;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String taluka, String district) {
		super();
		this.taluka = taluka;
		this.district = district;
	}
	@Override
	public String toString() {
		return "Address [taluka=" + taluka + ", district=" + district + "]";
	}
	
	
}
