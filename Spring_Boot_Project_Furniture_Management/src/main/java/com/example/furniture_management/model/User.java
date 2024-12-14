package com.example.furniture_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User_Details")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name = "User_Age")
	private int userAge;
	
	@Column(name="User_Contact")
	private long userContact;
	
	@Column(name="User_Gender")
	private String userGender;
	
	@Column(name="User_City")
	private String userCity;
	
	@Column(name="User_Email")
	private String userEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	private List<Product> products;       //one user buys many products.
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orders;			//one user can place many orders.
	
	@JoinColumn(name="feedback_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Feedback feedbackid;

	@JsonManagedReference
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Feedback getFeedback() {
		return feedbackid;
	}

	public void setFeedback(Feedback feedbackid) {
		this.feedbackid = feedbackid;
	}

	public User(int userId, String userName, int userAge, long userContact, String userGender, String userCity,
			String userEmail, Login login, List<Product> products, List<Order> orders, Feedback feedbackid) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userCity = userCity;
		this.userEmail = userEmail;
		this.login = login;
		this.products = products;
		this.orders = orders;
		this.feedbackid = feedbackid;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userContact="
				+ userContact + ", userGender=" + userGender + ", userCity=" + userCity + ", userEmail=" + userEmail
				+ ", login=" + login + ", products=" + products + ", orders=" + orders + ", feedbackid=" + feedbackid + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
