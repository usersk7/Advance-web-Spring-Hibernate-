package com.cdac.Userview;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cdac.model.Customer;

public class UserApplication {

	public static void main(String[] args) {

		Customer customer = new Customer(1232,"tukaram","maulo@sk.com","7895613");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			int id = (int)session.save(customer);
			System.out.println("inserted customer"+id);
			transaction.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(transaction != null)
				transaction.rollback();
		}
	}
	
}
