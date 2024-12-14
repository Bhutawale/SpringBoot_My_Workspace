package com.example.restaurant_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int productId;
	
	@NotBlank(message = "Product Category Cannot be Blank!!")
	private String productCategory;
	
	@NotBlank(message = "Product Name Cannot be Blank!!")
	private String productName;
	
	@NotBlank(message = "Enter Product Price")
	private double productPrice;
	
	private String productDesc; //No Validation is used here.
	
	@NotNull(message = "Please enter Order Id.")
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@JsonBackReference
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCategory=" + productCategory + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", order=" + order
				+ "]";
	}

	public Product(int productId, String productCategory, String productName, double productPrice, String productDesc,
			Order order) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.order = order;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}