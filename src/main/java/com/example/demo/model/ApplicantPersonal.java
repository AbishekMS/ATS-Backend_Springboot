package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ApplicantPersonal {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String address;
   private long contactNo;
   private String email;
   private String status;
   private String clg;
public ApplicantPersonal(int id, String address, long contactNo, String email, String status, String clg) {
	super();
	this.id = id;
	this.address = address;
	this.contactNo = contactNo;
	this.email = email;
	this.status = status;
	this.clg = clg;
}
public ApplicantPersonal() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getContactNo() {
	return contactNo;
}
public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getClg() {
	return clg;
}
public void setClg(String clg) {
	this.clg = clg;
}
   
   
}
