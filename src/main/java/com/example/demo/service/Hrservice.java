package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.ApplicantEntities;
import com.example.demo.model.HrEntities;
import com.example.demo.model.InterviewEntities;
import com.example.demo.model.JobVacancyEntities;
import com.example.demo.repository.ApplicantRepos;
import com.example.demo.repository.HrRepos;
import com.example.demo.repository.InterviewRepos;
import com.example.demo.repository.JobVacancyRepos;

import jakarta.transaction.Transactional;

@Service
public class Hrservice {
 @Autowired
 HrRepos hr;
 @Autowired
 JobVacancyRepos jr;
 @Autowired
 InterviewRepos ie;
 @Autowired
 ApplicantRepos app;
 @Transactional
 public void creatingInterviewforMatchingApplicants() {
	 List<HrEntities> allhrpos=hr.findAll();
	 LocalDate currentDate=LocalDate.now();
	 LocalDate maxInterviewDate=currentDate.plusMonths(3);
	 for(HrEntities he:allhrpos) {
		 List<Integer> matchingApplicantId=hr.findmatchingapplicants(he.getJobid());
		 for(int id:matchingApplicantId) {
			 ApplicantEntities applicant=app.findById(id).orElse(null);
			 if(applicant!=null) {
				 InterviewEntities interview=new InterviewEntities();
				 LocalDate randominterviewdate=generateRandomDate(currentDate,maxInterviewDate);
				 interview.setLink("http://google.meet/fof-jsu-jri");
				 interview.setInterviewdate(randominterviewdate);
				 interview.setHr(he);
				 interview.setApplicant(applicant);
				 ie.save(interview);
			 }
		 }
	 }
 }
 private LocalDate generateRandomDate(LocalDate startDate,LocalDate endDate) {
	 long startEpochDay = startDate.toEpochDay();
     long endEpochDay = endDate.toEpochDay();
     long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
     return LocalDate.ofEpochDay(randomEpochDay);
 }
 
 


 @Transactional
 public void matchApplicantandstoreApplicantId() {
		
		List<HrEntities> hes=hr.findAll();
		for(HrEntities he:hes) {
		
			 List<Integer>matchingApplicantIds=hr.findmatchingapplicants(he.getJobid());
			 he.setHrAppicantId(matchingApplicantIds);
			 hr.save(he);
		
		}
 }
 
 @Transactional
 public void filljobidbyoffer() {
	 List<HrEntities> he=hr.findAll();
	 List<JobVacancyEntities> je=jr.findAll();
	 for(HrEntities h:he) {
		 for(JobVacancyEntities job:je) {
			 if(offersmatch(job.getJobDescription(),h.getOffers())) {
				 h.setJobid(job.getJobId());
				 break;
			 }
		 }
	 }
 }
 private boolean offersmatch(String description,String offers) {
	 if(description.equalsIgnoreCase(offers)) {
		 return true;
	 }
	 return false;
 }
 @Transactional
 public List<ApplicantEntities> getapplicantinfo(int id){
	 return hr.findapplicants(id);
 }
 public List<HrEntities> savehrinfo(List<HrEntities> he){
	 return hr.saveAll(he);
 }
 public List<HrEntities> showhrinfo(){
	 return hr.findAll();
 }
 public List<HrEntities> getbyhrcomp(String comp){
	 return hr.getbycomp(comp);
 }
public String updatehrbyid(HrEntities he, int id) {
	Optional<HrEntities> hrinfo=hr.findById(id);
	if(hrinfo.isPresent()) {
		HrEntities ea=hrinfo.get();
		ea.setHrCompany(he.getHrCompany());
		ea.setHrEmail(he.getHrEmail());
		ea.setHrName(he.getHrName());
		ea.setHrPassword(he.getHrPassword());
		ea.setOffers(he.getOffers());
		hr.saveAndFlush(ea);
		return "Updated successfully";
	}
	return "HR not exist";
}

public int deleteHr(int id,String name) {
	return hr.deletehr(id, name);
}
public void updateoffer(String oldoffer, String newoffer) {
	// TODO Auto-generated method stub
	 hr.updateOffer(oldoffer,newoffer);
}
public HrEntities savehrindividually(HrEntities he) {
	// TODO Auto-generated method stub
	return hr.save(he);
}
public void deletebyid(int id) {
	// TODO Auto-generated method stub
	 hr.deleteById(id);;
}




}

