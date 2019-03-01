package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.exception.RegistrationException;
import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addemployee(Employee employee) {

		Optional<Employee> optionalEmployee = employeeDao.findByEmailId(employee.getEmailId());

		if (optionalEmployee.isPresent()) {
			throw new RegistrationException(
					"employee with given emailId already present,enter different emailId to register");
		}
		employeeDao.save(employee);

	}

	@Override
	public void updateEmployee(String email, String contactNo) {
		Optional<Employee> employee = employeeDao.findByEmailId(email);

		if (!employee.isPresent()) {
			throw new UserNotFoundException("employee not found");
		}
		employee.get().setContactNo(contactNo);
		employeeDao.save(employee.get());

	}

	@Override
	public void deleteEmployee(String email) {
		Optional<Employee> employee = employeeDao.findByEmailId(email);

		if (!employee.isPresent()) {
			throw new UserNotFoundException("employee not found");
		}
		employeeDao.delete(employee.get());

	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		Optional<Employee> employee = employeeDao.findByEmailId(email);

		if (!employee.isPresent()) {
			throw new UserNotFoundException("employee not found");
		}

		return employee.get();

	}

	@Override
	public List<Employee> getEmployees() {

		
		return employeeDao.findAll();
	}
}
