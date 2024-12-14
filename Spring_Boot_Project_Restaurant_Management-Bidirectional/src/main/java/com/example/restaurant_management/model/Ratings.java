package com.example.restaurant_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ratings 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ratingId;
	
	@NotBlank(message = "Please enter your ratings.")
	private int rating;
	
	private String feedback; //No Validation is used here.
	
	@NotBlank(message = "Please enter Customer Id.")
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	
	
	
	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
		return "Ratings [ratingId=" + ratingId + ", rating=" + rating + ", feedback=" + feedback + ", customer="
				+ customer + "]";
	}

	public Ratings(int ratingId, int rating, String feedback, Customer customer) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.feedback = feedback;
		this.customer = customer;
	}

	public Ratings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}