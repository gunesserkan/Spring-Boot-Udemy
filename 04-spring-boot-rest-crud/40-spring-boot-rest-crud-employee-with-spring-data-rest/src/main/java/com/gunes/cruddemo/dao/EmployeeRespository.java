package com.gunes.cruddemo.dao;

import com.gunes.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "members")
public interface EmployeeRespository extends JpaRepository<Employee,Integer> {
}
