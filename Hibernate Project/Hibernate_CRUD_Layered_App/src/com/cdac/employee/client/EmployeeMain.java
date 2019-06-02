package com.cdac.employee.client;

import java.util.List;

import com.cdac.employee.exception.empException;
import com.cdac.employee.model.Employee;
import com.cdac.employee.service.EmployeeService;
import com.cdac.employee.service.IEmployeeService;

public class EmployeeMain {

	private static IEmployeeService employeeService;
	static {
		employeeService = new EmployeeService();
		}
	
	
	public static void main(String[] args) throws empException {

		System.out.println("\n ADD The Employee Record");
		Employee employee = new Employee(111,"Shubham","8794561236","shubham@sk.com");
		employeeService.addEmployee(employee);
		
		System.out.println("\n    Retrieve the Employee record  by id");
		System.out.println("Employee Found:"+employeeService.getEmployeeById(employee.getEmptId()));
	
		System.out.println("\n Update the emp");
		
		employee.setEmpName("Shubham Kumbhar");
		System.out.println("Customer updated :"+employeeService.updateEmployee(employee));
		
		
		
		System.out.println("\n 		Listing the customer record ");
		
		List<Employee> empList=employeeService.listAllEmployee();
		empList.forEach((emp1)->System.out.println(emp1));
		
		
		System.out.println("\n 		Delete the customer record ");
		System.out.println("Employee deleted :"+employeeService.deleteEmployee(employee.getEmptId()));
		
		
	
	}

}
