package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JobVacancyEntities;
import com.example.demo.service.JobVacancyService;

@RestController
public class JobVacancyController {
@Autowired
JobVacancyService js;
@PostMapping("savejobvacancy")
public List<JobVacancyEntities> savejobvacancy(@RequestBody List<JobVacancyEntities> je){
	return js.savejobvacancy(je);
}
@GetMapping("getjobvacancy")
public List<JobVacancyEntities> showjobvacancy(){
	return js.getjobvacancy();
}
@GetMapping("getjobBasedonSkills/{skill}")
public List<JobVacancyEntities> showJobbasedonskill(@PathVariable String skill){
	return js.getJobBasedonskill(skill);
}
@PutMapping("updatemode/{mode}/{id}")
public int updateMode(@PathVariable String mode,@PathVariable int id){
	return js.updatemode(mode, id);
}
@GetMapping("pagination/{pageno}/{pagesize}")
public List<JobVacancyEntities> pageing(@PathVariable int pageno,@PathVariable int pagesize){
	return js.pagination(pageno, pagesize);
}
@GetMapping("paginationandsorting/{pageno}/{pagesize}/{field}")
public List<JobVacancyEntities> paginationandsorting(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String field ){
	return js.paginationandsorting(pageno, pagesize, field);
}
@GetMapping("getJobLocation/{loc}")
public List<JobVacancyEntities> getJobLocation(@PathVariable String loc){
	return  js.getJobLocation(loc);
}
}
