package com.medical.service;

import java.util.List;

import com.medical.model.RadiographDTO;

/**
 * This service provides operations for managing patient records.
 * @author rahimbuneri
 *
 */
public interface RadiographService {

	/**
     * Creates a new patient entry.
     * @param newRadiograph   The information of the created patient entry.
     * @return               The information of the created patient entry.
     */
	RadiographDTO create(RadiographDTO newRadiograph);
		    
    /**
     * Finds all patient records created by given user that are saved in the database.
     * @return
     */
	List<RadiographDTO> getUserRadiographs(String userName);

}
