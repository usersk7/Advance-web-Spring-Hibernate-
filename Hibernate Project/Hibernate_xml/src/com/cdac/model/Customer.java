package com.cdac.model;

public class Customer {
	
	private int cust_id;
	private String custName;
	private String email;
	private String phone;
	
	
	
	public Customer(int cust_id, String custName, String email, String phone) {
		super();
		this.cust_id = cust_id;
		this.custName = custName;
		this.email = email;
		this.phone = phone;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
