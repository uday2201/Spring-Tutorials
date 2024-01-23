package com.myspringbootlearning.Spring.Tutorials.repository;

import com.myspringbootlearning.Spring.Tutorials.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findEmployeeByLastName(String lastName);
}
