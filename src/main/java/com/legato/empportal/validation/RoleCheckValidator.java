package com.legato.empportal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.legato.empportal.entity.Role;

public class RoleCheckValidator implements ConstraintValidator<RoleCheck, String> {

	private String roleCheck;

	public String getRoleCheck() {
		return roleCheck;
	}

	public void setRoleCheck(String roleCheck) {
		this.roleCheck = roleCheck;
	}

	@Override
	public void initialize(RoleCheck constraintAnnotation) {
		this.roleCheck=constraintAnnotation.toString();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Boolean  isRoleExists=Role.contains(value);
		
		if(isRoleExists) {
			return true;
		}
		
		else {
			return false;
		}
	}

}
