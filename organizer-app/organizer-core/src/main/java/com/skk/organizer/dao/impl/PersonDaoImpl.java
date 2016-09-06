package com.skk.organizer.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.skk.organizer.core.Person;
import com.skk.organizer.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {

	@PersistenceContext(unitName = "organizer", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Named("personDao")
	public PersonDaoImpl() {
		super();
	}
	
	@Override
	public boolean insertPerson(Person person) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public boolean removePerson(Person person) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public List<Person> listPersons(CriteriaQuery<Object> criteriaQuery) {
		Root<Person> root = criteriaQuery.from(Person.class);
		CriteriaQuery<Object> select = criteriaQuery.select(root);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();
		List<Person> personList = resultList.stream().map(o -> (Person)o).collect(Collectors.toList());
		return personList;
	}

	@Override
	public boolean modifyPerson(Person person) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public List<Person> listAllPersons() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Person> root = criteriaQuery.from(Person.class);
		CriteriaQuery<Object> select = criteriaQuery.select(root);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();
		List<Person> personList = resultList.stream().map(o -> (Person)o).collect(Collectors.toList());
		return personList;
	}

}
