package com.medical.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.medical.model.Radiograph;

public interface RadiographRepository extends Repository<Radiograph, Long> {	
	
	Radiograph save(Radiograph newRadiograph);
	
	@Query("SELECT r FROM Radiograph r where r.user.userName = :userName") 
	List<Radiograph> getUserRadiographs(@Param("userName") String userName);
}
