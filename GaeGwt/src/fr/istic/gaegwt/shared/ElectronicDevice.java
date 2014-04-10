package fr.istic.gaegwt.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.datanucleus.api.jpa.annotations.Extension;

@XmlRootElement
@Entity
public class ElectronicDevice extends Appareil implements Serializable{
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
