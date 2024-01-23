package com.myspringbootlearning.Spring.Tutorials.controller;

import com.myspringbootlearning.Spring.Tutorials.entity.Employee;
import com.myspringbootlearning.Spring.Tutorials.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List <Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity < >(employees, HttpStatus.OK);
    }

    /**
     * CreateEmployee with the system.This end point accepts Employee information in
     * the json format.It will create and send back the data to the REST Employee.
     * @return newly created Employee
     */
    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee) {
        final Employee employeeData = employeeService.createEmployee(Employee);
        return new ResponseEntity < >(employeeData, HttpStatus.CREATED);
    }

    /**
     * Update Employee with the system.This end point accepts Employee information in
     * the json format.It will create and send back the data to the REST Employee.
     * @param employee, id
     * @return updated Employee
     */
    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        final Employee employeeData = employeeService.updateEmployee(id, employee);
        return new ResponseEntity < >(employeeData, HttpStatus.CREATED);
    }

    /**
     * Deleted the Employee from the system.client will pass the ID for the Employee and this 
     * end point will remove Employee from the system if found.
     * @param id
     */
    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (Objects.nonNull(employee)) {
             employeeService.deleteEmployee(id);
        } else return new ResponseEntity < >("Employee with the provided id " + id + " is not found.", HttpStatus.NOT_FOUND) ;
        return new ResponseEntity < >("Employee with the provided id " + id + " is deleted.", HttpStatus.OK);
    }

    /**
     * Get the Employee detail based on the id passed by the client API.
     * @param id
     * @return Employee detail
     */
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity < >(employee, HttpStatus.OK);
    }
}
