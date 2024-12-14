package com.example.restaurant_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	private String adminName;
	
	private long adminContact;
	
	private String adminEmail;
	
	private String adminCity;
	
	@OneToOne(cascade = CascadeType.ALL)  
	private Login login; 
	
	@OneToMany(cascade = CascadeType.ALL)   
	private List<Sell> sell;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public long getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminCity() {
		return adminCity;
	}

	public void setAdminCity(String adminCity) {
		this.adminCity = adminCity;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Sell> getSell() {
		return sell;
	}

	public void setSell(List<Sell> sell) {
		this.sell = sell;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", adminEmail=" + adminEmail + ", adminCity=" + adminCity + ", login=" + login + ", sell=" + sell
				+ "]";
	}

	public Admin(int adminId, String adminName, long adminContact, String adminEmail, String adminCity, Login login,
			List<Sell> sell) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.adminCity = adminCity;
		this.login = login;
		this.sell = sell;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
