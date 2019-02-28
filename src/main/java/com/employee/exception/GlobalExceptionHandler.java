package com.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.controller.EmployeeController;
import com.employee.model.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	
public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDTO> register(UserNotFoundException e){
		logger.error("Registration exception");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("error, "+e.getMessage());
		response.setStatus(1);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
