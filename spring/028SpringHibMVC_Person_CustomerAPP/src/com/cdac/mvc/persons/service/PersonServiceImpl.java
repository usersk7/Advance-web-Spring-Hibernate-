package com.cdac.mvc.persons.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.mvc.person.dao.IPersonDao;
import com.cdac.mvc.person.model.Person;
@Service
public class PersonServiceImpl implements IPersonService {
	private IPersonDao personDao;
//setter method for personDao
	@Autowired
	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}
	@Override
	@Transactional
	public Person addPerson(Person p) {
		return this.personDao.addPerson(p);
	}
	@Override
	@Transactional
	public Person updatePerson(Person p) {
		return this.personDao.updatePerson(p);
	}
	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDao.listPersons();
	}
	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDao.getPersonById(id);
	}
	@Override
	@Transactional
	public Person removePerson(int id) {
		return this.personDao.removePerson(id);
	}
}
