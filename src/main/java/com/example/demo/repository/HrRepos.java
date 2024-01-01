package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ApplicantEntities;
import com.example.demo.model.HrEntities;

import jakarta.transaction.Transactional;

public interface HrRepos extends JpaRepository<HrEntities, Integer>{
    
	@Query(value="select * from hr where hr_company=:s",nativeQuery = true)
	List<HrEntities> getbycomp(@Param("s") String comp);

	@Query(value="select * from applicant where job_id=:id",nativeQuery = true)
	List<ApplicantEntities> findapplicants(int id);
		
   @Modifying
   @Transactional
   @Query(value="delete from hr where hr_id=:sn or hr_name=:name",nativeQuery = true)
   public int deletehr(@Param("sn") int id,@Param("name") String n);
@Modifying
@Transactional
@Query(value="update hr set offers=?2 where offers=?1",nativeQuery = true)
public void updateOffer(String oldoffer, String newoffer);


@Query(value="select a.id from applicant a where a.job_id=:jobid",nativeQuery = true)
public List<Integer> findmatchingapplicants(int jobid);

}
