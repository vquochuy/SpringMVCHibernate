package com.vquochuy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.vquochuy.spring.model.Person;
import com.vquochuy.spring.response.Response;
import com.vquochuy.spring.service.PersonService;

@Controller
@EnableWebMvc
public class PersonController {

	@Autowired
	PersonService personService;

	// GET all users :/api/persons
	// GET user by id: /api/person/id
	// POST adding new user: /api/person
	// PUT edit user by id: /api/person/id
	// DELETE delete user by id: /api/persion/id

	@RequestMapping(value = "/persons", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response getPersons() {

		return this.personService.getAll();

	}

	@RequestMapping(value = "/person/{id}", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response getPersonById(@PathVariable("id") int id) {

		return this.personService.getById(id);

	}

	// For add and update person both
	@RequestMapping(value = "/person", headers = "Accept=*/*", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response addPerson(@RequestBody Person p) {
		return this.personService.create(p);
	}

	@RequestMapping(value = "/person/{id}", headers = "Accept=*/*", method = RequestMethod.DELETE, produces = "application/json")
	public Response deletePerson(@PathVariable("id") int id) {
		return this.personService.delete(id);
	}
	//
	// @RequestMapping(value = "/edit/{id}")
	// public String editPerson(@PathVariable("id") int id, Model model) {
	// model.addAttribute("person", this.personService.getPersonById(id));
	// model.addAttribute("listPersons", this.personService.listPersons());
	// return "person";
	// }
}
