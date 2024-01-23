package com.myspringbootlearning.Spring.Tutorials;

import com.myspringbootlearning.Spring.Tutorials.config.AppConfig;
import com.myspringbootlearning.Spring.Tutorials.entity.Employee;
import com.myspringbootlearning.Spring.Tutorials.repository.EmployeeRepository;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(value = AppConfig.class)
public class UnitTest {

    @Autowired
    EmployeeRepository employeeRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AppConfig appConfig;

    @Test
    public void contextLoads() {
        log.info("Info log statement for UnitTest");
        log.warn("Warn log statement for UnitTest");
        log.error("Error log statement for UnitTest");

        Employee employee = employeeRepository.save(new Employee("Uday","Kiran"));
        Employee searchEmployee = employeeRepository.findById(employee.getId()).isPresent() ?
                employeeRepository.findById(employee.getId()).get() : null;

        Assert.assertNotNull(searchEmployee);
        System.out.println(appConfig.getUsername());
        Assert.assertEquals(employee.getFirstName(), searchEmployee.getFirstName());

    }

}