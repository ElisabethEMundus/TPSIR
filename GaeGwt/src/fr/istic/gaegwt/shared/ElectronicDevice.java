package fr.istic.gaegwt.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ElectronicDevice extends Appareil implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5961324042629477435L;
	private Home home;

	public ElectronicDevice(int consoMoy) {
		super(consoMoy);
	}
	public ElectronicDevice() {
	}
	 

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
}
