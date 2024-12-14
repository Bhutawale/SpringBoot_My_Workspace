package com.example.restaurant_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int adminId;
	
	@NotBlank(message = "Admin Name Cannot Be Blank!!")
	private String adminName;
	
	@NotNull
	@Min(10)
	@Max(10)
	private long adminContact;
	
	@NotNull
	@Email(message = "Please enter valid email Id." )
	private String adminEmail;
	
	@NotBlank(message = "Admin City Cannot be Blank!!")
	private String adminCity;
	
	@NotNull(message = "Please Enter login ID.")
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "admin")  
	private Login login; 
	
	@NotNull(message = "Please Enter Bill Id.")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "admin")   
	private List<Bill> bill;

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

	@JsonManagedReference
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@JsonManagedReference
	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", adminEmail=" + adminEmail + ", adminCity=" + adminCity + ", login=" + login + ", bill=" + bill
				+ "]";
	}

	public Admin(int adminId, String adminName, long adminContact, String adminEmail, String adminCity, Login login,
			List<Bill> bill) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.adminCity = adminCity;
		this.login = login;
		this.bill = bill;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}