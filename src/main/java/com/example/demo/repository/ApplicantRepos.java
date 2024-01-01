package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.ApplicantEntities;

public interface ApplicantRepos extends JpaRepository<ApplicantEntities, Integer> {

	
}
