package com.microservice.order.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
		
	@NotBlank(message = "Name Cannot be Blank.")
	@Size(min = 3, max = 20,message = "Name Cannot be less then 3 Characters and more than 20 Characters!!")
	private String order_name;
	
	@NotNull(message = "Quantity Cannot be Blank.")
	@Min(value = 1,message = "Atleast one order has to be placed!!")
	@Max(value = 10,message = "Max 10 orders can be placed!!")
	private Integer order_quantity;
	
	@NotNull(message = "User Id Cannot be Blank.")
	private Integer uid;
	
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

	public Order(int order_id,
			@NotBlank(message = "Name Cannot be Blank.") @Size(min = 3, max = 20, message = "Name Cannot be less then 3 Characters and more than 20 Characters!!") String order_name,
			@NotBlank(message = "Quantity Cannot be Blank.") @Size(min = 1, message = "Atleast one order has to be placed!!") int order_quantity,
			@NotBlank(message = "User Id Cannot be Blank.") int uid) {
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
