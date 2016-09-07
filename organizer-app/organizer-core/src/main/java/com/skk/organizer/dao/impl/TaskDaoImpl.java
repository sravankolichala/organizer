package com.skk.organizer.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Produces;

import com.skk.organizer.core.Person;
import com.skk.organizer.core.Task;
import com.skk.organizer.dao.TaskDao;

@Produces
public class TaskDaoImpl implements TaskDao {

	//@PersistenceContext(unitName = "organizer", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	
	public TaskDaoImpl() {
		super();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("organizer");
		em = factory.createEntityManager();
	}
	
	@Override
	public boolean insertTask(Task task, Person person) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public boolean removeTask(Task task) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.remove(task);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public List<Task> listTasks(CriteriaQuery<Object> criteriaQuery) {
		Root<Task> root = criteriaQuery.from(Task.class);
		CriteriaQuery<Object> select = criteriaQuery.select(root);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();
		List<Task> taskList = resultList.stream().map(o -> (Task)o).collect(Collectors.toList());
		return taskList;
	}

	@Override
	public boolean modifyTask(Task task) {
		boolean operationResult = false;
		em.getTransaction().begin();
		em.merge(task);
		em.getTransaction().commit();
		operationResult = true;
		return operationResult;
	}

	@Override
	public List<Task> listAllTasks() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Task> root = criteriaQuery.from(Task.class);
		CriteriaQuery<Object> select = criteriaQuery.select(root);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();
		List<Task> taskList = resultList.stream().map(o -> (Task)o).collect(Collectors.toList());
		return taskList;
	}

	@Override
	public Task findById(int taskId) {
		Task task = em.find(Task.class, taskId);
		return task;
	}

}
