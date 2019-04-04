package com.employee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.dao.EmployeeRepository;


class UniqueUserValidator implements ConstraintValidator<UniqueUser, String> {
	@Autowired
	private EmployeeRepository employeeDao;
	
    public UniqueUserValidator(EmployeeRepository employeeDao) {
        this.employeeDao = employeeDao;
    }
 
    public void initialize(UniqueUser constraint) {
    }
 
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name != null && !employeeDao.findByName(name).isPresent();
    }
}
