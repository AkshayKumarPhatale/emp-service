package com.legato.empportal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.legato.empportal.entity.Employee;
import com.legato.empportal.exception.EmployeeCreationExpection;
import com.legato.empportal.exception.EmployeeNotFoundException;
import com.legato.empportal.exception.EmployeeUpdationFailed;
import com.legato.empportal.exception.NoEmployeeFoundException;
import com.legato.empportal.request.EmployeeRequest;
import com.legato.empportal.response.EmployeeResponse;
import com.legato.empportal.service.IEmployeeService;

@RequestMapping(value = "/employee")
@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService iEmployeeService;

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {

		String successMessage = "New Employee Created ";
		String failedMessage = "Employee Creation Failed";
		

		Employee savedEmployee = iEmployeeService.addEmployee(employeeRequest);

		if (savedEmployee.getEmpId() != null) {
			
			EmployeeRequest empDto = new EmployeeRequest();
			empDto.setCreatedAt(savedEmployee.getCreatedAt());
			empDto.setEmpName(savedEmployee.getEmpName());
			empDto.setEmpId(savedEmployee.getEmpId());
			empDto.setEmpGender(savedEmployee.getEmpGender().toString());
			empDto.setEmpRole(savedEmployee.getEmpRole().toString());
			empDto.setEmpSalary(savedEmployee.getEmpSalary());
			empDto.setUpdatedAt(savedEmployee.getUpdatedAt());
			empDto.setEmpId(savedEmployee.getEmpId());
			EmployeeResponse employeeResponse = new EmployeeResponse(successMessage, true, empDto);

			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.CREATED);
		}

		else {
			throw new EmployeeCreationExpection(failedMessage);
		}

	}

	@PutMapping(value = "/updateEmployee")
	public ResponseEntity<EmployeeResponse> updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {

		String successMessage = "Employee details updated ";
		String failedMessage = "Employee details update Failed";
		
		Employee savedEmployee = iEmployeeService.updateEmployee(employeeRequest);

		if (savedEmployee.getEmpId() != null) {
			
			EmployeeRequest empDto = new EmployeeRequest();
			empDto.setCreatedAt(savedEmployee.getCreatedAt());
			empDto.setEmpName(savedEmployee.getEmpName());
			empDto.setEmpId(savedEmployee.getEmpId());
			empDto.setEmpGender(savedEmployee.getEmpGender().toString());
			empDto.setEmpRole(savedEmployee.getEmpRole().toString());
			empDto.setEmpSalary(savedEmployee.getEmpSalary());
			empDto.setUpdatedAt(savedEmployee.getUpdatedAt());
			empDto.setEmpId(savedEmployee.getEmpId());
			EmployeeResponse employeeResponse = new EmployeeResponse(successMessage, true, empDto);

			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.CREATED);

		} else {
			throw new EmployeeUpdationFailed(failedMessage);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findByEmpId(@NotNull @PathVariable(value = "id") Long noteId) {

		Optional<Employee> emp = iEmployeeService.findByEmpId(noteId);

		if (emp.isPresent()) {

			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundException("Employee not found for id:" + "" + noteId);
		}

	}

	
	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> listEmployees = iEmployeeService.findAllEmployees();

		if (!listEmployees.isEmpty()) {

			return new ResponseEntity<List<Employee>>(listEmployees, HttpStatus.OK);
		} else {
			throw new NoEmployeeFoundException("No Employee Data Found");

		}

	}

}
