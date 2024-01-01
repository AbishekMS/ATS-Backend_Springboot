package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApplicantEntities;
import com.example.demo.model.HrEntities;
import com.example.demo.service.Hrservice;

import jakarta.annotation.security.PermitAll;

@RestController
@CrossOrigin
public class HrController {
@Autowired
Hrservice hs;
@PostMapping("addhrinfo")
public List<HrEntities> savehrdata(@RequestBody List<HrEntities> he){
	return hs.savehrinfo(he); 
}
@PostMapping("addhrindividually")
public HrEntities savehr(@RequestBody HrEntities he) {
	return hs.savehrindividually(he);
}
@GetMapping("getInterviews")
public String setinterview() {
	hs.creatingInterviewforMatchingApplicants();
	return  "Interview Scheduled";
}
@GetMapping("getapplicant/{appid}")
public List<ApplicantEntities> getapplicant(@PathVariable int appid ){
	return hs.getapplicantinfo(appid);
}
@GetMapping("gethrjobid")
public String filljobidbyoffer() {
	hs.filljobidbyoffer();
	return "HR jobId updated";
}
@GetMapping("gethrinfo")
public List<HrEntities> showhrdata(){
	return hs.showhrinfo();
	}
@GetMapping("gethrbycomp/{comp}")
public List<HrEntities> showhrcomp(@PathVariable String comp){
	return hs.getbyhrcomp(comp);
}
@PutMapping("updatehrbyid/{id}")
public String updatehr( @PathVariable int id, @RequestBody HrEntities he ) {
	return hs.updatehrbyid(he,id);
}
@DeleteMapping("deletehr/{id}/{name}")
public int deleteHr(@PathVariable int id,@PathVariable String name) {
	return hs.deleteHr(id, name);
}
@DeleteMapping("deletebyhr/{id}")
public String deletehrBYid(@PathVariable int id) {
	hs.deletebyid(id);
	return "deleted";
}
@PutMapping("updateoffer/{oldoffer}/{newoffer}")
public String updateOffer(@PathVariable String oldoffer,@PathVariable String newoffer) {
	hs.updateoffer(oldoffer,newoffer);
			return "updated";
}
@GetMapping("fillapplicantid")
public String matchApplicant() {
	hs.matchApplicantandstoreApplicantId();
	return "stored";
}

}
