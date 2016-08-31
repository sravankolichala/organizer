package com.skk.organizer.beans;

import javax.persistence.EntityManager;

public class ApplicationBeanFactory {
	
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public ApplicationBeanFactory(EntityManager em) {
		super();
		this.em = em;
	}

	public ApplicationBeanFactory() {
		super();
	}
	
	

}
