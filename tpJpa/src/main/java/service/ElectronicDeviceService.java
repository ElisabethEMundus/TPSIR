package service;

import fr.istic.tpjpa1.domain.ElectronicDevice;


public class ElectronicDeviceService{
	
	public ElectronicDevice getDefaultElectronicDevice() {
		ElectronicDevice elect = new ElectronicDevice(100);
		return elect;
	}
}
