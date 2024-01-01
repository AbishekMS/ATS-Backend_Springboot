package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InterviewEntities;
import com.example.demo.service.InterviewService;


@RestController
@CrossOrigin
public class InterviewController {
	@Autowired
	InterviewService is;
	@GetMapping("getinterviewschedule")
	public List<InterviewEntities> getinterviews(){
		return is.getInterviews();
	}
	@DeleteMapping("deleteinterview/{id}")
    public String deletebyidInt(@PathVariable int id) {
		is.del(id);
		return "deleted";
	}

}
