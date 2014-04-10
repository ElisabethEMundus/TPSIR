package service;

import java.util.Date;

import fr.istic.tpjpa1.domain.*;


public class PersonService{
	
	public Person getDefaultPerson() {
		Person person = new Person("jean", "guy", "bla@bla.bla", "m", "/monprofil", new Date());
		return person;
	}
}

