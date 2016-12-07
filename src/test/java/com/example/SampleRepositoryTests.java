package com.example;

import com.example.domain.Employee;
import com.example.repository.data.EmployeeDataRepository;
import com.example.repository.jpa.EmployeeJPARepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleRepositoryTests {

    @Autowired
    private EmployeeJPARepository employeeJPARepository;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Test
    public void findEmployeeByIdWithJPAShouldFoundData() throws Exception {
        Employee employee = employeeJPARepository.findById(1);
        Assert.assertEquals("john", employee.getFirstName());
    }
    @Test
    public void findEmployeeByFirstNameWithJPAShouldFoundData() throws Exception {
        Employee employee = employeeJPARepository.findByFirstName("john");
        Assert.assertEquals("john", employee.getFirstName());
    }


    @Test
    public void findEmployeeByIdWithDataRepositoryShouldFoundData() throws Exception {
        Employee employee = employeeDataRepository.findOne(1);
        Assert.assertEquals("john", employee.getFirstName());
    }


    @Test
    public void findEmployeeByFirstNameWithDataRepositoryShouldFoundData() throws Exception {
        Employee employee = employeeDataRepository.findByFirstName("john");
        Assert.assertEquals("john", employee.getFirstName());
    }
}