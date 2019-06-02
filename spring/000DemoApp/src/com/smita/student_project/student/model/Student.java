/**
 * 
 */
package com.smita.student_project.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Smita B Kumar
 *
 */
@Entity
@Table(name="MY_Student")
public class Student implements Serializable{
	private static final long serialVersionUID = -889070784311805052L;

	//put all the JSR annotations	
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private Integer studentId;
	@Size(max = 20, min = 3, 
			message = " Name entered is invalid. It must be between 3 and 20 characters.")
	private String name;
	@NotEmpty(message = "Country Name cannot be empty!")
	private String country;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", country=" + country + "]";
	}
	
	//getters and setters
	//no-arg contructors
	//overloaded contructor
	//toString method
	

}
