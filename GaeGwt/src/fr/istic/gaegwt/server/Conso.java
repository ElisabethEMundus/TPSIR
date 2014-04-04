package fr.istic.gaegwt.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.xml.internal.bind.v2.util.FatalAdapter;

import fr.istic.gaegwt.client.GestionConso;
import fr.istic.gaegwt.shared.Appareil;
import fr.istic.gaegwt.shared.ElectronicDevice;
import fr.istic.gaegwt.shared.Heater;
import fr.istic.gaegwt.shared.Home;
import fr.istic.gaegwt.shared.Person;

public class Conso  extends RemoteServiceServlet implements GestionConso{
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
	public Person createPerson(Person p) throws ParseException {
		// TODO Auto-generated method stub
		manager.persist(p);

		return p;
	}



	public Home createHome(Person p, Home h) {
		// TODO Auto-generated method stub
		List<Home> lesresidences = new ArrayList<Home>();
		manager.persist(h);
		lesresidences.add(h);
		p.setResidences(lesresidences);
		return h;
	}

	public Appareil createAppareil(Home h, Appareil a) {
		// TODO Auto-generated method stub
		if(a.getClass().toString().equals("Heater")){
			
			Heater heat = (Heater) a;
			h.getChauffages().add(heat);
			heat.setHome(h);
			manager.persist(a);
			
		}else if(a.getClass().toString().equals("ElectronicDevice")){
			ElectronicDevice e = (ElectronicDevice) a;
			
			h.getEquipements().add(e);
			e.setHome(h);
			manager.persist(e);
			
		}
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
