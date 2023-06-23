package com.Hostbook.rupak.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Hostbook.rupak.Exception.EmployeeException;
import com.Hostbook.rupak.Repository.EmployeeRepository;
import com.Hostbook.rupak.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	
	@Override
	public String createEmployee(Employee employee) {
		Employee emp= repo.save(employee);
		String ans;
		if(emp==null) {
			ans="Some Technical Error";
			return ans;
		}else {
			ans="employee saved !!!!";
			return ans;
		}
		
	}

	@Override
	public List<Employee> getEmployeeList() {

		List<Employee> list=repo.findAll();
		return list;
	}

	@Override
	public String updateEmployee(Long id, Employee employee) {
	Optional<Employee> opt=repo.findById(id);
	String ans;
	if(opt.isEmpty()) {
		ans="Employee id is incorrect...";
		return ans;
	}
	Employee emp=opt.get();
	emp.setFirstname(employee.getFirstname());
	emp.setLastname(employee.getLastname());
	emp.setEmailId(employee.getEmailId());
	repo.save(emp);
	ans="Employee updated succesfullly";
		return ans;
	}

	@Override
	public Employee showEmployee(Long id) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> emp=repo.findById(id);
		if(emp.isEmpty()) {
			throw new EmployeeException("Employee Id Is not valid!!!!!!");
		}
		return emp.get();
	}

	@Override
	public String deleteEmployee(long id) throws EmployeeException {
		Optional<Employee> emp=repo.findById(id);
		if(emp.isEmpty()) {
			throw new EmployeeException("Employee Id Is not valid!!!!!!");
		}
		repo.delete(emp.get());
		return "Employee Delete Successfully.....";
	}

}
