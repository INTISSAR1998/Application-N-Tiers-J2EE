package model;

import java.util.List;

public class Panier {
	private List <LignePanier> listLignePanier;

	public List<LignePanier> getListLignePanier() {
		return listLignePanier;
	}

	public void setListLignePanier(List<LignePanier> listLignePanier) {
		this.listLignePanier = listLignePanier;
	}

	public Panier(List<LignePanier> listLignePanier) {
		super();
		this.listLignePanier = listLignePanier;
	} 
}
