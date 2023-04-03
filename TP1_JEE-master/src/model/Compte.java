package model;

public class Compte {
	private String user;
	private String mp;
	public String getUser() {
		return user;
	}
	public void setUser(String nom) {
		this.user = nom;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String prenom) {
		this.mp = prenom;
	}
	public Compte(String user, String mp) {
		super();
		this.user = user;
		this.mp = mp;
	}
	

}
