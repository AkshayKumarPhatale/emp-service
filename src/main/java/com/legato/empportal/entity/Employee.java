/**
 * 
 */
package com.legato.empportal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



/**
 * @author HANUMAN
 *
 */

@Table(name = "EMPLOYEE")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long empId;

	private String empName;

	@Enumerated(EnumType.STRING)
	private Gender empGender;

	
	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	@Enumerated(EnumType.STRING)
	private Role empRole;

	private Double empSalary;

	public Employee() {

	}
	
	

	public Employee(Long empId, String empName, Gender empGender, Date createdAt, Date updatedAt, Role empRole,
			Double empSalary) {
		
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.empRole = empRole;
		this.empSalary = empSalary;
	}


	

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Gender getEmpGender() {
		return empGender;
	}

	public void setEmpGender(Gender empGender) {
		this.empGender = empGender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Role getEmpRole() {
		return empRole;
	}

	public void setEmpRole(Role empRole) {
		this.empRole = empRole;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		

		if (o instanceof Employee) {
			Employee employee = (Employee) o;
			return this.empId == employee.empId ;

		}
		return false;
		
		
	}
	
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.empId == null) ? 0 : this.empId.hashCode());
		return result;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGender=" + empGender + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", empRole=" + empRole + ", empSalary=" + empSalary + "]";
	}

	
}
