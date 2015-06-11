package com.vquochuy.spring.dao;

import java.util.List;

import com.vquochuy.spring.model.Person;

public interface PersonDAO {
	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
}
