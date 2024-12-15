package com.microservice.branch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branches 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int cid;
	
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Branches(int id, int cid, String city) {
		super();
		this.id = id;
		this.cid = cid;
		this.city = city;
	}

	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Branches [id=" + id + ", cid=" + cid + ", city=" + city + "]";
	}
	
	
}
