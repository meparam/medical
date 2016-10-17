package com.medical.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medical.model.PatientDTO;
import com.medical.service.PatientService;

/**
 * This controller is used to patient record management CRUD
 * @author rahimbuneri
 *
 */
@Controller
public class PatientController {
	
	private static final Logger LOGGER = Logger.getLogger(PatientController.class);

	@Autowired
	@Qualifier("patientService")	
	private PatientService patientService;

    @Autowired
    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
		
	/**
	 * Finds all patient records
	 * @param	model
	 * @return	redirect to home page
	 */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    String listAll(Model model) {
        
    	LOGGER.info("Find all patients : enter");

        List<PatientDTO> patients = patientService.findAll();
        
        model.addAttribute("patients", patients);
        
        LOGGER.info("Found patients : "+ patients);

        return "home";
    }
    
    @RequestMapping(value="/createPatient", method = RequestMethod.GET)
	public String createPatient(Model model) {
    	
    	LOGGER.info("createPatient : enter");
		
		model.addAttribute("patientCommand", new PatientDTO());
		
		LOGGER.info("createPatient : exit");
		
		return "home";
	}
    
    /**
     * Used to save a patient record
     * @param	model
     * @return	home page
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save(@ModelAttribute("patientCommand")PatientDTO patientCommand, Model model) {
        
    	LOGGER.info("saving patient record");
    	
    	patientCommand = patientService.create(patientCommand);
        
        model.addAttribute("patient", patientCommand);
        
        LOGGER.info("patient saved : "+ patientCommand);

        return "home";
    }
    
    
}
