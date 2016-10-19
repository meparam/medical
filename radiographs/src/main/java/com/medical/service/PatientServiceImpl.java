package com.medical.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.PatientRepository;
import com.medical.model.Patient;
import com.medical.model.PatientDTO;
import com.medical.model.PatientMapper;

/**
 * This service provides operations for managing patient records.
 * @author rahimbuneri
 *
 */
@Service(value = "patientService")
final public class PatientServiceImpl implements PatientService{
	
	private static final Logger LOGGER = Logger.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientRepository repository;
	
		
	/**
     * This method is used to create new patient record in the database using the repository
     */
	@Transactional
    @Override
    public PatientDTO create(PatientDTO newPatientDTO) {
        
		LOGGER.info("Creating a new patient record : "+ newPatientDTO);

		if(exists(newPatientDTO.getSsn())){
			return null;
		}
        // convert dto to entity
        Patient patient = new Patient();
        patient.setName(newPatientDTO.getName());
        patient.setSsn(newPatientDTO.getSsn());        
        patient.setDob(newPatientDTO.getDob());                

        patient = repository.save(patient);
        
        LOGGER.info("Created a new patient record : " + patient);

        return PatientMapper.mapEntityToDTO(patient);
    }
	
	@Transactional
	private boolean exists(String primaryKeySSN){
		
		return repository.exists(primaryKeySSN);
	}

    
    /**
     * Finds all patient records from the database using repository.
     * @return
     */
	@Transactional(readOnly = true)
    @Override
    public List<PatientDTO> findAll() {
        
		LOGGER.info("Finding all patient records.");

        List<Patient> patients = repository.findAll();

        LOGGER.info("Found patient records : " + patients.size());

        return PatientMapper.mapEntitiesToDTOs(patients);
    }    
   

}
