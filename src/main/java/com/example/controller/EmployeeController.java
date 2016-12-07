package com.example.controller;

import com.example.domain.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.jpa.EmployeeJPARepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Assanai Manurat on 12/7/2016 AD.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeJPARepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = employeeRepository.findById(id);
        System.out.println(employee);

        if (employee == null) {
            throw new ResourceNotFoundException("Cannot find employee id " + id);
        }

        return employee;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployee()   {
//        List list = employeeRepository.findAll();
        List<Employee> list = employeeService.findEmployees();


        return list;
    }

}
