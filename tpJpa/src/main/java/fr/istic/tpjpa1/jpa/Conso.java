package fr.istic.tpjpa1.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import fr.istic.tpjpa1.domain.*;

public class Conso implements GestionConso{
	private EntityManager manager;
	
	public void setManaget(EntityManager manager){
		this.manager=manager;
	}
	
	public List<Person> createPerson() throws ParseException {
		// TODO Auto-generated method stub
		List<Person> lespersons = new ArrayList<Person>();
		int numOfPersons = manager.createQuery("Select p From Person p", Person.class).getResultList().size();

        if (numOfPersons == 0) {
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        	Person p1 = new Person("dupont", "paul", "paul.dupont@gg.fr", "M", "http://", simpleDateFormat.parse("06/12/1965"));
        	Person p2 = new Person("durand", "gerard", "gerard.durand@gg.fr", "F", "http://", simpleDateFormat.parse("06/04/1965"));
        	Person p3 = new Person("Pierre", "martin", "pierre.martin@gg.fr", "M", "http://", simpleDateFormat.parse("06/08/1965"));
        	p1.getListAmis().add(p2);
        	p2.getListAmis().add(p1);
        	p2.getListAmis().add(p3);
            manager.persist(p1);
            manager.persist(p2);
            manager.persist(p3);
            lespersons.add(p1);
            lespersons.add(p2);
            lespersons.add(p3);
        }
        return lespersons;
	}

	public List<Home> createHome(Person p) {
		// TODO Auto-generated method stub
    	List<Home> lesresidences = new ArrayList<Home>();
		int numOfHome = manager.createQuery("Select p From Home p", Home.class).getResultList().size();

        if (numOfHome == 0) {
        	Home h1 = new Home(12, 120, "5 rue des roses, Rennes", "10.10.10.10");
        	Home h2 = new Home(5, 120, "3 rue des camélias, Rennes", "10.0.0.0");
        	p.getResidences().add(h1);
        	h1.setPerson(p);
        	p.getResidences().add(h2);
        	h2.setPerson(p);
            manager.persist(h1);
            manager.persist(h2);
            lesresidences.add(h1);
            lesresidences.add(h2);
        }
		return lesresidences;
	}

	public void createAppareil(Home h) {
		// TODO Auto-generated method stub
		int numOfChauffages = manager.createQuery("Select p From Heater p", Heater.class).getResultList().size();

        if (numOfChauffages == 0) {
        	Heater e1 =new Heater(100);
        	h.getChauffages().add(e1);
        	e1.setHome(h);
            manager.persist(e1);
            
            Heater e2 =new Heater(120);
        	h.getChauffages().add(e2);
        	e2.setHome(h);
            manager.persist(e2);
            
        	ElectronicDevice e3 =new ElectronicDevice(80);
        	h.getEquipements().add(e3);
        	e3.setHome(h);
            manager.persist(e3);
            
            ElectronicDevice e4 =new ElectronicDevice(70);
        	h.getEquipements().add(e4);
        	e4.setHome(h);
            manager.persist(e4);
        }
	}



}
