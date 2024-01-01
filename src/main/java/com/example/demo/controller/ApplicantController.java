	package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApplicantEntities;
import com.example.demo.model.ApplicantPersonal;
import com.example.demo.service.ApplicantService;

@RestController
@CrossOrigin
public class ApplicantController {
@Autowired
ApplicantService as;
@PostMapping("addinfoindividually")
public ApplicantEntities addinfo(@RequestBody ApplicantEntities al) {
	return as.saveApplicantinfo(al);
}
@PostMapping("addinfo")
public List<ApplicantEntities> add(@RequestBody List<ApplicantEntities> al){
	return as.saveinfo(al);
}
@GetMapping("filljobid")
public String fillJobIdBasedonSkills() {
	as.fillJobIdBasedonSkills();
	return "Job IDs filled based on skills";
}
@GetMapping("getinfo") 
public List<ApplicantEntities> show(){
	return as.showinfo();
	}

@PutMapping("updatebyid/{applicantId}")
public String update(@RequestBody ApplicantEntities ae,@PathVariable int applicantId) {
	return  as.updateinfobyid(ae,applicantId);
}

@PutMapping("updatebody")
public ApplicantEntities updatebody(@RequestBody ApplicantEntities ae) {
	return as.updatebybody(ae);
}
@PutMapping("updatebyparam")
public String updatebyparam(@RequestBody ApplicantEntities ae, @RequestParam int id) {
	return as.updateinfobyparam(ae,id);
}
@DeleteMapping("delete/{id}")
public String delete(@PathVariable int id) {
	 return as.deleteinfo(id);
	 
}
@GetMapping("sort/{name}")
public List<ApplicantEntities> sort(@PathVariable String name){
	return as.sortinfo(name);
}
@DeleteMapping("deletebybody")
public List<ApplicantEntities> deletebody(@RequestBody ApplicantEntities ae){
	as.deletebybody(ae);
	return as.showinfo();
	}
@GetMapping("showbyid")
public Optional<ApplicantEntities> showByid(@RequestParam int id) {
	return as.showbyid(id);
}/*
@GetMapping("getPersonalinfo/{id}")
public List<ApplicantPersonal> getPersonalinfo(@PathVariable int id){
	return as.getPersonalinfo(id);
}*/
}
