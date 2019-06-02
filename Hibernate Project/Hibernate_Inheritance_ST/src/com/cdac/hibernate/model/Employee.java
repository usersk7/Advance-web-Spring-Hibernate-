package com.cdac.hibernate.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="EMP_ST")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EMP_TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="EMP")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_ID")
	private Long empId;
	
	@Column(name ="EMP_NAME")
	private String empName;
	
	@Column(name ="EMP_SAL")
	private Double empSal;
	
	
	public Employee() {
	}


	public Employee(String empName, Double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}


	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}


	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * @return the empSal
	 */
	public Double getEmpSal() {
		return empSal;
	}


	/**
	 * @param empSal the empSal to set
	 */
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	
	
	
	
	
	
	
}
