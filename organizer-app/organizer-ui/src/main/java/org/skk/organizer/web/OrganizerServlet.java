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
import com.skk.organizer.test.CoreTester;

@WebServlet(name="organizerServlet", urlPatterns="/organizer", loadOnStartup=1)
public class OrganizerServlet extends HttpServlet {
	
	@Inject
	private PersonDao personDao;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Person person = new Person("Sravan", "Kolichala");
		System.out.println(personDao.insertPerson(person));
		
		super.service(req, resp);
	}
	
	

}
