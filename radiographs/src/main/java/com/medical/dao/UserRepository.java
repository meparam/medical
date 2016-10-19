package com.medical.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.medical.model.User;

public interface UserRepository extends Repository<User, String> {
	
	@Query("SELECT u FROM User u where u.userName = :userName and u.password = :password") 
    User authenticateUser(@Param("userName") String userName, @Param("password") String password);
}
