package model;

public class Etudiant {
	private int numero;
	private String nom;
	private String prenom;
	private int telephone;
	public Etudiant(int numero, String nom, String prenom, int telephone) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	

}
