package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.exception.RegistrationException;
import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeDao;

	@Override
	public void addemployee(Employee employee) {
		/*
		 * Employee employee1 = new Employee();
		 * employee1.setEmailId("saritaj709@gmail.com"); employee1.setName("sarita");
		 * employee1.setContactNo("7458964569"); employeeDao.save(employee1);
		 */
		Optional<Employee> optionalEmployee = employeeDao.findByEmailId(employee.getEmailId());
		//System.out.println("employees "+optionalEmployee.get());

		if (optionalEmployee.isPresent()) {
			throw new RegistrationException(
					"employee with given emailId already present,enter different emailId to register");
		}

		employeeDao.save(employee);
		// employeeDao.delete(employee1);
		// System.out.println("success");

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
