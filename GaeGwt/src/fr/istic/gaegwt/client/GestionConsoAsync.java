package fr.istic.gaegwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.gaegwt.shared.Appareil;
import fr.istic.gaegwt.shared.Home;
import fr.istic.gaegwt.shared.Person;

@RemoteServiceRelativePath("conso")
public interface GestionConsoAsync{

	void createAppareil(Home h,  Appareil a,AsyncCallback<Appareil> callback);

	void createHome(Person p, Home h, AsyncCallback<Home> callback);

	void createPerson(Person p, AsyncCallback<Person> callback);

}
