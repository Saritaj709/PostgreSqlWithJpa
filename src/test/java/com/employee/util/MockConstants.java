
package com.employee.util;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;

@Service
public class MockConstants {

	@MockBean
	public EmployeeRepository employeeDao;
}
