package com.example.restaurant_management.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int billId;
	
	@NotBlank(message = "Bill Date Cannot be Blank!!")
	private String billDate;
	
	@NotBlank(message = "Total Bill Cannot be Blank!!")
	private double totalbillAmount;
	
	@NotBlank(message = "Please enter Customer Id.")
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "bill")
	private Customer customer;
	
	@NotBlank(message = "Please enter Admin Id")
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public double getTotalbillAmount() {
		return totalbillAmount;
	}

	public void setTotalbillAmount(double totalbillAmount) {
		this.totalbillAmount = totalbillAmount;
	}

	@JsonManagedReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonBackReference
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalbillAmount=" + totalbillAmount
				+ ", customer=" + customer + ", admin=" + admin + "]";
	}

	public Bill(int billId, String billDate, double totalbillAmount, Customer customer, Admin admin) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalbillAmount = totalbillAmount;
		this.customer = customer;
		this.admin = admin;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}