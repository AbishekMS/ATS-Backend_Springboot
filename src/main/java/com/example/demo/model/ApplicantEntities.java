package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Applicant")
public class ApplicantEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
 private int applicantId;
	//@Column(name="Name")
 private String name;	
 private String qualification;
 private String skills;	
 private float cgpa;
	@Column(name="WORK_EXP")
 private String jobExperience;
 private long jobId;
 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="personal_info_id")
 private ApplicantPersonal ap;
public ApplicantEntities(int applicantId, String name, String qualification, String skills, float cgpa,
		String jobExperience, long jobId, ApplicantPersonal ap) {
	super();
	this.applicantId = applicantId;
	this.name = name;
	this.qualification = qualification;
	this.skills = skills;
	this.cgpa = cgpa;
	this.jobExperience = jobExperience;
	this.jobId = jobId;
	this.ap = ap;
}
public ApplicantEntities() {
	super();
	// TODO Auto-generated constructor stub
}
public int getApplicantId() {
	return applicantId;
}
public void setApplicantId(int applicantId) {
	this.applicantId = applicantId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public float getCgpa() {
	return cgpa;
}
public void setCgpa(float cgpa) {
	this.cgpa = cgpa;
}
public String getJobExperience() {
	return jobExperience;
}
public void setJobExperience(String jobExperience) {
	this.jobExperience = jobExperience;
}
public long getJobId() {
	return jobId;
}
public void setJobId(long jobId) {
	this.jobId = jobId;
}
public ApplicantPersonal getAp() {
	return ap;
}
public void setAp(ApplicantPersonal ap) {
	this.ap = ap;
}
 
}
