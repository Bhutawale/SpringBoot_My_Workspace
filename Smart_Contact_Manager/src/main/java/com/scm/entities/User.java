package com.scm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name field Cannot be Blank")
	@Size(min = 3,max = 20,message = "Name size must be between 3 and 20")
	private String name;
	
	@NotBlank(message = "Email field Cannot be Blank")
	@Email(message = "Invalid Email Address")
	@Column(unique =true )
	private String email;
	
	@NotBlank(message = "Password field Cannot be Blank")
	@Size(min = 3,max = 100,message = "Password size must be between 3 and 20")
	private String password;
	
	private String role;
	
	private boolean enabled;
	
	private String imageUrl;
	@Column(length = 500)
	
	@NotBlank(message = "About field Cannot be Blank")
	@Size(min = 10,max = 100,message = "About size must be between 10 and 100")
	private String about;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Contacts> contacts;
 	
	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", about=" + about + ", contacts=" + contacts
				+ "]";
	}
	
	
	
	
}
