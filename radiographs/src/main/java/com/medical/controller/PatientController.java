package com.medical.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medical.common.ViewPath;
import com.medical.model.PatientDTO;
import com.medical.service.PatientService;
import com.medical.validator.PatientFormValidator;

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
	PatientFormValidator patientFormValidator;

	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(patientFormValidator);
	}
    		
	/**
	 * Finds all patient records
	 * @param	model
	 * @return	redirect to patients page
	 */
    @RequestMapping(value = ViewPath.LIST_PATIENTS, method = RequestMethod.GET)
    String listAll(Model model) {
        
    	LOGGER.info("Find all patients : enter");
    	
    	List<PatientDTO> patients = new ArrayList<PatientDTO>();
    	
    	try{

    		patients = patientService.findAll();
        
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    	}
        
        model.addAttribute("patients", patients);
        
        LOGGER.info("Found patients : "+ patients);

        return "patients";
    }
    
    /**
     * 
     * @param model
     * @return	redirect to patient creation form page
     */
    @RequestMapping(value = ViewPath.CREATE_PATIENT, method = RequestMethod.GET)
	public String createPatient(Model model) {
    	
    	LOGGER.info("createPatient : enter");
		
		model.addAttribute("patientCommand", new PatientDTO());
		
		LOGGER.info("createPatient : exit");
		
		return "patient";
	}
    
    /**
     * Used to save a patient record
     * @param	model
     * @return	In case of success, go to patients listing page. if duplicate SSN then go back to patient creation page with an error message
     * 			In all other cases of failure such as DB server down, redirect to patient creation page with failure reason
     */
    @RequestMapping(value = ViewPath.SAVE_PATIENT, method = RequestMethod.POST)
    String save(@ModelAttribute("patientCommand") @Validated PatientDTO patientCommand, BindingResult validationResult, Model model, 
    		final RedirectAttributes redirectAttributes) {
        
    	LOGGER.info("saving patient record");
    	
    	String message = "Failed to save Patient";
    	boolean result = Boolean.FALSE;
    	String returnView =  "patient"; // failure view
    	
    	try{
    		
    		if(!validationResult.hasErrors()){    		    			
    			patientCommand = patientService.create(patientCommand); 
        		if(patientCommand == null){
        			message = "Duplicate Social Security ID";
        		} else {
        			result = Boolean.TRUE;
        			message = "Patient saved successfully";
            		returnView = "redirect:" + ViewPath.LIST_RADIOGRAPHS; // success
        		}
    		}
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    		message = "Failed to create patient : " + e.getMessage();    		
    	}
        
    	if(result){		
   	    	redirectAttributes.addFlashAttribute("message", message);
   	    } else {
   	    	model.addAttribute("message", message);
   	    }        
               
        LOGGER.info("patient saved result = "+ result + " : message = " + message);

        return returnView;
    }
    
    
}
