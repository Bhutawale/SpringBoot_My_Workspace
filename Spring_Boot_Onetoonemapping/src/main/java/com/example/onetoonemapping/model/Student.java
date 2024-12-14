package com.example.onetoonemapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student_Details")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Student_Id")
	private int sid;
	
	@Column(name="Student_Name")
	private String sname;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Certificate certi;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student(int sid, String sname, Certificate certi) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", certi=" + certi + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
