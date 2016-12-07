package com.example.repository.jpa;

import com.example.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee findById(Integer id ) {
        return entityManager.find(Employee.class, id);
    }

    public Employee findByFirstName(String name) {
        List<Employee> employees = entityManager.createNamedQuery("employee.findByFirstName()", Employee.class)
                .setParameter("FIRST_NAME", name)
                .getResultList();

        if (!employees.isEmpty()) {
            return employees.get(0);
        } else {
            return null;
        }

    }

    public List findAll() {
        return entityManager.createQuery("from Employee").getResultList();
    }
}
