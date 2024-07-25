package com.gunes.cruddemo.dao;

import com.gunes.cruddemo.entity.Employee;
import com.gunes.cruddemo.service.EmployeeServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmoloyee = entityManager.merge(theEmployee);
        return dbEmoloyee;
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);

    }
}
