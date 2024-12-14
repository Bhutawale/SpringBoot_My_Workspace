package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Admin 
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String aname;
  private String uname;
  private String password;
  
  @OneToOne(cascade=CascadeType.ALL)
  private Login login;
  
  @OneToMany(cascade=CascadeType.ALL)
  private List<Dealer> dealer;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAname() {
	return aname;
}

public void setAname(String aname) {
	this.aname = aname;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Login getLogin() {
	return login;
}

public void setLogin(Login login) {
	this.login = login;
}

public List<Dealer> getDealer() {
	return dealer;
}

public void setDealer(List<Dealer> dealer) {
	this.dealer = dealer;
}

@Override
public String toString() {
	return "Admin [id=" + id + ", aname=" + aname + ", uname=" + uname + ", password=" + password + ", login=" + login
			+ ", dealer=" + dealer + "]";
}
  

  
}
