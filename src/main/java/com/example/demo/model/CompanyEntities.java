package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CompanyEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int companyid;
  private String companyName;
  private String  companyLocation;
  private int vacancies;
  private String salary;
public CompanyEntities() {
	super();
	// TODO Auto-generated constructor stub
}
public CompanyEntities(int companyid, String companyName, String companyLocation, int vacancies, String salary) {
	super();
	this.companyid = companyid;
	this.companyName = companyName;
	this.companyLocation = companyLocation;
	this.vacancies = vacancies;
	this.salary = salary;
}
public int getCompanyid() {
	return companyid;
}
public void setCompanyid(int companyid) {
	this.companyid = companyid;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getCompanyLocation() {
	return companyLocation;
}
public void setCompanyLocation(String companyLocation) {
	this.companyLocation = companyLocation;
}
public int getVacancies() {
	return vacancies;
}
public void setVacancies(int vacancies) {
	this.vacancies = vacancies;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}

  
}
