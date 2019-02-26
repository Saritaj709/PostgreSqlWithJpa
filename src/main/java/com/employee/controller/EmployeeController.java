package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/addEmployee")
	public void addemployee(@RequestBody Employee employee) throws Exception {
		employeeService.addemployee(employee);
	}
	
	@DeleteMapping(value="/deleteEmployee/{emailId}")
	public void deleteEmployee(@PathVariable(value="emailId")String email) throws Exception {
		employeeService.deleteEmployee(email);
		
	}
	@PutMapping(value="/update/{emailId}")
	public void updateEmployee(@PathVariable(value="emailId")String email,@RequestParam(value="contactNo")String contactNo) throws Exception {
		employeeService.updateEmployee(email, contactNo);
	}
	
	@GetMapping(value="/getEmployeeByEmailId/{emailId}")
	public Employee getEmployeeByEmail(@PathVariable(value="emailId")String email) throws Exception {
		return employeeService.getEmployeeByEmail(email);
	}
	
	@GetMapping(value="/getAllEmployees")
	public List<Employee> getemployees(){
		return employeeService.getEmployees();
	}
}
