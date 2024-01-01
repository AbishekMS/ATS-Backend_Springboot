package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.model.JobVacancyEntities;
import com.example.demo.repository.JobVacancyRepos;

@Service
public class JobVacancyService {
 @Autowired
 JobVacancyRepos jr;
 public List<JobVacancyEntities> savejobvacancy( @RequestBody List<JobVacancyEntities> je){
	 return jr.saveAll(je);
 }
 public List<JobVacancyEntities> getjobvacancy(){
	 return jr.findAll();
 }
public List<JobVacancyEntities> getJobBasedonskill(String skill) {
	
	return jr.getJobBySkill(skill);
}
public int updatemode(String mode,int id){
	return jr.updateMode(mode, id);
}
public List<JobVacancyEntities> paginationandsorting(int pageno,int pagesize,String field){
	Page<JobVacancyEntities> page = jr.findAll(PageRequest.of(pageno, pagesize, Sort.by(field).descending()));
	return page.getContent();

}
public List<JobVacancyEntities> pagination(int pageno,int pagesize){
	Page<JobVacancyEntities> page=jr.findAll(PageRequest.of(pageno, pagesize));
	return page.getContent();
	
}
public List<JobVacancyEntities> getJobLocation(String loc){
	return jr.getJobByLocation(loc);
}
 
}
