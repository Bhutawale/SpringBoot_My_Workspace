package com.microservice.user.Entity;

public class Order
{
	private int order_id;
		
	private String order_name;
	
	private int order_quantity;
	
	private int uid;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	
	public Order(int order_id, String order_name, int order_quantity, int uid) {
		super();
		this.order_id = order_id;
		this.order_name = order_name;
		this.order_quantity = order_quantity;
		this.uid = uid;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_name=" + order_name + ", order_quantity=" + order_quantity
				+ ", uid=" + uid + "]";
	}

	

	
}
