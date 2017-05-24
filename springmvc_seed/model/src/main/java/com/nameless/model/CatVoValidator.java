package com.nameless.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CatVoValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(CatVo.class);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "color", "E001001", "EOO1001 MESSAGE");
	}

}
