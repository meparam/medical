package com.medical.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medical.model.UserDTO;
import com.medical.service.UserService;

/**
 * This controller is used for Login management such as login and logout
 * @author rahimbuneri
 *
 */
@Controller
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	@Qualifier("userService")	
	private UserService userService;
    
    /**
     * This method is used for login to the system
     * @param	model
     * @return	redirect to home page
     */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("message", "login");
		
		return "home";
	}

	/**
	 * Its used for logout from the system
	 * @param	model
	 * @return	redirect to home page
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		
		model.addAttribute("message", "logout");
		
		return "home";
	}
	
	/**
	 * Finds user by id such as userName
	 * @param	userName
	 * @param	model
	 * @return	redirect to home page
	 */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    String findById(@RequestParam("userName") String userName, Model model) {
        
    	LOGGER.info("Finding user for userName :"+ userName);

        UserDTO user = userService.findById(userName);        
        
        LOGGER.info("Found user : "+ user);

        return "home";
    }
}
