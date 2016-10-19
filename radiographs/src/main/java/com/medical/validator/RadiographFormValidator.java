package com.medical.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.medical.model.RadiographDTO;

@Component
public class RadiographFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RadiographDTO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

		RadiographDTO radiographDTO = (RadiographDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "desc", "form.field.required.desc");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason", "form.field.required.reason");
		
		if(radiographDTO.getDesc().length() > 500){
			errors.rejectValue("desc", "form.field.length.desc");
		}
		if(radiographDTO.getReason().length() > 500){
			errors.rejectValue("reason", "form.field.length.reason");
		}
		
		if(radiographDTO.getSsn().isEmpty() || radiographDTO.getSsn().equals("0")){
			errors.rejectValue("ssn", "form.field.select.ssn");
		}
		
	}
}
