package com.example.repository.data;

import com.example.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepository extends JpaRepository<Employee, Integer> {

    Employee findByFirstName(String john);
}
