package com.skk.organizer.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ApplicationResources {

	
	private EntityManager entityManager;

	public ApplicationResources() {
		super();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("organizer");
		this.entityManager = factory.createEntityManager();
		System.out.println("EntityManager object is created during applicaiton sources instantiation.");
	}

}
