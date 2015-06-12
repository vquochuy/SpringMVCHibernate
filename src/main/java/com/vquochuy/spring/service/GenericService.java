package com.vquochuy.spring.service;

import java.io.Serializable;
import java.util.List;

import com.vquochuy.spring.model.Person;

public interface GenericService<T extends Serializable> {
	public void create(T t);

	public void update(T t);

	public List<T> getAll();

	public Person getById(int id);

	public void delete(int id);
}
