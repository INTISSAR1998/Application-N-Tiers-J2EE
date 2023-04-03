package jpa;
import jpa.Departement;
import javax.persistence.*;

public class Test1 {
	public static void main(String[] args) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		emf=Persistence.createEntityManagerFactory("Employes");
		em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();//declencher une transaction les mis a jours
			Departement dept=new Departement("Direction","Mahdia") ;
			Departement Dept4=new Departement("Usine","Monastir");
			Departement dept2=new Departement("Comptabilité","Sousse");
			Departement dept3=new Departement("Gestion personnel","Mahdia") ;
			
			em.persist(dept);
			em.persist(dept2);
			em.persist(dept3);

			dept.setLieu("Paris");
			Employe emp1=new Employe("Mohamed");
			Employe emp2=new Employe("Ali",dept2);
			Employe emp3=new Employe("Rim");
			
			em.persist(emp1);
			em.persist(emp2);
			em.persist(emp3);
		
			dept.addEmploye(emp2);
			dept2.addEmploye(emp1);
			dept2.addEmploye(emp3);
			
			Projet projet1=new Projet("Application web");
			Projet projet2=new Projet("Application mobile");
			projet1.addParticipant(emp1, "chef Projet");
			projet1.addParticipant(emp2, "developpeur");
			projet1.addParticipant(emp3, "Designer");
			projet1.addParticipant(emp2, "Testeur");
			
			em.persist(projet1);
			em.persist(projet2);

		tx.commit();
		}
		catch(Exception e) {
			//en vrai il faudrait affiner un peu plus...
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();//annullation et il ne l'insert pas dans la base
			}
		}
		finally {
			if(em!=null) { //em entity manager
				em.close();			}
			if(emf!=null) {// emf entity manager factory
				emf.close();
			}
		}
    }
	
}
