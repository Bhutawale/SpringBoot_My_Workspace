package com.example.restaurant_management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int orderId;
		
	@NotBlank(message = "Order Status cannot be Blank!!")
	private String orderStatus;
	
	@NotBlank(message = "PLease enter valid Order Date.")
	private String orderDate;
	
	@NotBlank(message = "Please enter Product Id.")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
	private List<Product> product;
	
	@NotBlank(message = "Please enter Customer Id.")
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@JsonManagedReference
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", product="
				+ product + ", customer=" + customer + "]";
	}

	public Order(int orderId, String orderStatus, String orderDate, List<Product> product, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.product = product;
		this.customer = customer;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}