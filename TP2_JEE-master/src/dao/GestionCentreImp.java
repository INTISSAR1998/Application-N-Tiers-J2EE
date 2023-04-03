package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.*;

public class GestionCentreImp implements IGestionCentre {
	public Connection cnx;

	public GestionCentreImp() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/tp2";
			cnx=(Connection) DriverManager.getConnection(url,"root","scratchpes11");
			}
			catch(SQLException e){
				e.getMessage();} catch (ClassNotFoundException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
				ee.getMessage();
			}	
	}
	
	 public void addConsultation(Consultation c) {
			try {
			PreparedStatement stmt=cnx.prepareStatement("insert into Consultation (jour,heure,idPatient,idMedecin) values (?,?,?,?)");
			stmt.setInt(1,c.getJour());
			stmt.setInt(2,c.getHeure());
			stmt.setInt(3,c.getIdPatient().getId());
			stmt.setInt(4,c.getIdMedecin().getId());
			stmt.executeUpdate();
				}
				catch(Exception exp)
				{
				
				}
	 }
	 
	 public Vector<Consultation> getAllConsultation() {
		 Vector<Consultation> result = new Vector<Consultation>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from consultation");
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Patient p = this.getPatioentById( resultSet.getInt("idPatient")).elementAt(0);
				Medecin m = this.getMedecinById( resultSet.getInt("idMedecin")).elementAt(0);
				Consultation cn = new Consultation (resultSet.getInt("id"), resultSet.getInt("jour"), resultSet.getInt("heure"), p,m)	;
			result.add(cn);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }
	 
	 public Vector<Consultation> getConsultationByMedecin(int m){
		 Vector<Consultation> result = new Vector<Consultation>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from consultation where idMedecin = ?");
			stmt.setInt(1,m);

			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Patient p = this.getPatioentById( resultSet.getInt("idPatient")).elementAt(0);
				Medecin med = this.getMedecinById( resultSet.getInt("idMedecin")).elementAt(0);
				Consultation cn = new Consultation (resultSet.getInt("id"), resultSet.getInt("jour"), resultSet.getInt("heure"), p,med)	;
			result.add(cn);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }
	 public Vector<Patient> getPatioentById(int m){
		 Vector<Patient> result = new Vector<Patient>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from patient where id = ?");
			stmt.setInt(1,m);

			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Patient p = new Patient (resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("adresse"))	;
			result.add(p);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }
	 public Vector<Medecin> getMedecinById(int m){
		 Vector<Medecin> result = new Vector<Medecin>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from medecin where id = ?");
			stmt.setInt(1,m);

			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Medecin p = new Medecin (resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("specialite"))	;
			result.add(p);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }
	 public Vector<Patient> getAllPatient() {
		 Vector<Patient> result = new Vector<Patient>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from patient");
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Patient p = new Patient (resultSet.getInt("id"), resultSet.getString("nom"),resultSet.getString("adresse"))	;
			result.add(p);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }

public Vector<Medecin> getAllMedecin() {
	 Vector<Medecin> result = new Vector<Medecin>();
		try {
		PreparedStatement stmt=cnx.prepareStatement("select * from medecin");
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()) {
			Medecin p = new Medecin (resultSet.getInt("id"), resultSet.getString("nom"),resultSet.getString("specialite"))	;
		result.add(p);
		}

		stmt.executeUpdate();
			}
			catch(Exception e)
			{
			
			}
		return result;
}
}
