package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.JobVacancyEntities;

import jakarta.transaction.Transactional;

public interface JobVacancyRepos extends JpaRepository<JobVacancyEntities, Integer> {

	
	@Query(value="select * from job_vacancy  where skill LIKE %:s% ",nativeQuery = true)
	public List<JobVacancyEntities> getJobBySkill(String s);
	@Modifying
	@Transactional
	@Query(value="update job_vacancy set mode=?1 where job_id=?2  ",nativeQuery = true )
	public int updateMode(String mode,int id);
	@Query(value="select jv from job_vacancy jv join company_entities c where c.company_location=:s",nativeQuery = true)
	public List<JobVacancyEntities> getJobByLocation(String s);
	
}
