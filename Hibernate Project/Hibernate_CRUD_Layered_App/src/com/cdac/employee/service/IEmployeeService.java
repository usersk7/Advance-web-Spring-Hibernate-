package com.cdac.employee.service;

import java.util.List;

import com.cdac.employee.exception.empException;
import com.cdac.employee.model.Employee;

public interface IEmployeeService {
	
	public Employee addEmployee(Employee employee) throws empException;
	public Employee getEmployeeById(Integer emptId)throws empException;
	public Employee updateEmployee(Employee employee)throws empException;
	public Employee deleteEmployee(Integer emptId)throws empException;

	public List<Employee> listAllEmployee()throws empException;

}
