package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="hr")
public class HrEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int hrId;
 private String hrName;
 private String hrCompany;
 private String hrEmail;
 private String hrPassword;
 private String offers;
 private int jobid;
 @Column(name="hr_applicant_id")
 private List<Integer> hrAppicantId=new ArrayList<>();
public int getHrId() {
	return hrId;
}
public void setHrId(int hrId) {
	this.hrId = hrId;
}
public String getHrName() {
	return hrName;
}
public void setHrName(String hrName) {
	this.hrName = hrName;
}
public String getHrCompany() {
	return hrCompany;
}
public void setHrCompany(String hrCompany) {
	this.hrCompany = hrCompany;
}
public String getHrEmail() {
	return hrEmail;
}
public void setHrEmail(String hrEmail) {
	this.hrEmail = hrEmail;
}
public String getHrPassword() {
	return hrPassword;
}
public void setHrPassword(String hrPassword) {
	this.hrPassword = hrPassword;
}
public String getOffers() {
	return offers;
}
public void setOffers(String offers) {
	this.offers = offers;
}
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public List<Integer> getHrAppicantId() {
	return hrAppicantId;
}
public void setHrAppicantId(List<Integer> hrAppicantId) {
	this.hrAppicantId = hrAppicantId;
}
public HrEntities() {
	super();
	// TODO Auto-generated constructor stub
}
public HrEntities(int hrId, String hrName, String hrCompany, String hrEmail, String hrPassword, String offers,
		int jobid, List<Integer> hrAppicantId) {
	super();
	this.hrId = hrId;
	this.hrName = hrName;
	this.hrCompany = hrCompany;
	this.hrEmail = hrEmail;
	this.hrPassword = hrPassword;
	this.offers = offers;
	this.jobid = jobid;
	this.hrAppicantId = hrAppicantId;
}
 
}
