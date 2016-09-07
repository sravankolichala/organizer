package com.skk.organizer.service;

import java.util.List;

import com.skk.organizer.core.Person;
import com.skk.organizer.core.Task;

public interface OrganizerService {
	
	List<Task> getListOfTasksOfGivenPersonId(int personId);
	List<Task> getListOfTasksOfGivenPerson(Person person);
	List<Person> getListOfPersonsWithoutTasks();
	List<String> getPersonNames();
	boolean insertPerson(Person person);

}
