package org.skk.organizer.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skk.organizer.core.Person;
import com.skk.organizer.dao.PersonDao;
import com.skk.organizer.dao.impl.PersonDaoImpl;
import com.skk.organizer.service.OrganizerService;
import com.skk.organizer.service.impl.OrganizerServiceImpl;

import bank.Snippet;




@WebServlet(name="organizerServlet", urlPatterns="/organizer", loadOnStartup=1)
public class OrganizerServlet extends HttpServlet {
	
/*	@Inject
	private PersonDao personDaoImpl;*/

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*		OrganizerService organizerSvc = OrganizerServiceImpl.getInstance();
		Person person = new Person("Sravan", "Kolichala");
		System.out.println(organizerSvc.insertPerson(person));*/
		
/*		PersonDao personDaoImpl = new PersonDaoImpl();
		Person person = new Person("Sravan", "Kolichala");
		System.out.println(personDaoImpl.insertPerson(person));*/
		
		Snippet snippet = new Snippet();
		System.out.println(snippet.getBank());
		super.service(req, resp);
	}
	
	

}
