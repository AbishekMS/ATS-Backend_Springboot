package com.example.demo.model;


import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="job_vacancy")
public class JobVacancyEntities {
	@Id
	@GeneratedValue(generator = "id_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="id_gen",sequenceName = "vacancy_id_seq",initialValue = 101,allocationSize = 1)
 private int jobId;
 private String jobDescription;
 private String jobTitle;
 private String experience;
 private String skill;
 private String mode;
 @OneToMany(cascade = CascadeType.ALL)
 @Fetch(FetchMode.JOIN)
 @JoinColumn(name="empId")
 private Set<CompanyEntities> comp;
public JobVacancyEntities(int jobId, String jobDescription, String jobTitle, String experience, String skill,
		String mode, Set<CompanyEntities> comp) {
	super();
	this.jobId = jobId;
	this.jobDescription = jobDescription;
	this.jobTitle = jobTitle;
	this.experience = experience;
	this.skill = skill;
	this.mode = mode;
	this.comp = comp;
}
public JobVacancyEntities() {
	super();
	// TODO Auto-generated constructor stub
}
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}
public Set<CompanyEntities> getComp() {
	return comp;
}
public void setComp(Set<CompanyEntities> comp) {
	this.comp = comp;
}
 

 
}
