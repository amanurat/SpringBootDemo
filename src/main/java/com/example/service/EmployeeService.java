package com.example.service;

import com.example.domain.Employee;
import com.example.repository.data.EmployeeDataRepository;
import com.example.repository.jpa.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private EmployeeJPARepository employeeJPARepository;


    public List<Employee> findEmployees() {
        return (List<Employee>) employeeJPARepository.findAll();
    }

}
