package fr.istic.gaegwt.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Heater extends Appareil implements Serializable{
	private Home home;
	

	public Heater(int consoMoy) {
		super(consoMoy);
	}
	public Heater() {
	}
	
 
	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

}
