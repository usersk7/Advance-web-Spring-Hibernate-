package com.cdac.employee.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.cdac.employee.exception.empException;
import com.cdac.employee.model.Employee;

public interface IEmployeeDao  {
	
	public Employee addEmployee(Employee employee) throws empException;
	public Employee getEmployeeById(Integer emptId)throws empException;
	public Employee updateEmployee(Employee employee)throws empException;
	public Employee deleteEmployee(Integer emptId)throws empException;

	public List<Employee> listAllEmployee()throws empException;
	public Transaction beginTx() throws empException;
	public void commitTx() throws empException;
	
}
