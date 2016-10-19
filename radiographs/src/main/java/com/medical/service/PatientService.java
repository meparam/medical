package com.medical.service;

import java.util.List;

import com.medical.model.PatientDTO;

/**
 * This service provides operations for managing patient records.
 * @author rahimbuneri
 *
 */
public interface PatientService {

	/**
     * Creates a new patient entry.
     * @param newPatient   The information of the created patient entry.
     * @return               The information of the created patient entry.
     */
	PatientDTO create(PatientDTO newPatient);
		    
    /**
     * Finds all patient records that are saved in the database.
     * @return
     */
    List<PatientDTO> findAll();    

}
