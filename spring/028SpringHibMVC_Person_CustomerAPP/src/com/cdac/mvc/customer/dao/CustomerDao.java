package com.cdac.mvc.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.mvc.customer.model.Customer;

/**
 * @author Smita
 *
 */
/*
 * Step 1 : Annotate the daoclass with @Repository
 */
/*
 * Step 2 : Implement the daoInterface override all the methods
 */
//@Repository
public class CustomerDao implements ICustomerDao {
/*
 * Step 3 : create sessionFactory private var and logger from slf4j
 */	private static final Logger logger = 
		 LoggerFactory.getLogger(CustomerDao.class);
 @Autowired	
 private SessionFactory sessionFactory;
/*
 * Step 4 : generate sessionFactory getter/setter
 */
	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	/*
	 * Step 5 : annotate sessionFactory setter with
	 * 
	 * @Autowired
	 */
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdac.mvc.customer.dao.ICustomerDao#addCustomer(com.cdac.mvc.customer.model.Customer)
	 */
	/*
	 * Step 6 : write the hibernate code in every method to perform specific CRUD
	 * operation
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		logger.info("Customer saved successfully, " + "Customer Details=" + customer);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdac.mvc.customer.dao.ICustomerDao#getCustomerById(java.lang.Integer)
	 */
	@Override
	public Customer getCustomerById(Integer customerId) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, customerId);
		if (customer != null)
			logger.info("Customer Found, " + "Customer Details=" + customer);
		else
			logger.error("Customer NOT Found, " + "with Customer Id=" + customerId);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdac.mvc.customer.dao.ICustomerDao#listCustomer()
	 */
	@Override
	public List<Customer> listCustomer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = 
		session.createQuery("from Customer").list();
		for (Customer customer : customerList) {
			logger.info("Customer List::" + customer);
		}
		return customerList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdac.mvc.customer.dao.ICustomerDao#removeCustomer(java.lang.Integer)
	 */
	@Override
	public Customer removeCustomer(Integer customerId) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) 
		session.load(Customer.class, customerId);
		if (customer != null) {
			session.delete(customer);
			customer=null;
			logger.info("Customer Delete successfully," + "with Id : " + customerId);
		} else
			logger.info("Customer NOT Delete");
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdac.mvc.customer.dao.ICustomerDao#updateCustomer(com.cdac.mvc.customer.model.Customer)
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
		logger.info("Customer Updated successfully, " + "Customer Details=" + customer);
		return customer;
	}

}
