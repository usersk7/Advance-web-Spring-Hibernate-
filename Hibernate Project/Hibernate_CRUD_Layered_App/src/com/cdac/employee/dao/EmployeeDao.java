package com.cdac.employee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.employee.exception.empException;
import com.cdac.employee.model.Employee;

public class EmployeeDao implements IEmployeeDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	

	public EmployeeDao() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		}
	

	@Override
	public Employee addEmployee(Employee employee) throws empException {
		session.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(Integer emptId) throws empException {
		
		return (Employee) session.get(Employee.class,emptId);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws empException {
		session.update(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(Integer emptId) throws empException {
		Employee employee = getEmployeeById(emptId);
		if (employee!=null) {
			session.delete(employee);
		}
		else {
			employee= null;	
		}
		return employee;
	}

	@Override
	public List<Employee> listAllEmployee() throws empException {
	
		return session.createQuery("From Employee").list();
	}

	@Override
	public Transaction beginTx() throws empException {
		transaction=session.beginTransaction();
		return transaction;
	}

	@Override
	public void commitTx() throws empException {

		transaction.commit();

	}

}






































