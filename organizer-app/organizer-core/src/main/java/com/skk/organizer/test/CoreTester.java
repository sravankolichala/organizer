package com.skk.organizer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.skk.organizer.core.Person;
import com.skk.organizer.core.Task;

public class CoreTester {
	
	
	private static final String PERSISTENCE_UNIT_NAME = "organizer";
	  private static EntityManagerFactory factory;

	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    // create new person
	    
/*	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
	    Root<Person> root = criteriaQuery.from(Person.class);
	    
	    System.out.println("Selecting all persons : ");
	    
	    CriteriaQuery<Object> select = criteriaQuery.select(root);
	    TypedQuery<Object> typedQuery = em.createQuery(select);
	    List<Object> resultList = typedQuery.getResultList();
	    
	    for(Object obj : resultList){
	    	Person person = (Person) obj;
	    	System.out.println(person);
	    	
	    }
	    
	    System.out.println("Selecting all persons - With Order: ");
	    
	    select = criteriaQuery.select(root);
	    select.orderBy(criteriaBuilder.asc(root.get("id")));
	    typedQuery = em.createQuery(select);
	    resultList = typedQuery.getResultList();
	    
	    for(Object obj : resultList){
	    	Person person = (Person) obj;
	    	System.out.println(person);
	    	
	    }*/
	    
	    Query q = em.createQuery("select t from Person t where t.id=:personId");
	    q.setParameter("personId", 601);
	    List<Person> personList = q.getResultList();
	    System.out.println("Found persons "+personList.size());
	    for (Person person : personList) {
	      System.out.println(person);
	    
	    em.getTransaction().begin();
	    //Person myPerson = new Person("Sravan", "Kolichala");
	    Task task = new Task("MyTask", "MyFirstTask", person);
	    person.addTask(task);
	    em.persist(person);
	    em.getTransaction().commit();
	    }
	    q = em.createQuery("select t from Person t");
	    personList = q.getResultList();
	    for (Person person : personList) {
	      System.out.println(person);
	    }
	    System.out.println("Size: " + personList.size());



	    em.close();
	  }

}
