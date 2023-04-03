package bean;

public class Produit {
	private int id;  
	private String libellé;
	private double prix;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibellé() {
		return libellé;
	}
	public void setLibellé(String libellé) {
		this.libellé = libellé;
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
