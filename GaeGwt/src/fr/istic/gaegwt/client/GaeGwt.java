package fr.istic.gaegwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

import fr.istic.gaegwt.shared.Home;
import fr.istic.gaegwt.shared.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GaeGwt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GestionConsoAsync consoService = GWT.create(GestionConso.class);

	private Person person = new Person();
	private Home home = new Home();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Person
		final TextBox namePerson = new TextBox(); 
		final TextBox firstNamePerson = new	TextBox(); 
		final TextBox mailPerson = new TextBox(); 
		final TextBox genrePerson = new TextBox(); 
		final TextBox profilPerson = new TextBox(); 
		final DateBox birthDatePerson = new DateBox();
		final Button sendPerson = new Button("Send Personnal information"); 

		// Home
		final TextBox nbpieces = new TextBox(); 
		final TextBox superficie = new TextBox(); 
		final TextBox adresse = new TextBox(); 
		final TextBox ip = new TextBox(); 
		final Button sendHome = new Button("Send Home information"); 

		// Appareil
		final TextBox consoMoy = new TextBox(); 



		sendPerson.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Person p = new Person(namePerson.getText(),firstNamePerson.getText(),mailPerson.getText(),genrePerson.getText(),profilPerson.getText(),birthDatePerson.getValue());				

				consoService.createPerson(p, new AsyncCallback<Person>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Person result) {
						// TODO Auto-generated method stub
						person = result;
						Window.alert("personn cree");
					}
						
				});



			}
		});

		sendHome.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Home h = new Home(Integer.parseInt(nbpieces.getText()), Integer.parseInt(superficie.getText()), adresse.getText(), ip.getText());		

				consoService.createHome(person, h, new AsyncCallback<Home>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void onSuccess(Home result) {
						// TODO Auto-generated method stub
						home = result;
						
					}
				});



			}
		});


		RootPanel.get().add(namePerson);
		RootPanel.get().add(firstNamePerson);
		RootPanel.get().add(mailPerson);
		RootPanel.get().add(genrePerson);
		
		RootPanel.get().add(sendHome);
		RootPanel.get().add(sendPerson);
		RootPanel.get().add(profilPerson);
		RootPanel.get().add(birthDatePerson);

		RootPanel.get().add(nbpieces);
		RootPanel.get().add(superficie);
		RootPanel.get().add(adresse);
		RootPanel.get().add(ip);

		RootPanel.get().add(consoMoy);


	}
}
