package com.Hostbook.rupak.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	
	 @PostMapping("/employees")
	    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee) {
	        return new ResponseEntity<String>(service.createEmployee(employee), HttpStatus.CREATED) ;
	    }

	    @GetMapping("/employees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        return new ResponseEntity<List<Employee>>( service.getEmployeeList(),HttpStatus.OK);
	    }

	    @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws EmployeeException {
	        return new ResponseEntity<Employee>( service.showEmployee(id),HttpStatus.OK);
	    }

	    @PutMapping("/employees/{id}")
	    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id,@Valid @RequestBody Employee employee) {
	        employee.setId(id);
	        return new ResponseEntity<String>( service.updateEmployee(id, employee),HttpStatus.OK);
	    }

	    @DeleteMapping("/employees/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) throws EmployeeException {
	        return new ResponseEntity<String>( service.deleteEmployee(id),HttpStatus.OK);
	    }
	
	
	
}
