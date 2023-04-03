package jpa;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Table;
@Entity
public class Projet {
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="projet")
	private List<Participation> participations=new ArrayList<Participation>();
	public Projet() {
		
	}
    public Projet (String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Participation> getParticipations() {
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	public void addParticipant(Employe employe ,String fonction) {
		Participation participation=new Participation(employe,this, fonction); //this projet
		employe.getParticipations().add(participation);
		this.participations.add(participation);
	}

}
