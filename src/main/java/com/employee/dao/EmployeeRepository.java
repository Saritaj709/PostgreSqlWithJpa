package com.employee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmailId(String email);

	Optional<Employee> findByName(String emailId);
}