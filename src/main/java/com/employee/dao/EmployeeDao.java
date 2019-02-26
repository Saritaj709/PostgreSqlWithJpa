package com.employee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmailId(String email);

}
