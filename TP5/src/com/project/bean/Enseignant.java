package com.project.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enseignant {

	@Id
	@GeneratedValue
	private int id ;
	private String nom,prenom,adresse,email;
	private Date datenaissance;
	
	@ManyToOne
	private Group groupe;
	
	public Group getGroupe() {
		return groupe;
	}
	public void setGroupe(Group groupe) {
		this.groupe = groupe;
	}
	public int getId() {
		return id;
	}
	public void setID(int id) {
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

}
