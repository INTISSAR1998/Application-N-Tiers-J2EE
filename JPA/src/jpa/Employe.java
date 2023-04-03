package jpa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Employe extends Personne{
	private BigDecimal salaire;
	@ManyToOne
	private Departement departement;
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="employe")
	private List<Participation> participations=new ArrayList<Participation>();
	
	public List<Participation> getParticipations() {
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	public Employe() {
		
	}
	public Employe(String nom) {
		super(nom);
	}
	public Employe(String nom,Departement departement) {
		super(nom);
		departement.addEmploye(this);
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public BigDecimal getSalaire() {
		return salaire;
	}
	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}
	
}
