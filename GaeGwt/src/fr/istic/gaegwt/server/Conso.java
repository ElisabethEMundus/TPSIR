package fr.istic.gaegwt.server;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.gaegwt.client.GestionConso;
import fr.istic.gaegwt.shared.Appareil;
import fr.istic.gaegwt.shared.ElectronicDevice;
import fr.istic.gaegwt.shared.Heater;
import fr.istic.gaegwt.shared.Home;
import fr.istic.gaegwt.shared.Person;

public class Conso  extends RemoteServiceServlet implements GestionConso{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	private EntityManagerFactory factory;

	public void setManager(EntityManager manager){
		this.manager=manager;
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		factory = Persistence.createEntityManagerFactory("mysqltest");
		manager = factory.createEntityManager();
	}

	@Override
	public Person createPerson(Person p)  {
		// TODO Auto-generated method stub
		Person y = new Person(p.getNom(), p.getPrenom(), p.getMail(), p.getGenre(), p.getProfil(), null);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(y);
		t.commit();
		return y;
	}



	public Home createHome(Person p, Home h) {
		// TODO Auto-generated method stub
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(h);
		h.setPerson(p);
		t.commit();
		return h;
	}

	public Appareil createAppareil(Home h, Appareil a) {
		// TODO Auto-generated method stub
		
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		
		if(a.getClass().toString().equals("Heater")){
			
			Heater heat = (Heater) a;
			
			heat.setHome(h);
			manager.persist(a);
			
		}else if(a.getClass().toString().equals("ElectronicDevice")){
			ElectronicDevice e = (ElectronicDevice) a;
			
		
			e.setHome(h);
			manager.persist(e);
			
		}
		t.commit();
			return a;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		manager.close();
		factory.close();

	}





}
