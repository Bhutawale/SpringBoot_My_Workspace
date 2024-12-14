package com.example.restaurant_management.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	private String loginName;
	
	private String loginPassword;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginName=" + loginName + ", loginPassword=" + loginPassword + "]";
	}

	public Login(int loginId, String loginName, String loginPassword) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
