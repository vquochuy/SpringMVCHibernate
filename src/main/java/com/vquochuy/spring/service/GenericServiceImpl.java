package com.vquochuy.spring.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vquochuy.spring.model.Person;

public class GenericServiceImpl implements GenericService<Serializable> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	
	@Override
	@Transactional
	public void create(Serializable t) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(t);
		
	}

	@Override
	@Transactional
	public void update(Serializable t) {
		
	}

	@Override
	@Transactional
	public List<Serializable> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
