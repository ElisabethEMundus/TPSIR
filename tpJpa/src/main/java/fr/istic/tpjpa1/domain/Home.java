package fr.istic.tpjpa1.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Home {

	private Long id;
	
	private int nbpieces, superficie;
	private String adresse, ip;
	
	private Person person;
	
	public int getSuperficie() {
		return superficie;
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



	private List<Heater> chauffages;
	
	private List<ElectronicDevice> equipements;
	


	public Home(int nbpieces, int superficie, String adresse, String ip) {

		this.nbpieces=nbpieces;
		this.superficie=superficie;
		this.adresse=adresse;
		this.ip=ip;
		this.chauffages=new ArrayList<Heater>();
		this.equipements=new ArrayList<ElectronicDevice>();

	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNbpieces() {
		return nbpieces;
	}



	public void setNbpieces(int nbpieces) {
		this.nbpieces = nbpieces;
	}


	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public List<Heater> getChauffages() {
		return chauffages;
	}



	public void setChauffages(List<Heater> chauffages) {
		this.chauffages = chauffages;
	}


	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public List<ElectronicDevice> getEquipements() {
		return equipements;
	}



	public void setEquipements(List<ElectronicDevice> equipements) {
		this.equipements = equipements;
	}
	
}
