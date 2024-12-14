package com.example.employeeproject.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String exp1;
	private String exp2;
	
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Experience(int id, String exp1, String exp2) {
		super();
		this.id = id;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExp1() {
		return exp1;
	}

	public void setExp1(String exp1) {
		this.exp1 = exp1;
	}

	public String getExp2() {
		return exp2;
	}

	public void setExp2(String exp2) {
		this.exp2 = exp2;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", exp1=" + exp1 + ", exp2=" + exp2 + "]";
	}
	
	
}
