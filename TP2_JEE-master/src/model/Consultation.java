package model;

import java.util.Date;

public class Consultation {
	private int id;
	private int jour;
	private int heure;
	private Patient patient;
	private Medecin medecin;
//	private int idPatient;
//	private int idMedecin;
	public Consultation(int id, int jour, int heure, Patient patient, Medecin medecin) {
		super();
		this.id = id;
		this.jour = jour;
		this.heure = heure;
		this.patient = patient;
		this.medecin = medecin;
	}
	public Consultation() {
		super();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public Patient getIdPatient() {
		return patient;
	}
	public void setIdPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getIdMedecin() {
		return medecin;
	}
	public void setIdMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	

}
