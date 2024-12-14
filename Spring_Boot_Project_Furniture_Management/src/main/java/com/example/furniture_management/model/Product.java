package com.example.furniture_management.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Product_Details")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private int productId;
	
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Product_Quantity")
	private int productQuantity;
	
	@Column(name="Product_Price")
	private double productPrice;
	
	@Column(name="Product_Description")
	private String productDesc;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", user=" + user
				+ "]";
	}

	public Product(int productId, String productName, int productQuantity, double productPrice, String productDesc,
			User user) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.user = user;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	
	
	
	
	
}
