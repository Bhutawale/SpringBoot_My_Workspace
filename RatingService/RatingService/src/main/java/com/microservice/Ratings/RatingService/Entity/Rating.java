package com.microservice.Ratings.RatingService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	private int uid;
	private int hid;
	private int rating;
	private String feedback;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
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
	public Rating(int rid, int uid, int hid, int rating, String feedback) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.hid = hid;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ratings [rid=" + rid + ", uid=" + uid + ", hid=" + hid + ", rating=" + rating + ", feedback=" + feedback
				+ "]";
	}
	
	
}
