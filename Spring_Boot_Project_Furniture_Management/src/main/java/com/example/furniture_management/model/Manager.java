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
@Table(name="Manager_Details")
public class Manager 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Manager_ID")
	private int managerId;
	
	@Column(name="Manager_Name")
	private String managerName;
	
	@Column(name="Manager_Contact")
	private long managerContact;
	
	@Column(name="Manager_City")
	private String managerCity;
	
	@Column(name = "Manager_Email")
	private String managerEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;      //one manager manages many products.
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> users;            //one manager manages many users.
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orders;			//one manager can see all the orders.


	public Login getLogin() {
		return login;
	}



	public void setLogin(Login login) {
		this.login = login;
	}



	public int getManagerId() {
		return managerId;
	}



	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



	public String getManagerName() {
		return managerName;
	}



	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	public long getManagerContact() {
		return managerContact;
	}



	public void setManagerContact(long managerContact) {
		this.managerContact = managerContact;
	}



	public String getManagerCity() {
		return managerCity;
	}



	public void setManagerCity(String managerCity) {
		this.managerCity = managerCity;
	}



	public String getManagerEmail() {
		return managerEmail;
	}



	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public Manager(int managerId, String managerName, long managerContact, String managerCity, String managerEmail,
			Login login, List<Product> products, List<User> users, List<Order> orders) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.managerCity = managerCity;
		this.managerEmail = managerEmail;
		this.login = login;
		this.products = products;
		this.users = users;
		this.orders = orders;
	}



	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerContact=" + managerContact
				+ ", managerCity=" + managerCity + ", managerEmail=" + managerEmail + ", login=" + login + ", products="
				+ products + ", users=" + users + ", orders=" + orders + "]";
	}



	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
}
