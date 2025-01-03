package com.revision.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	@NotEmpty(message = "City field cannot be empty.")
	private String acity;
	
	@NotEmpty(message = "Country field cannot be empty.")
	private String acountry;
}
