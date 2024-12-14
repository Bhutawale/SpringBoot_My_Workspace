package com.example.restaurant_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Login 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int loginId;
	
	@NotBlank(message = "Login Name Cannot be Blank!!")
	private String loginName;
	
	@NotBlank(message = "Please enter Password.")
	private String loginPassword;
	
	@NotNull(message = "Please enter Admin Id.")
	@OneToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	
	
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

	@JsonBackReference
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginName=" + loginName + ", loginPassword=" + loginPassword
				+ ", admin=" + admin + "]";
	}

	public Login(int loginId, String loginName, String loginPassword, Admin admin) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.admin = admin;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}