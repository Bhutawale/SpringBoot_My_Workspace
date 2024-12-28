package com.revision.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	@NotEmpty(message = "Course name cannot be empty.")
	private String cname;
	@NotNull(message = "Course fee field cannot be empty.")
	private int cfee;
	@NotEmpty(message = "Course duration cannot be empty.")
	private String cduration;
}
