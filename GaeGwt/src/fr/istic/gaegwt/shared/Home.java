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
public class Home implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3517540099265230395L;

	String id;
	
	private int nbpieces, superficie;
	private String adresse, ip;
	
	private Person person;
	
	public int getSuperficie() {
		return superficie;
	}


	public Home() {
		super();
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

	 
	
	public Home(int nbpieces, int superficie, String adresse, String ip) {

		this.nbpieces=nbpieces;
		this.superficie=superficie;
		this.adresse=adresse;
		this.ip=ip;
 

	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getNbpieces() {
		return nbpieces;
	}



	public void setNbpieces(int nbpieces) {
		this.nbpieces = nbpieces;
	}


	
}
