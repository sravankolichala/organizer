package com.skk.organizer.core;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Task implements Organizable {
	
	@Id
	@Column(name="TASK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="TaskSeq", sequenceName="TASK_SEQ")
	private int id;
	
	@Column(name="TASK_NAME")
	private String taskName;
	
	@Column(name="TASK_DESCRIPTION")
	private String taskDescription;
	
	@ManyToOne
	@JoinColumn(name="TASK_OWNER_ID")
	private Person person;
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Task() {
		super();
	}
	
	public Task(String taskName, String taskDescription, Person person) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.person=person;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Override
	public Instant getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

}
