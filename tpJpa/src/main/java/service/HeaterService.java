package service;

import fr.istic.tpjpa1.domain.Heater;


public class HeaterService{
	
	public Heater getDefaultHeater() {
		Heater heater = new Heater(100);
		return heater;
	}
}
