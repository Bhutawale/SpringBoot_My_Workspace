package com.microservice.user.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name of User cannot be Blank!!")
	@Size(min = 3,max = 20,message = "Name must be greater than 3 and less than 20!!")
	private String name;
	@Transient
	private List<Order> order;

	public User(int id,
			@NotBlank(message = "Name of User cannot be Blank!!") @Size(min = 3, max = 20, message = "Name must be greater than 3 and less than 20!!") String name,
			List<Order> order) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", order=" + order + "]";
	}
	
}
