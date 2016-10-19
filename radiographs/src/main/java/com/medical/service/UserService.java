package com.medical.service;

import com.medical.model.UserDTO;

/**
 * This service provides user management operations such as to check if the given user having userName and password exits.
 * @author rahimbuneri
 *
 */
public interface UserService {

	/**
     * Checks a user in the database with given credentials
     * @param	userName    The userName of the required user.
     * @param	password    The password of the required user.
     * @return	userDTO if exists otherwise.
     * @throws Exception if no user is found with the given credentials.
     */
	public UserDTO authenticateUser(String userName, String password);

}
