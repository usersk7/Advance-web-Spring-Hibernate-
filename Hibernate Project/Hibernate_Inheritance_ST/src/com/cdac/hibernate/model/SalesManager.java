package com.cdac.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="SMGR")
public class SalesManager extends Manager {

	@Column(name="COMM")
	private double comm;
	//no-arg constructor, Overloaded constructor
	//toString() method, getters and setters
	
	public SalesManager() {
		
	}

	public SalesManager(String empName, Double empSal, Double bonus,double comm) {
		super(empName, empSal, bonus);
		// TODO Auto-generated constructor stub
		this.comm=comm;
		
	}



	public double getComm() {
		return comm;
	}


	public void setComm(double comm) {
		this.comm = comm;
	}

	
	@Override
	public String toString() {
		return "SalesManager [comm=" + comm +",toString()="+super.toString()+ "]";
	}

	
	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+comm;
	}
	
	
	
	
	
}
