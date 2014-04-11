package fr.istic.gaegwt.client;

import java.text.ParseException;
import java.util.List;



import javax.persistence.EntityManager;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.gaegwt.shared.Appareil;
import fr.istic.gaegwt.shared.Home;
import fr.istic.gaegwt.shared.Person;


@RemoteServiceRelativePath("consommation")
public interface GestionConso extends RemoteService{	
	public Person createPerson(Person p) ;
	public Home createHome(Person p,Home h);
	public Appareil createAppareil(Home h,  Appareil a);
}
