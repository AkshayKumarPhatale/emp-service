package com.legato.empportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.empportal.entity.Employee;
import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findByEmpName(String empname);
	public Optional<Employee> findByEmpId(Long id);
}
