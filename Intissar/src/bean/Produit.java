package bean;

public class Produit {
	private int id;  
	private String libell�;
	private double prix;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibell�() {
		return libell�;
	}
	public void setLibell�(String libell�) {
		this.libell� = libell�;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit() {
		super();
	}
}
