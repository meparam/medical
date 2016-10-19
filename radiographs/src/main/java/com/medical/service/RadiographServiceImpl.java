package com.medical.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.RadiographRepository;
import com.medical.model.Patient;
import com.medical.model.Radiograph;
import com.medical.model.RadiographDTO;
import com.medical.model.RadiographMapper;
import com.medical.model.User;

/**
 * This service provides operations for managing radiograph records.
 * @author rahimbuneri
 *
 */
@Service(value = "radiographService")
final public class RadiographServiceImpl implements RadiographService{
	
	private static final Logger LOGGER = Logger.getLogger(RadiographServiceImpl.class);

	@Autowired
	private RadiographRepository repository;
	
		
	/**
     * This method is used to create new radiograph record in the database using the repository
     */
	@Transactional
    @Override
    public RadiographDTO create(RadiographDTO newRadiographDTO) {
        
		LOGGER.info("Creating a new radiograph record : "+ newRadiographDTO);
		
		User user = new User();
		user.setUserName(newRadiographDTO.getUserName());
		
		Patient patient = new Patient();
		patient.setSsn(newRadiographDTO.getSsn());
		
        // convert dto to entity
        Radiograph radiograph = new Radiograph();
        radiograph.setUser(user);
        radiograph.setPatient(patient);
        radiograph.setDesc(newRadiographDTO.getDesc());
        radiograph.setReason(newRadiographDTO.getReason());

        radiograph = repository.save(radiograph);
        
        LOGGER.info("Created a new radiograph record : " + radiograph);

        return RadiographMapper.mapEntityToDTO(radiograph);
    }
		    
    /**
     * Finds all radiograph records from the database using repository.
     * @return
     */
	@Transactional(readOnly = true)
    @Override
    public List<RadiographDTO> getUserRadiographs(String userName){
        
		LOGGER.info("Finding all radiograph records.");

        List<Radiograph> radiographs = repository.getUserRadiographs(userName);

        LOGGER.info("Found radiograph records : " + radiographs.size());

        return RadiographMapper.mapEntitiesToDTOs(radiographs);
    }    
   

}
