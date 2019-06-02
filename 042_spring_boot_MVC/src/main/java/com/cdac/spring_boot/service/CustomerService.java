package com.cdac.spring_boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.spring_boot.dao.ICustomerDao;
import com.cdac.spring_boot.model.Customer;


@Service("customerService")
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	//step 3-annotate @Transactional in every method
	@Transactional
	public List<Customer> getAllCustomers() {
	//step 4- in every method call and return the dao layer method
		//make sure none of the method returns null or zero
		return customerDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);

	}

	@Transactional
	public Customer deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}


}
