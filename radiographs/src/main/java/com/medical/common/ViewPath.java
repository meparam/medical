package com.medical.common;

public interface ViewPath {
	
	// patient
	String CREATE_PATIENT = "/createPatient";
	String SAVE_PATIENT = "/savePatient";
	String LIST_PATIENTS = "/patients";
	
	// user
	String DEFAULT_PATH_USER_LOGIN = "/";
	String USER_LOGIN = "/login";
	String USER_LOGOUT = "/logout";
	String FIND_USER = "/findUser";
	
	// radiograph
	String CREATE_RADIOGRAPH = "/createRadiograph";
	String SAVE_RADIOGRAPH = "/saveRadiograph";
	String LIST_RADIOGRAPHS = "/radiographs";
}
