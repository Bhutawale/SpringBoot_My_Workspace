package com.microservice.employee.entity;

import java.util.List;

public class Company 
{
	private int id;
	private String name;
	private List<Branches> branch;
	
	public Company(int id, String name, List<Branches> branch) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Branches> getBranch() {
		return branch;
	}
	public void setBranch(List<Branches> branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", branch=" + branch + "]";
	}
	
	
}
