package com.skk.organizer.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.emory.mathcs.backport.java.util.Collections;

@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="PERSON_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="PersonSeq", sequenceName="PERSON_SEQ")
	private int id;
	
	@Column(name="FNAME")
	private String firstName;
	
	@Column(name="LNAME")
	private String lastName;
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL, targetEntity=com.skk.organizer.core.Task.class)
	private List<Task> tasks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return " [ id : "+this.id + ", firstName : " +this.firstName+ ", lastName : " +this.lastName+" ]";
	}
	
	public List<Task> getTasks(){
		return Collections.unmodifiableList(tasks);
	}
	
	public void addTask(Task task){
		if(tasks == null){
			tasks = new ArrayList<Task>();
		}
		task.setPerson(this);
		tasks.add(task);
	}
	
	

}
