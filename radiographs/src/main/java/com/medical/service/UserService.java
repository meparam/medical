package com.medical.service;

import com.medical.model.UserDTO;

/**
 * This service provides user management operations such as to check if the given user exits.
 * @author rahimbuneri
 *
 */
public interface UserService {

	/**
     * Finds a user entry by using the id given as a method parameter.
     * @param id    The id of the wanted user entry.
     * @return      The information of the requested user entry.
     * @throws Exception if no user entry is found with the given id.
     */
    UserDTO findById(String userName);

}
