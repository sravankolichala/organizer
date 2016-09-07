package com.skk.organizer.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.skk.organizer.core.Person;

public interface PersonDao {
	
	public boolean insertPerson(Person person);
	public boolean removePerson(Person person);
	public List<Person> listPersons(CriteriaQuery<Object> criteriaQuery);
	public boolean modifyPerson(Person person);
	public List<Person> listAllPersons();
	public Person findById(int personId);

}
