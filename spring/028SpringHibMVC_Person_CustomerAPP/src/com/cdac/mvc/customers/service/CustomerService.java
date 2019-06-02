package com.cdac.mvc.customers.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.mvc.customer.dao.ICustomerDao;
import com.cdac.mvc.customer.model.Customer;
/**
 * @author Smita
 *
 */
/*Step 1 : Annotate the Serviceclass with @Service
 * */
/*Step 2 : Implement the ServiceInterface 
 * override all the methods
 * */
//@Service(value="customerService")
public class CustomerService implements ICustomerService {
	/*Step 3 : create IDao interface private var
	 **/	
	@Autowired
	private ICustomerDao customerDao;
	/*Step 4 : generate customerDao getter/setter
	 * */	
	/*Step 5 : annotate customerDao setter with
	 * @Autowired
	 * */
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}	
	public ICustomerDao getCustomerDao() {
		return customerDao;
	}
	/*Step 6 : call dao method in service method*/
	/*Step 7: annotated each business method with
	 * @Transactional*/
	/*By using @Transactional, many important aspects 
	 * such as transaction propagation are handled 
	 * automatically. In this case if another 
	 * transactional method is called by businessLogic(),
	 *  that method will have the option of joining 
	 *  the ongoing transaction.*/
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}
	@Override
	@Transactional
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(customerId);
	}
	@Override
	@Transactional
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return customerDao.listCustomer();
	}
	@Override
	@Transactional
	public Customer removeCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.removeCustomer(customerId);
	}
	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomer(customer);		
	}	
}
