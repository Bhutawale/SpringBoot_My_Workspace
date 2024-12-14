package com.example.restaurant_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int customerId;
	
	@NotBlank(message = "Customer Name Cannot be Blank!!")
	private String customerName;
	
	@NotBlank(message = "Customer Contact Cannot be Blank!!")
	@Size(max = 10,message = "Contact Number size must not be greater than 10 digits")
	private long customerContact;
	
	@NotBlank(message = "Please enter Order Id.")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Order> order;
	
	@NotBlank(message = "Please enter Rating Id.")
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Ratings rating;
	
	@NotBlank(message = "Please enter Bill Id.")
	@OneToOne
	@JoinColumn(name = "billId")
	private Bill bill;

	
	
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

	@JsonManagedReference
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@JsonManagedReference
	public Ratings getRating() {
		return rating;
	}

	public void setRating(Ratings rating) {
		this.rating = rating;
	}

	@JsonBackReference
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerContact="
				+ customerContact + ", order=" + order + ", rating=" + rating + ", bill=" + bill + "]";
	}

	public Customer(int customerId, String customerName, long customerContact, List<Order> order, Ratings rating,
			Bill bill) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.order = order;
		this.rating = rating;
		this.bill = bill;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
