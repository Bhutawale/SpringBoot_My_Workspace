package com.revision.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	@NotEmpty(message = "Student name field cannot be empty.")
	@Size(min = 3,max = 20,message = "Student name must be between 3 to 20 characters only.")
	private String name;
	
	@NotNull(message = "Student age field cannot be empty.")
	@Min(value = 20, message = "Age must be at least 20.")
	@Max(value = 40, message = "Age must not exceed 40.")
	private int age;
	
	@NotEmpty(message = "Student gender field cannot be empty.")
	private String gender;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Course course;
	
}
