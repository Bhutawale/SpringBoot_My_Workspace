package com.example.restaurant_management.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Sell 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellId;
	
	private String sellDate;
	
	private double totalAmount;
		
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public int getSellId() {
		return sellId;
	}

	public void setSellId(int sellId) {
		this.sellId = sellId;
	}

	public String getSellDate() {
		return sellDate;
	}

	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Sell [sellId=" + sellId + ", sellDate=" + sellDate + ", totalAmount=" + totalAmount + ", customer="
				+ customer + "]";
	}

	public Sell(int sellId, String sellDate, double totalAmount, Customer customer) {
		super();
		this.sellId = sellId;
		this.sellDate = sellDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}

	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
