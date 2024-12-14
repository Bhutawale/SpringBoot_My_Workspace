package com.spring_dependency;

public class Person 
{
	private int pid;
	private String pname;
	private String pcity;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int pid, String pname, String pcity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcity = pcity;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pcity=" + pcity + "]";
	}
	
	
}
