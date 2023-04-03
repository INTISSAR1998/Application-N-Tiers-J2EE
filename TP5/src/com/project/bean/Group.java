package com.project.bean;

import javax.persistence.Id;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
@Entity
public class Group {
	@Id
	@GeneratedValue
	private int ID,Nombre;
	private String libelle,niveau,Description;
	 @OneToMany
	 private Collection<Student> students;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	public int getNombre() {
		return Nombre;
	}
	public void setNombre(int nombre) {
		Nombre = nombre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
