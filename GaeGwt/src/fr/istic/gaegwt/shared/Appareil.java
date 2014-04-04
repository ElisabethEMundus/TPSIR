package fr.istic.gaegwt.shared;

import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

@XmlRootElement
@Entity
public class Appareil {

	private int consoMoy;
	
	public Appareil(int conso){
		consoMoy = conso;
	}
	
	public int getConsoMoy() {
		return consoMoy;
	}

	public void setConsoMoy(int consoMoy) {
		this.consoMoy = consoMoy;
	}
}
