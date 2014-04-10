package fr.istic.tpjpa1.jpa;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import fr.istic.tpjpa1.domain.*;

public interface GestionConso {	
	public void setManaget(EntityManager manager);
	public List<Person> createPerson() throws ParseException;
	public List<Home> createHome(Person p);
	public void createAppareil(Home h);
}
