package model;

public class Produit {
	private String codeProduit;
	private String designation;
	private double prix;
	
	//constructeur par défaut
	public Produit() {
		
	}
	
	//constructeur avec paramétres
	public Produit(String codeProduit, String designation, double prix) {
		super();
		this.codeProduit = codeProduit;
		this.designation = designation;
		this.prix = prix;
	}

	// getters & setters
	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	// la méthode toString()
	@Override
	public String toString() {
		return "Produit [codeProduit=" + codeProduit + ", designation=" + designation + ", prix=" + prix + "]";
	}
	
	
	
	
}
