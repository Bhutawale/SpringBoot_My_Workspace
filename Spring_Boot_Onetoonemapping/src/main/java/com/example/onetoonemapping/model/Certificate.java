package com.example.onetoonemapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Course_Certificate")
public class Certificate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Certificate_Id")
	private int cid;
	
	@Column(name="Course")
	private String course;
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Certificate(int cid, String course) {
		super();
		this.cid = cid;
		this.course = course;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Certificate [cid=" + cid + ", course=" + course + "]";
	}
	
	
	
}
