package com.legato.empportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.empportal.entity.Employee;
import com.legato.empportal.entity.Gender;
import com.legato.empportal.entity.Role;
import com.legato.empportal.repository.EmployeeRepository;
import com.legato.empportal.request.EmployeeRequest;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(EmployeeRequest empRequest) {
		Employee employee = new Employee();

		Gender gender = Gender.valueOf(empRequest.getEmpGender());
		employee.setEmpGender(gender);
		employee.setEmpName(empRequest.getEmpName());
		employee.setEmpSalary(empRequest.getEmpSalary());
		employee.setCreatedAt(empRequest.getCreatedAt());
		employee.setUpdatedAt(empRequest.getUpdatedAt());
		Role role = Role.valueOf(empRequest.getEmpRole());
		employee.setEmpRole(role);
		return employeeRepository.save(employee);

	}

	@Override
	public Employee updateEmployee(EmployeeRequest empRequest) {

		Employee employee = new Employee();

		Gender gender = Gender.valueOf(empRequest.getEmpGender());
		employee.setEmpGender(gender);
		employee.setEmpName(empRequest.getEmpName());
		employee.setEmpSalary(empRequest.getEmpSalary());
		employee.setCreatedAt(empRequest.getCreatedAt());
		employee.setUpdatedAt(empRequest.getUpdatedAt());
		Role role = Role.valueOf(empRequest.getEmpRole());
		employee.setEmpRole(role);
		return employeeRepository.save(employee);

	}

	@Override
	public Optional<Employee> findByEmpId(Long id) {

		return employeeRepository.findByEmpId(id);
	}

	@Override
	public List<Employee> findAllEmployees() {

		return employeeRepository.findAll();

	}

	

}
