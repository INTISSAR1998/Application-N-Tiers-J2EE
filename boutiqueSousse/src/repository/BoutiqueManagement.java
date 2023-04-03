package repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Categorie;
import model.Produit;
import java.util.List;


public class BoutiqueManagement {
	private EntityManager em ;
	public BoutiqueManagement() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persis");
		em=factory.createEntityManager();
	}
	public List<Produit> getAllProduit(){
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Produit p");
		List<Produit> result = q.getResultList();
		em.getTransaction().commit();
		return result ; 
	}
	
	public List<Categorie> getAllCategorie(){
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Categorie p");
		List<Categorie> result = q.getResultList();
		em.getTransaction().commit();
		return result ; 
	}
	
	
	public List<Produit> getProduitByCategorie(int id){
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Produit p where p.categorie.id = :idd");
		q.setParameter("idd", id);
		List<Produit> result = q.getResultList();
		em.getTransaction().commit();
		return result ; 
	}
	
	public Produit getProduitById(int id)
	{
		em.getTransaction().begin();
		Produit p = em.find(Produit.class, id);
		em.getTransaction().commit();
		return p;
		
	}
	
	
	
	
	
	

}
