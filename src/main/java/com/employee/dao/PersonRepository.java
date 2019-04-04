package com.employee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Employee,String > {
}
