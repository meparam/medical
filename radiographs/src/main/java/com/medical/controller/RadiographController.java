package com.medical.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.medical.model.RadiographDTO;
import com.medical.service.PatientService;
import com.medical.service.RadiographService;
import com.medical.validator.RadiographFormValidator;

/**
 * This controller is used to patient record management CRUD
 * @author rahimbuneri
 *
 */
@Controller
public class RadiographController {
	
	private static final Logger LOGGER = Logger.getLogger(RadiographController.class);

	@Autowired
	@Qualifier("patientService")	
	private PatientService patientService;
	
	@Autowired
	@Qualifier("radiographService")	
	private RadiographService radiographService;
	
	@Autowired
	RadiographFormValidator radiographFormValidator;

	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(radiographFormValidator);
	}

    		
	/**
	 * Finds all patients records
	 * @param	model
	 * @return	redirect to patients page
	 */
    @RequestMapping(value = ViewPath.LIST_RADIOGRAPHS, method = RequestMethod.GET)
    String listAll(HttpServletRequest request, Model model) {
        
    	LOGGER.info("Find all radiographs : enter");
        	
    	List<RadiographDTO> radiographs = new ArrayList<RadiographDTO>();
    	String userName = (String)request.getSession().getAttribute("userName");
    	
    	try{
    		
    		radiographs = radiographService.getUserRadiographs(userName);
        
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    	}
        
        model.addAttribute("radiographs", radiographs);
        
        LOGGER.info("Found radiographs : "+ radiographs);

        return "radiographs";
    }
    
    /**
     * 
     * @param model
     * @return	redirect to patient creation form page
     */
    @RequestMapping(value = ViewPath.CREATE_RADIOGRAPH, method = RequestMethod.GET)
	public String createRadiograph(Model model) {
    	
    	LOGGER.info("createRadiograph : enter");
    	
    	try{
    		populatePatients(model);
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    	}
    	
    	// check redirectAttributes
		model.addAttribute("radiographCommand", new RadiographDTO());
		
		LOGGER.info("createRadiograph : exit");
		
		return "radiograph";
	}
    
    /**
     * Used to save a patient record
     * @param	model
     * @return	In case of success, redirected to patients listing page.
     * 			In all other cases of failure such as DB server down, redirect to patient creation page with failure reason
     */
    @RequestMapping(value = ViewPath.SAVE_RADIOGRAPH, method = RequestMethod.POST)
    String save(@ModelAttribute("radiographCommand") @Validated RadiographDTO radiographCommand, BindingResult validationResult, Model model,
    		final RedirectAttributes redirectAttributes) {
        
    	LOGGER.info("saving radiograph record");
    	
    	boolean result = Boolean.FALSE;
    	String message = "Failed to save Radiograph";    	
    	String returnView =  "radiograph"; // failure view    	    	
    	
    	try{
    		
    		if(validationResult.hasErrors()){
    			populatePatients(model);    			
    		} else {
    			
    			radiographCommand = radiographService.create(radiographCommand);    		
        		result = Boolean.TRUE;
        		message = "Radiograph saved successfully";
        		returnView = "redirect:" + ViewPath.LIST_RADIOGRAPHS; // success
        	}
    		
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    		message = "Failed to create radiograph : " + e.getMessage();    		
    	}    	
   	    if(result){		
   	    	redirectAttributes.addFlashAttribute("message", message);
   	    } else {
   	    	model.addAttribute("message", message);
   	    }
    	       
        LOGGER.info("radiograph saved result = "+ result + " : message = " + message);

        return returnView;
    }
    
    /**
     * This method is used to get all patient records and set it in model, to be used in the dropdown list in redeiograph form.
     * @param model
     */
    private void populatePatients(Model model) {
    	
    	LOGGER.info("getAllPatients : enter");
    	
    	List<PatientDTO> patients = new ArrayList<PatientDTO>();
    	
    	try{

    		patients = patientService.findAll();    		
        
    	} catch(Exception e){
    		LOGGER.error(e.getMessage());
    	}
        
        model.addAttribute("patients", patients);
        		
		LOGGER.info("getAllPatients : exit");
		
	}
    
    
}
