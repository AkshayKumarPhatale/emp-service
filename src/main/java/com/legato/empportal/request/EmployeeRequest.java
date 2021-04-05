package com.legato.empportal.request;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import com.legato.empportal.validation.GenderCheck;
import com.legato.empportal.validation.RoleCheck;



/**
 * @author HANUMAN
 *
 */

public class EmployeeRequest {

	
	private Long empId;
    
	@NotBlank(message = "employeeName shouldnot be Empty")
	private String empName;

	@NotBlank
	@GenderCheck(message = "empGender shouldnot be Empty or Gender Must be MALE OR FEMALE")
	private String empGender;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;

	@NotBlank
	@RoleCheck(message = "Role must be Empty or Role must be  ASSOCIATE or SENIOR or TEAM_LEAD or MANAGER ")
	private String empRole;

	private Double empSalary;

	public EmployeeRequest() {

	}
	
	

		
	public EmployeeRequest(Long empId, String empName, String empGender, Date createdAt, Date updatedAt, String empRole,
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




	public String getEmpGender() {
		return empGender;
	}




	public void setEmpGender(String empGender) {
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




	public String getEmpRole() {
		return empRole;
	}




	public void setEmpRole(String empRole) {
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
		

		if (o instanceof EmployeeRequest) {
			EmployeeRequest employee = (EmployeeRequest) o;
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
