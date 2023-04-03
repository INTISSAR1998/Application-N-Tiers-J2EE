package jpa;
import java.util.Collection;

import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
@Entity
public class Departement {
	@Id
	@GeneratedValue
	  private int id;
	  private String nom;
	  private String lieu;
	  @OneToMany(mappedBy="departement")
	  private Collection<Employe> employes=new ArrayList<Employe>();
		
	  public Collection<Employe> getEmployes() {
		return employes;
	  }

   	  public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	  }

	/**
	   * Constructeur obligatoire pour JPA.
	   *
	   */
	  public Departement() {
	  }
		
	  public Departement(String nom, String lieu) {
	    this.nom = nom;
	    this.lieu = lieu;
	  }

	  /**
	   * Retourne l'identificateur géré par le SGBD. Identifie une ligne
	   * de la base.
	   */
	  public int getId() {
	    return id;
	  }

	  public String getNom() {
	    return nom;
	  }

	  public void setNom(String nom) {
	    this.nom = nom;
	  }

	  public String getLieu() {
	    return lieu;
	  }

	  public void setLieu(String lieu) {
	    this.lieu = lieu;
	  }

	  public void addEmploye(Employe employe) { //employe a un ancien département 
		  employes.add(employe);
		  Departement ancienDept=employe.getDepartement();
		  if (ancienDept!=null) {//mehouch fera8 
			  
			  ancienDept.getEmployes().remove(employe);
		  employe.setDepartement(this);
	  }}


}
