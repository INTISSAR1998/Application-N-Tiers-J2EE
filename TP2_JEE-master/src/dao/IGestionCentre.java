package dao;

import java.util.Vector;

import model.*;

public interface IGestionCentre {
 public void addConsultation(Consultation c);
 public Vector<Consultation> getAllConsultation();
 public Vector<Consultation> getConsultationByMedecin(int m);
 public Vector<Patient> getAllPatient();
 public Vector<Medecin> getAllMedecin();

}
