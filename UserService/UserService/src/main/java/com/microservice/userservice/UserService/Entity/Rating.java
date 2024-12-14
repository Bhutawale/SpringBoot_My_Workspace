package com.microservice.userservice.UserService.Entity;

public class Rating {
	private int rid;
	private int uid;
	private int hid;
	private int rating;
	private String feedback;
	@Override
	public String toString() {
		return "Rating [rid=" + rid + ", uid=" + uid + ", hid=" + hid + ", rating=" + rating + ", feedback=" + feedback
				+ "]";
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int rid, int uid, int hid, int rating, String feedback) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.hid = hid;
		this.rating = rating;
		this.feedback = feedback;
	}
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
}
