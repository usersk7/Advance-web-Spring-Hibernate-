package com.cdac.hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cdac.hibernate.model.Employee;
import com.cdac.hibernate.model.Manager;
import com.cdac.hibernate.model.SalesManager;
import com.cdac.hibernate.util.HibernateUtil;

public class InheritenceSTMain {

	@SuppressWarnings({"deprecation", "unchecked"})
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			System.out.println("************  CREATE **********");
			Employee emp = new Employee("E",111.0);
			Manager mgr = new Manager("mgr",222.00,100.0);
			SalesManager smgr= new SalesManager( "S", 333.0,10.0,20.0);
			
			session.save(emp);
			session.save(mgr);
			session.save(smgr);
			
			transaction.commit();
			
			List<Employee> emplist = session.createQuery("from Employee").list();
			System.out.println("\n*******************All Employee Records*****************************\n");
			emplist.forEach((empObj)->System.out.println(empObj));
			session.close();
			HibernateUtil.closeSessionFactory();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}finally {
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}

}
