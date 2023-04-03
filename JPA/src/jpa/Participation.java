package jpa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
@Entity
public class Participation {
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Employe employe;
	@ManyToOne
	private Projet projet;
	private String fonction;
	public Participation() {
		
	}
	public Participation(Employe employe,Projet projet, String fonction) {
		this.employe=employe;
		this.projet=projet;
		this.fonction=fonction;
		
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	

}
