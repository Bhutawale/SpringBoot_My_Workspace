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
public class Customer 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String customerName;
	
	private long customerContact;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> order;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer_Rating rating;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Customer_Rating getRating() {
		return rating;
	}

	public void setRating(Customer_Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerContact="
				+ customerContact + ", order=" + order + ", rating=" + rating + "]";
	}

	public Customer(int customerId, String customerName, long customerContact, List<Order> order,
			Customer_Rating rating) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.order = order;
		this.rating = rating;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
