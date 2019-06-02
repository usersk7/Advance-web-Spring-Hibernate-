package com.cdac.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="Emp_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer emptId;
	
	 @Column(name="Emp_Name")
	 private String empName;
	 private String phone;
	 private String email;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer emptId, String empName, String phone, String email) {
		super();
		this.emptId = emptId;
		this.empName = empName;
		this.phone = phone;
		this.email = email;
	}
	public Integer getEmptId() {
		return emptId;
	}
	public void setEmptId(Integer emptId) {
		this.emptId = emptId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [emptId=" + emptId + ", empName=" + empName + ", phone=" + phone + ", email=" + email + "]";
	}

	 

	 
	 
}
