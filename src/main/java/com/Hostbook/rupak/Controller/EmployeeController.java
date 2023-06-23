package com.Hostbook.rupak.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Hostbook.rupak.Exception.EmployeeException;
import com.Hostbook.rupak.Service.EmployeeServiceImpl;
import com.Hostbook.rupak.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	
	 @PostMapping
	    public String createEmployee(@RequestBody Employee employee) {
	        return service.createEmployee(employee);
	    }

	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return service.getEmployeeList();
	    }

	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable("id") Long id) throws EmployeeException {
	        return service.showEmployee(id);
	    }

	    @PutMapping("/{id}")
	    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
	        employee.setId(id);
	        return service.updateEmployee(id, employee);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable("id") Long id) throws EmployeeException {
	        return service.deleteEmployee(id);
	    }
	
	
	
}
