package model;

import java.util.List;

public class Panier {
	private List<LignePanier> lignepanier;

	public Panier(List<LignePanier> lignepanier) {
		super();
		this.lignepanier = lignepanier;
	}

	public List<LignePanier> getLignepanier() {
		return lignepanier;
	}

	public void setLignepanier(List<LignePanier> lignepanier) {
		this.lignepanier = lignepanier;
	}
	

}
