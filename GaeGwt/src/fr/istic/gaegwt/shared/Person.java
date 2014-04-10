package fr.istic.gaegwt.shared;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.datanucleus.api.jpa.annotations.Extension;

@XmlRootElement
@Entity
public class Person implements Serializable {

	private String id;

	private String nom, prenom, mail, genre, profil;
	private Date dateNaiss;


	public Person() {
	}
	 

	public Person(String nom, String prenom, String mail, String genre, String profil, Date dateNaiss) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.dateNaiss=dateNaiss;
		this.genre=genre;
		this.profil=profil;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String getId() {
		return id;
	}



	public void setId(String id) {
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




	


	
}
