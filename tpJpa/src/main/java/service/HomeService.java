package service;

import fr.istic.tpjpa1.domain.Home;


public class HomeService{
	
	public Home getDefaultHome() {
		Home home = new Home(4,100,"5, rue des paquerettes","127.0.0.1");
		return home;
	}
}

