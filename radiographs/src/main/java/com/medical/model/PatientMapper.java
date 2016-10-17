package com.medical.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a mapper class that is used to transform {@link Patient} objects
 * into {@link PatientDTO} objects.
 * @author rahimbuneri
 */
public final class PatientMapper {

    /**
     * Transforms the list of {@link Patient} objects given as a method parameter
     * into a list of {@link PatientDTO} objects and returns the created list.
     *
     * @param entities
     * @return
     */
	public static List<PatientDTO> mapEntitiesToDTOs(Iterable<Patient> entities) {
        List<PatientDTO> dtos = new ArrayList<PatientDTO>();

        for(Patient p : entities){
        	dtos.add(mapEntityToDTO(p));
        }        

        return dtos;
    }

    /**
     * Transforms the {@link Patient} object given as a method parameter into a
     * {@link PatientDTO} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static PatientDTO mapEntityToDTO(Patient entity) {
        PatientDTO dto = new PatientDTO();

        dto.setSsn(entity.getSsn());
        dto.setName(entity.getName());
        dto.setDob(entity.getDob());
        
        return dto;
    }
}