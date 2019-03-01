package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;

@Service
public interface EmployeeService {

	void addemployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeByEmail(String email) throws Exception;
    void updateEmployee(String email,String contactNo) throws Exception;
    void deleteEmployee(String email) throws Exception;
}
