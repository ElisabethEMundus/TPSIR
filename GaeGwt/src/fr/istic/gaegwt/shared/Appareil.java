package fr.istic.gaegwt.shared;

import java.io.Serializable;

import javax.jdo.annotations.Inheritance;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

import org.datanucleus.api.jpa.annotations.Extension;

@XmlRootElement
@Entity 
@Inheritance
public class Appareil implements Serializable{
 
	
	public Appareil() {
	}
	
	String id;
	 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
	}

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
