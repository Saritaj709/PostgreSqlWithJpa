package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Employee;
import com.employee.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void addemployee(Employee employee) throws Exception {
		
		 Optional<Employee> optionalEmployee = employeeDao.findByEmailId(employee.getEmailId());

			//Employee employee = employeeDao.findByEmailId(email);

				if (optionalEmployee.isPresent()) {
					throw new Exception("employee with given emailId already present,enter different emailId to register");
				}
		employeeDao.save(employee);

	}

	@Override
	public void updateEmployee(String email, String contactNo) throws Exception {
		 Optional<Employee> employee = employeeDao.findByEmailId(email);
		//Employee employee = employeeDao.findByEmailId(email);

		if (!employee.isPresent()) {
			throw new Exception("employee not found");
		}
		employee.get().setContactNo(contactNo);
		employeeDao.save(employee.get());

	}

	@Override
	public void deleteEmployee(String email) throws Exception {
		 Optional<Employee> employee = employeeDao.findByEmailId(email);

		//Employee employee = employeeDao.findByEmailId(email);

			if (!employee.isPresent()) {
				throw new Exception("employee not found");
			}
		employeeDao.delete(employee.get());

	}

	@Override
	public Employee getEmployeeByEmail(String email) throws Exception {
		 Optional<Employee> employee = employeeDao.findByEmailId(email);

		//Employee employee = employeeDao.findByEmailId(email);

		
		 if (!employee.isPresent()) {
				throw new Exception("employee not found");
			}

		return employee.get();

	}

	@Override
	public List<Employee> getEmployees() {

		return employeeDao.findAll();
	}
}
