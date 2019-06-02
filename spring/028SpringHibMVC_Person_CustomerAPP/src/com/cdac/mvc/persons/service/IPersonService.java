package com.cdac.mvc.persons.service;

import java.util.List;

import com.cdac.mvc.exception.CustomException;
import com.cdac.mvc.person.model.Person;

public interface IPersonService {
	public Person addPerson(Person person)throws CustomException;//insert
	public Person updatePerson(Person person)throws CustomException;//update/modify
	public List<Person> listPersons()throws CustomException;//retrieve/listAll
	public Person getPersonById(int id)throws CustomException;//search
	public Person removePerson(int id)throws CustomException;//delete/remove
}
