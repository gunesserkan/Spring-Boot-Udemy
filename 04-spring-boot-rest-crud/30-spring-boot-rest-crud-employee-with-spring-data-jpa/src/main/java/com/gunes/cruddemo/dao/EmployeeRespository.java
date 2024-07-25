package com.gunes.cruddemo.dao;

import com.gunes.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee,Integer> {
}
