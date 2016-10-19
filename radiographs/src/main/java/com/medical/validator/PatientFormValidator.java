package com.medical.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.medical.model.PatientDTO;

@Component
public class PatientFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PatientDTO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

		PatientDTO patientDTO = (PatientDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "form.field.required.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "form.field.required.ssn");
				
		if(patientDTO.getSsn().length() > 25){
			errors.rejectValue("ssn", "form.field.length.ssn");
		}
		if(patientDTO.getName().length() > 100){
			errors.rejectValue("name", "form.field.length.name");
		}
		
	}
}
