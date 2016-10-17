package com.medical.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.UserRepository;
import com.medical.model.User;
import com.medical.model.UserDTO;
import com.medical.model.UserMapper;

/**
 * This service provides operations for managing patient records.
 * @author rahimbuneri
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
			
	@Transactional(readOnly = true)
    @Override
    public UserDTO findById(String userName) {
        
		LOGGER.info("Finding user by id = " + userName);

        User user = userRepository.findOne(userName);
        
        LOGGER.info("Found user : " + user);

        return UserMapper.mapEntityToDTO(user);
    }
	
	
    
}
