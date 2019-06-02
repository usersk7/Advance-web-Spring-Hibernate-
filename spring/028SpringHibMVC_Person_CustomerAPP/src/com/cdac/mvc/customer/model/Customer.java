package com.cdac.mvc.customer.model;
/*
 * https://dzone.com/articles/bean-validation-made-simple
CREATE TABLE HB_CUSTOMER
  (customer_Id int PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30),
  email VARCHAR(70),
  age int,
  gender VARCHAR(6),
  birthday DATE, 
  phone VARCHAR(13));

  
INSERT INTO HB_CUSTOMER ( name ,  email ,  age ,  gender ,  birthday , 
  phone )VALUES(
'Smita','smita@gmail.com',99,'FEMALE',
'2011-11-21','9879879876');
select * from HB_CUSTOMER;
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//JSR VALIDATORS
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;//jsr validators
//SPRING DATE FORMAT
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Smita
 *
 */
@Entity
@Table(name="HB_CUSTOMER")
public class Customer implements Serializable{
	private static final long serialVersionUID = -6909011690373056953L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_Id")
	private Integer customerId;
	
	@Size(min = 2, max = 25)
	@NotEmpty(message = "Name is Mandatory!!")
	private String name;

	@NotEmpty
	@Email(message = "Please Enter valid Email Id")
	private String email;

	@NotNull
	@Min(18)
	@Max(100)
	private Integer age;

	@NotNull
	@Enumerated(EnumType.STRING)//jpa/hibernate
	private Gender gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")//SPRING
	@NotNull
	@Past
	private Date birthday;

	private String phone;

	public enum Gender {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + "]";
	}
}
