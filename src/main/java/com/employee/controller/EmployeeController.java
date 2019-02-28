package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.model.ResponseDTO;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<ResponseDTO> addemployee(@RequestBody Employee employee) {
		employeeService.addemployee(employee);
		ResponseDTO response=new ResponseDTO();
		response.setMessage("added successfully");
		response.setStatus(1);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/addEmployee1")
	public void addemployee1(@RequestBody Employee employee) {
		employeeService.addemployee(employee);
	}

	@DeleteMapping(value = "/deleteEmployee/{emailId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable(value = "emailId") String email) throws Exception {
		employeeService.deleteEmployee(email);
		ResponseDTO response=new ResponseDTO();
		response.setMessage("deleted successfully");
		response.setStatus(4);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee/{emailId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable(value = "emailId") String email,
			@RequestParam(value = "contactNo") String contactNo) throws Exception {
		employeeService.updateEmployee(email, contactNo);
		ResponseDTO response=new ResponseDTO();
		response.setMessage("updated successfully");
		response.setStatus(2);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getEmployeeByEmailId/{emailId}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "emailId") String email) throws Exception {
		Employee employee= employeeService.getEmployeeByEmail(email);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees= employeeService.getEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
}
