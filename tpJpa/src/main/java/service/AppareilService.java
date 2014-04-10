package service;

import fr.istic.tpjpa1.domain.*;

public class AppareilService {

	
	
	public Appareil getDefaultAppareil(){
		Appareil appareil = new Appareil(100);
		return appareil;
	}
}
