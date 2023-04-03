package dao;

import java.util.List;
import java.util.Vector;

import model.Etudiant;

public interface IGestion {
 public Vector<Etudiant> getAllEtudiants();
 public void addEtudiant(Etudiant e);
 public void deleteEtudiant(int num);
 public boolean verif ( String user, String mp);
 

}
