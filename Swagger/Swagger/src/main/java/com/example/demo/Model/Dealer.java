package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dealer 
{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int did;
   private String dname;
   private int mobno;
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public int getMobno() {
	return mobno;
}
public void setMobno(int mobno) {
	this.mobno = mobno;
}
@Override
public String toString() {
	return "Dealer [did=" + did + ", dname=" + dname + ", mobno=" + mobno + "]";
}
   
   
}
