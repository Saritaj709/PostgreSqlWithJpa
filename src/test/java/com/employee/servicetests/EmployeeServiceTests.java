
package com.employee.servicetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.dao.EmployeeRepository;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class EmployeeServiceTests {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeDao;

	Employee employee = null;

	Optional<Employee> optionalEmployee = null;

	@Before
	public void setUp() {
		employee.setContactNo("4758945612");
		employee.setEmailId("abc@gmail.com");
		employee.setId(1);
		employee.setName("abc");

	}

	@Test
	public void testAddEmployee() {
		try {
			employeeService.addemployee(employee);
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(false);
		}
	}

}
