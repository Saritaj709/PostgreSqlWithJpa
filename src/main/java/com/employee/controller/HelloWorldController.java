package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.UserNotFoundException;
import com.employee.model.HelloWorldResponse;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<HelloWorldResponse> getHello(@RequestParam(defaultValue = "world") String name) {
		return new ResponseEntity<>(new HelloWorldResponse(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/myname", method = RequestMethod.GET)
	public ResponseEntity<?> getData(@RequestParam(value="name",required=false) String name) throws UserNotFoundException {

		if (name.equals(" ") || name==null || name.equals("")) {
			throw new UserNotFoundException("name is not provided");
		}

		//return new ResponseEntity<>(new HelloWorldResponse(name), HttpStatus.OK);
		return new ResponseEntity<>("hello "+name,HttpStatus.OK);
	}

}
