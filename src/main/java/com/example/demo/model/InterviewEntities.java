package com.example.demo.model;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="interview")
public class InterviewEntities {
 @Id
 @GeneratedValue(generator = "id_interview",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="id_interview",sequenceName = "interview_id_seq",initialValue = 901,allocationSize = 1)
 private int interviewid;
@ManyToOne
private HrEntities hr;
@ManyToOne 
private ApplicantEntities applicant;
private LocalDate interviewdate;
private String link;
public int getInterviewid() {
	return interviewid;
}
public void setInterviewid(int interviewid) {
	this.interviewid = interviewid;
}
public HrEntities getHr() {
	return hr;
}
public void setHr(HrEntities hr) {
	this.hr = hr;
}
public ApplicantEntities getApplicant() {
	return applicant;
}
public void setApplicant(ApplicantEntities applicant) {
	this.applicant = applicant;
}
public LocalDate getInterviewdate() {
	return interviewdate;
}
public void setInterviewdate(LocalDate interviewdate) {
	this.interviewdate = interviewdate;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public InterviewEntities(int interviewid, HrEntities hr, ApplicantEntities applicant, LocalDate interviewdate,
		String link) {
	super();
	this.interviewid = interviewid;
	this.hr = hr;
	this.applicant = applicant;
	this.interviewdate = interviewdate;
	this.link = link;
}
public InterviewEntities() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
}
