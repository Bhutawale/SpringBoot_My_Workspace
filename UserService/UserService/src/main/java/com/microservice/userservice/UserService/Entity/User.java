package com.microservice.userservice.UserService.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String uaddress;
	
	@Transient
	private List<Rating> urating=new ArrayList<>();
	
	public List<Rating> getUrating() {
		return urating;
	}
	public void setUrating(List<Rating> urating) {
		this.urating = urating;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String uaddress, List<Rating> urating) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.urating = urating;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", urating=" + urating + "]";
	}
	
}
