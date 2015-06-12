package com.vquochuy.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	@Transactional
	public void addPerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(person);
		trans.commit();
		logger.info("Person saved successful. Details: "+person);
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(person);
		logger.info("Person updated successful.");
	}
	@SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Person> listPersons() {
		List<Person> personsList = new ArrayList<Person>();
		try{
			
			Session session = this.sessionFactory.getCurrentSession();
//			Transaction trans = session.beginTransaction();
			 personsList = session.createQuery("from Person").list();
//			trans.commit();
			return personsList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
//        for(Person p : personsList){
//            logger.info("Person List::"+p);
//        }
       
        
      /*  Session session=null;
        try 
        {
        	session = sessionFactory.openSession();
        return session.createSQLQuery("SELECT * FROM Person").list();
        }
        catch(Exception e)
        {
         //Logging
        }
        finally
        {
            if(session !=null && session.isOpen())
            {
              session.close();
              session=null;
            }
        }
        return null;*/
    }
        
        
       // return personsList;
    
 

	@Override
	@Transactional
	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Person person = (Person) session.load(Person.class, new Integer(id));
		return person;
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Person person = (Person) session.load(Person.class, new Integer(id));
		if(null != person){
			session.delete(person);
		}
		logger.info("Person deleted successfull!");
	}

}
