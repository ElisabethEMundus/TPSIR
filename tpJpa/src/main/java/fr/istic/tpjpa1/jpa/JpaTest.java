package fr.istic.tpjpa1.jpa;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa1.domain.Home;
import fr.istic.tpjpa1.domain.Person;

public class JpaTest {

	private EntityManager manager;
	

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqltest");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		
		GestionConso gc = new Conso();
		gc.setManaget(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		// TODO create entity
		List<Person> listP = gc.createPerson();
		List<Home> listH = gc.createHome(listP.get(1));
		gc.createAppareil(listH.get(1));

		// TODO persist entity

		tx.commit();

		// TODO run request

		System.out.println(".. done");
	}

}
