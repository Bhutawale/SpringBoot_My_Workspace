package com.example.furniture_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login_Details")
public class Login
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Login_Id")
	private int loginId;
	
	@Column(name="Login_Name")
	private String uName;
	
	@Column(name="Password")
	private String password;
	
	

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(int loginId, String uName, String password) {
		super();
		this.loginId = loginId;
		this.uName = uName;
		this.password = password;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", uName=" + uName + ", password=" + password + "]";
	}
	
	
}
