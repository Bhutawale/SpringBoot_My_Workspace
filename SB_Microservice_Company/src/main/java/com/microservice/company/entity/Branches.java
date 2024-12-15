package com.microservice.company.entity;


public class Branches 
{
	private int id;
	private String city;
	public Branches(int id, String city) {
		super();
		this.id = id;
		this.city = city;
	}
	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Branches [id=" + id + ", city=" + city + "]";
	}
	
	
}
