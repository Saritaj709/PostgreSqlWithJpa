package com.employee.servicetests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.dao.EmployeeRepository;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeTest {
	@Autowired
	private Validator validator;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeDao;
	
	/*
	 * @MockBean private EmployeeDao employeedao;
	 */

	Employee emp = null;
	Employee emp1 = null;
	
	Set<ConstraintViolation<Employee>> violations=null;

	@Before
	public void setUp() {
		String name = "Sally";
		emp = new Employee(1,name,"abcd@gmail.com","7458124562");
		/*
		 * emp=new Employee(); emp.setContactNo("812457542");
		 * emp.setEmailId("abcd@gmail.com"); emp.setName(name);
		 */

		emp1 = new Employee(2,name,"abc@gmail.com","1478459642");
		/*
		 * emp1=new Employee(); emp1.setContactNo("812457542");
		 * emp1.setEmailId("abcd@gmail.com"); emp1.setName(name);
		 */
	}

	//@Test
	public void shouldValidateDuplicatedEmail() throws Exception { // given
		Set<ConstraintViolation<Employee>> violations = null;

		try {
			employeeDao.save(emp);
			// when
			violations = validator.validate(emp1);
			// then
			assertEquals(1, violations.size());
		} catch (Exception e) {
			assertEquals(0, violations.size());
		}
	}

	@Test
	public void duplicateUsersvalidation() {
		try {
			employeeService.addemployee(emp);
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(false);
		}
	}

	@Test
	public void duplicateUsersvalidation1() {
		
		try {
			employeeService.addemployee(emp);
			violations=validator.validate(emp1);
		//violations = validator.validate(emp1);
			assertEquals(0, violations.size());
			//assertTrue(true);
		} catch (Exception e) {
			//assertFalse(false);
			assertEquals(1, violations.size());
		}
	}

}
