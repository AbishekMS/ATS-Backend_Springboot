package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InterviewEntities;
import com.example.demo.repository.InterviewRepos;

@Service
public class InterviewService {
@Autowired 
InterviewRepos ir;

public List<InterviewEntities> getInterviews() {
	// TODO Auto-generated method stub
	return ir.findAll();
}

public void del(int id) {
	// TODO Auto-generated method stub
	ir.deleteById(id);
	
}


}
