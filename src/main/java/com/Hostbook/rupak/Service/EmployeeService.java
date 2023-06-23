package com.Hostbook.rupak.Service;

import java.util.List;

import com.Hostbook.rupak.Exception.EmployeeException;
import com.Hostbook.rupak.model.Employee;

public interface EmployeeService {

	public String createEmployee(Employee employee);
	
	public List<Employee> getEmployeeList();
	
	public String updateEmployee(Long id,Employee employee);
	
	public Employee showEmployee(Long id)throws EmployeeException;
	
	public String deleteEmployee(long id)throws EmployeeException;
	
}
