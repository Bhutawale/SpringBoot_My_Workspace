package com.example.employeeproject.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name Cannot be Blank!!")
	@Size(min = 3,max = 10,message = "Name Length must be between 3 and 10 in length!!")
	private String name;
	
	@Min(value = 10000,message = "Salary must be atleast 10000!!")
	private int salary;
	
	@NotBlank(message = "Company Cannot be Blank!!")
	@Size(min=3, max=20,message = "Company Name must be between 3 and 20 in length!!")
	private String company_name;
	
	@NotBlank(message = "City Cannot be Blank!!")
	@Size(min=3, max=20,message = "City Name must be between 3 and 10 in length!!")
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> exp;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int salary, String company_name, String city, List<Experience> exp) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.company_name = company_name;
		this.city = city;
		this.exp = exp;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Experience> getExp() {
		return exp;
	}

	public void setExp(List<Experience> exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", company_name=" + company_name
				+ ", city=" + city + ", exp=" + exp + "]";
	}
	
	
	
}
