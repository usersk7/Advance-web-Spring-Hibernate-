package com.cdac.mvc.person.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.mvc.person.model.Person;
@Repository
public class PersonDaoImpl implements IPersonDao {
	private static final Logger logger = 			
			LoggerFactory.getLogger(PersonDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Person addPerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person saved successfully, Person Details="
		+ person);
		return person;
	}

	@Override
	public Person updatePerson(Person person) {
		Session session = 
				this.sessionFactory
				.getCurrentSession();
		session.update(person);
		logger.info("Person updated successfully, "
				+ "Person Details=" + person);
		return person;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}

	@Override
	public Person removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = 
		(Person) session.load(Person.class, new Integer(id));
		if (null != person) {
			session.delete(person);
		}else {
			logger.error
			("Person NOT deleted, with person Id=" +id);
		}
		logger.info("Person deleted successfully, person details=" + person);
		return person;
	}

}
