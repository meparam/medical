package com.medical.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medical.common.ViewPath;
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
     * This method is used to show login page
     * @param	model
     * @return	redirect to login page
     */
	@RequestMapping(value = ViewPath.DEFAULT_PATH_USER_LOGIN, method = RequestMethod.GET)
	public String login(Model model) {
		
		LOGGER.info("login : enter");
				
		model.addAttribute("loginCommand", new UserDTO());
		
		LOGGER.info("login : exit");
		
		return "login";
	}
	
	
	/**
	 * This method is used to authenticate the user, by id such as userName
	 * @param loginCommand
	 * @param request
	 * @param modelMap
	 * @return redirect to radiographs listing page
	 */
	@RequestMapping(value = ViewPath.USER_LOGIN, method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute("loginCommand") UserDTO loginCommand, HttpServletRequest request, ModelMap modelMap) {
		
		LOGGER.info("loginSubmit : enter");
		
		String returnView = "login"; // in case of login failure
		boolean foundUser = Boolean.FALSE;
		String message = "Incorrect Username or Password";
		
		String userName = loginCommand.getUserName();
		String password = loginCommand.getPassword();
		
		if(userName != null && !userName.isEmpty() && password != null && !password.isEmpty() ){
		
			try{
				UserDTO user = userService.authenticateUser(userName, password);  
				if(user != null){
					foundUser = Boolean.TRUE;
					returnView = "redirect:" + ViewPath.LIST_RADIOGRAPHS;
					message = userName;
					request.getSession().setAttribute("userName", userName);
				}
			} catch(Exception e){
				LOGGER.error(e.getMessage());
				LOGGER.info("User not found");
			}
		}
		
		modelMap.put("message", message);		
        
        LOGGER.info("Found user : " + foundUser);
		
		return returnView;
	}

	/**
	 * Its used for logout from the system
	 * @param	request
	 * @return	redirect to login page
	 */
	@RequestMapping(value = ViewPath.USER_LOGOUT, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {
		
		LOGGER.info("logout : enter");
		
		if(request.getSession().getAttribute("userName") != null){
			request.getSession().removeAttribute("userName");
		}
		
		model.addAttribute("loginCommand", new UserDTO());
						
		LOGGER.info("logout : exit");
		
		return "login";
	}
	
}
