package com.skk.organizer.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.skk.organizer.core.Person;
import com.skk.organizer.core.Task;
import com.skk.organizer.dao.PersonDao;
import com.skk.organizer.service.OrganizerService;

@Named
@RequestScoped
public class OrganizerServiceImpl implements OrganizerService {
	
	@Inject
	private PersonDao personDaoImpl;
	
	public static OrganizerServiceImpl getInstance(){
		return new OrganizerServiceImpl();
	}

	private OrganizerServiceImpl() {
		super();
	}

	@Override
	public List<Task> getListOfTasksOfGivenPersonId(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getListOfTasksOfGivenPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getListOfPersonsWithoutTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPersonNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertPerson(Person person) {
		return personDaoImpl.insertPerson(person);
	}

}
