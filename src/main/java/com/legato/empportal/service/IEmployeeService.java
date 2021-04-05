package com.legato.empportal.service;

import java.util.List;
import java.util.Optional;

import com.legato.empportal.entity.Employee;
import com.legato.empportal.request.EmployeeRequest;

public interface IEmployeeService {
	
	public Employee addEmployee(EmployeeRequest empRequest);
	public Employee updateEmployee(EmployeeRequest empRequest);
	public Optional<Employee> findByEmpId(Long id);
	//public Employee findByEmpId(Long id);
	public List<Employee> findAllEmployees();

}
