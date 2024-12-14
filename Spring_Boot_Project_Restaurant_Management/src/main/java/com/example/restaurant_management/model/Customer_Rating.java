package com.example.restaurant_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer_Rating 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	
	private int rating;

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

	@Override
	public String toString() {
		return "Customer_Rating [ratingId=" + ratingId + ", rating=" + rating + "]";
	}

	public Customer_Rating(int ratingId, int rating) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
	}

	public Customer_Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
