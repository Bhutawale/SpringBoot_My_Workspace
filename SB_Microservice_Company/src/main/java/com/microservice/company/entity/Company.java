package com.microservice.company.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Company 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int eid;
	
	@Transient
	private List<Branches> branch;

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

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public List<Branches> getBranch() {
		return branch;
	}

	public void setBranch(List<Branches> branch) {
		this.branch = branch;
	}

	public Company(int id, String name, int eid, List<Branches> branch) {
		super();
		this.id = id;
		this.name = name;
		this.eid = eid;
		this.branch = branch;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", eid=" + eid + ", branch=" + branch + "]";
	}
	
	
	
}
