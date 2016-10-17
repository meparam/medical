package com.medical.model;

/**
 * This class is a mapper class that is used to transform {@link User} objects
 * into {@link UserDTO} objects.
 * @author rahimbuneri
 */
public final class UserMapper {
    
    /**
     * Transforms the {@link User} object given as a method parameter into a
     * {@link UserDTO} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static UserDTO mapEntityToDTO(User entity) {
        UserDTO dto = new UserDTO();

        dto.setUserName(entity.getUserName());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        
        return dto;
    }
}