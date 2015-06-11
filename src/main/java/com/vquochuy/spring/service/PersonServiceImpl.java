package com.vquochuy.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vquochuy.spring.dao.PersonDAO;
import com.vquochuy.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person person) {
		this.personDAO.addPerson(person);
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		this.personDAO.updatePerson(person);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	public void removePerson(int id) {
		this.personDAO.removePerson(id);

	}

}
