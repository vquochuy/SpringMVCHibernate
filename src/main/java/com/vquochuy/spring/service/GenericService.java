package com.vquochuy.spring.service;

import java.io.Serializable;
import java.util.List;

import com.vquochuy.spring.model.Person;
import com.vquochuy.spring.response.Response;

public interface GenericService<T extends Serializable> {
	public Response create(T t);

	public Response update(T t);

	public Response getAll();

	public Response getById(int id);

	public Response delete(int id);
}
