package fr.istic.tpjpa1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Person implements Serializable  {

	private Long id;

	private String nom, prenom, mail, genre, profil;
	private Date dateNaiss;
	private List<Home> residences;
	private List<Person> listAmis;


	

	public Person(String nom, String prenom, String mail, String genre, String profil, Date dateNaiss) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.dateNaiss=dateNaiss;
		this.genre=genre;
		this.profil=profil;
		this.residences=new ArrayList<Home>();
		this.listAmis=new ArrayList<Person>();
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}


	public Date getDateNaiss() {
		return dateNaiss;
	}


	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}


	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getResidences() {
		return residences;
	}



	public void setResidences(List<Home> residences) {
		this.residences = residences;
	}

	@ManyToMany( cascade = CascadeType.PERSIST)
	//@JoinColumn(name="friendid")
	public List<Person> getListAmis() {
		return listAmis;
	}


	public void setListAmis(List<Person> listAmis) {
		this.listAmis = listAmis;
	}

	


	
}
