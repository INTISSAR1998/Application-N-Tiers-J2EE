package jpa;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance; //héritage

@Entity

public class Personne {
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	public int getId() {
		return id;
	}
	public Personne() {
		
	}
public Personne(String Nom) {
		this.nom=Nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
