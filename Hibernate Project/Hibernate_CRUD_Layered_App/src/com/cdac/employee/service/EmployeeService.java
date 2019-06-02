package com.cdac.employee.service;

import java.util.List;

import com.cdac.employee.dao.EmployeeDao;
import com.cdac.employee.dao.IEmployeeDao;
import com.cdac.employee.exception.empException;
import com.cdac.employee.model.Employee;

public class EmployeeService implements IEmployeeService {

	private IEmployeeDao employeeDao;	
	
	
	public EmployeeService() {
		employeeDao = new EmployeeDao();

	}

	@Override
	public Employee addEmployee(Employee employee) throws empException {

		employeeDao.beginTx();
		Employee addEmp = employeeDao.addEmployee(employee);
		employeeDao.commitTx();
		return addEmp;

		
	}

	@Override
	public Employee getEmployeeById(Integer emptId) throws empException {
		return employeeDao.getEmployeeById(emptId);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws empException {
		employeeDao.beginTx();
		Employee updateEmp = employeeDao.updateEmployee(employee);
		employeeDao.commitTx();
		return updateEmp;
	}

	@Override
	public Employee deleteEmployee(Integer emptId) throws empException {
		employeeDao.beginTx();
		Employee deleteEmp = employeeDao.deleteEmployee(emptId);
		employeeDao.commitTx();
		return deleteEmp;
	}

	@Override
	public List<Employee> listAllEmployee() throws empException {
		return employeeDao.listAllEmployee();
		}

}
