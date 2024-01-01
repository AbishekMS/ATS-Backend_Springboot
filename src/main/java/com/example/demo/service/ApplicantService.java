	package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.model.ApplicantEntities;

import com.example.demo.model.JobVacancyEntities;
import com.example.demo.repository.ApplicantRepos;
import com.example.demo.repository.JobVacancyRepos;

import jakarta.transaction.Transactional;

@Service
public class ApplicantService {
 @Autowired
 ApplicantRepos ar;
@Autowired
JobVacancyRepos jr;
 @Transactional
 public void fillJobIdBasedonSkills() {
	 List<ApplicantEntities> applicants=ar.findAll();
	 List<JobVacancyEntities> jobvacancies=jr.findAll();
	 for(ApplicantEntities applicant:applicants) {
		 for(JobVacancyEntities jobvacancy:jobvacancies) {
			 if(skillmatch(applicant.getSkills(),jobvacancy.getSkill())) {
				 applicant.setJobId(jobvacancy.getJobId());
				 break;
			 }
		 }
	 }
 }
 private boolean skillmatch(String applicantskill,String jobskill) {
	/* List<String> applicantSkillList = Arrays.asList(applicantskill.split(","));
    List<String> jobVacancySkillList = Arrays.asList(jobskill.split(","));*/
     if(applicantskill.equalsIgnoreCase(jobskill)) {
    	 return true;
     }
     return false;
 }
 public List<ApplicantEntities> saveinfo(List<ApplicantEntities> al){
	 return ar.saveAll(al);
 }
 public List<ApplicantEntities> showinfo(){
	 return ar.findAll();
 }
 public String updateinfobyid(ApplicantEntities ae,int applicantId) {
	 Optional<ApplicantEntities> applicantInformation = ar.findById(applicantId);
		if(applicantInformation.isPresent()) {
			ApplicantEntities ea = applicantInformation.get();
			ea.setCgpa(ae.getCgpa());
			ea.setJobExperience(ae.getJobExperience());
			ea.setQualification(ae.getQualification());
			ea.setName(ae.getName());
			ar.saveAndFlush(ea);
			
			return ("Data is found");
		}else {
			return ("Data is Not Available");
		}
 }
 public String updateinfobyparam(ApplicantEntities ae,int id) {
		Optional<ApplicantEntities> applicantInformation = ar.findById(id);
		if(applicantInformation.isPresent()) {
			ApplicantEntities ea = applicantInformation.get();
			ea.setCgpa(ae.getCgpa());
			ea.setJobExperience(ae.getJobExperience());
			ea.setQualification(ae.getQualification());
			ea.setName(ae.getName());
			ar.saveAndFlush(ea);
			
			return ("Data is found");
		}else {
			return ("Data is Not Available");
		}
		
	}
 public String deleteinfo(int id) {
	ApplicantEntities as = ar.findById(id).orElse(null);
	 if(as!=null) {
		 ar.delete(as);
		 return "Applicant Id no:"+id+" ,deleted successfully";
	 }
	 else return "Invalid id";
 }
public List<ApplicantEntities> sortinfo(String s){
	return ar.findAll(Sort.by(s).descending().and(Sort.by("applicantId")));
}

public Optional<ApplicantEntities> showbyid(int id) {
	
	return ar.findById(id);
}
public void deletebybody(ApplicantEntities ae) {
	// TODO Auto-generated method stub
	ar.delete(ae);
	
}
public ApplicantEntities updatebybody(ApplicantEntities ae) {
	// TODO Auto-generated method stub
	return ar.saveAndFlush(ae);
	
}

public ApplicantEntities saveApplicantinfo(ApplicantEntities al) {
	// TODO Auto-generated method stub
	return ar.save(al);
}
}
