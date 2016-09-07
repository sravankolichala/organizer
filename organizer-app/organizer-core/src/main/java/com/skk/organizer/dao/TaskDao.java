package com.skk.organizer.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.skk.organizer.core.Person;
import com.skk.organizer.core.Task;

public interface TaskDao {
	
	public boolean insertTask(Task task, Person person);
	public boolean removeTask(Task task);
	public List<Task> listTasks(CriteriaQuery<Object> criteriaQuery);
	public boolean modifyTask(Task task);
	public List<Task> listAllTasks();
	public Task findById(int taskId);

}
