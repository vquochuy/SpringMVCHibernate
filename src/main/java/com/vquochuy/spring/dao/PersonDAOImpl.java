package com.vquochuy.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vquochuy.spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(PersonDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Override
	public void addPerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person saved successful. Details: "+person);
	}

	@Override
	public void updatePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("Person updated successful.");
	}
	@SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }
 

	@Override
	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
		return person;
	}

	@Override
	public void removePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
		if(null != person){
			session.delete(person);
		}
		logger.info("Person deleted successfull!");
	}

}
