package com.example.furniture_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Administrator_Details")
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Admin_Id")
	private int adminId;
	
	@Column(name="Admin_Name")
	private String adminName;
	
	@Column(name="Admin_Contact")
	private long adminContact;
	
	@Column(name="Admin_City")
	private String adminCity;
	
	@Column(name="Admin_EmailId")
	private String adminEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> users;            //one admin manages many users.
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;      //one admin manages many products.
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orders;			//one admin can manage all the orders.


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


	public String getAdminCity() {
		return adminCity;
	}


	public void setAdminCity(String adminCity) {
		this.adminCity = adminCity;
	}


	public String getAdminEmail() {
		return adminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Admin(int adminId, String adminName, long adminContact, String adminCity, String adminEmail, Login login,
			List<User> users, List<Product> products, List<Order> orders) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminCity = adminCity;
		this.adminEmail = adminEmail;
		this.login = login;
		this.users = users;
		this.products = products;
		this.orders = orders;
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", adminCity=" + adminCity + ", adminEmail=" + adminEmail + ", login=" + login + ", users=" + users
				+ ", products=" + products + ", orders=" + orders + "]";
	}
	
	
}
