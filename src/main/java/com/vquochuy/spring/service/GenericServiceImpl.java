package com.vquochuy.spring.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.vquochuy.spring.model.MessageString;
import com.vquochuy.spring.model.Person;
import com.vquochuy.spring.response.Response;
@Transactional
public class GenericServiceImpl<T extends Serializable> implements GenericService<T> {

	@Autowired
	protected SessionFactory sessionFactory;
	protected HttpStatus status = HttpStatus.OK;
	protected int code = HttpStatus.OK.value();
	private Class t;
	
	public GenericServiceImpl(Class t) {
		this.t = t;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	
	@Override
	public Response create(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		return new Response(status, code, MessageString.insertSuccess, t);
	}

	@Override
	public Response update(T t) {
		return new Response();
	}

	@Override
	public Response getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria createCriteria = session.createCriteria(t);
		return new Response(status, code, MessageString.findAllSuccess, createCriteria.list());
	}

	@Override
	public Response getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(t);
		cr.add(Restrictions.eq("id", id));
		return new Response(status, code, MessageString.findByNameSuccess, cr.uniqueResult());
	}

	@Override
	public Response delete(int id) {
		Session session = sessionFactory.getCurrentSession();
        T p = (T) session.load(t, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        return new Response();
	}

}
