package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login 
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int loginid;
  private int   password;
  private String logintye;
public int getLoginid() {
	return loginid;
}
public void setLoginid(int loginid) {
	this.loginid = loginid;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public String getLogintye() {
	return logintye;
}
public void setLogintye(String logintye) {
	this.logintye = logintye;
}
@Override
public String toString() {
	return "Login [loginid=" + loginid + ", password=" + password + ", logintye=" + logintye + "]";
}  

}
