package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.InterviewEntities;

public interface InterviewRepos extends JpaRepository<InterviewEntities, Integer> {


	

}
