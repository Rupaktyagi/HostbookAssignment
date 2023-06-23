package com.Hostbook.rupak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hostbook.rupak.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
