package com.medical.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a mapper class that is used to transform {@link Radiograph} objects
 * into {@link RadiographDTO} objects.
 * @author rahimbuneri
 */
public final class RadiographMapper {

    /**
     * Transforms the list of {@link Radiograph} objects given as a method parameter
     * into a list of {@link RadiographDTO} objects and returns the created list.
     *
     * @param entities
     * @return
     */
	public static List<RadiographDTO> mapEntitiesToDTOs(Iterable<Radiograph> entities) {
        
		List<RadiographDTO> dtos = new ArrayList<RadiographDTO>();

        for(Radiograph p : entities){
        	dtos.add(mapEntityToDTO(p));
        }        

        return dtos;
    }

    /**
     * Transforms the {@link Radiograph} entity given as a method parameter into a
     * {@link RadiographDTO} DTO and returns the created object. It includes the embedded objects user and patient
     * 		
     * @param	entity
     * @return	DTO
     */
    public static RadiographDTO mapEntityToDTO(Radiograph entity) {
        
    	// mapping user to userDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(entity.getUser().getUserName());
        userDTO.setName(entity.getUser().getName());
        userDTO.setEmail(entity.getUser().getEmail());
        
        // mapping patient to patientDTO
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setSsn(entity.getPatient().getSsn());
        patientDTO.setName(entity.getPatient().getName());
        
        // mapping radiograph to radiographDTO
        RadiographDTO radiographDTO = new RadiographDTO();
        radiographDTO.setId(entity.getId());
        radiographDTO.setDesc(entity.getDesc());
        radiographDTO.setReason(entity.getReason());
        radiographDTO.setUserDTO(userDTO);
        radiographDTO.setPatientDTO(patientDTO);
        
        return radiographDTO;
    }
}