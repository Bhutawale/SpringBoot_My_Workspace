package com.example.restaurant_management.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


@Entity
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
		
	private String orderStatus;
	
	private String orderDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> product;

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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", product="
				+ product + "]";
	}

	public Order(int orderId, String orderStatus, String orderDate, List<Product> product) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.product = product;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
