package dao;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import model.Compte;
import model.Etudiant;

public class Gestiondb {
	public Connection cnx;

	public Gestiondb() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/TP1";
			cnx=(Connection) DriverManager.getConnection(url,"root","scratchpes11");
			}
			catch(SQLException e){
				e.getMessage();} catch (ClassNotFoundException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
				ee.getMessage();
			}	
	}
	
	 public void addEtudiant(Etudiant e) {
			try {
			PreparedStatement stmt=cnx.prepareStatement("insert into Etudiant (numero,nom,prenom,numTel) values (?,?,?,?)");
			stmt.setInt(1,e.getNumero());
			stmt.setString(2,e.getNom());
			stmt.setString(3,e.getPrenom());
			stmt.setInt(4,e.getTelephone());

			stmt.executeUpdate();
				}
				catch(Exception exp)
				{
				
				}
	 }
	 public Vector<Etudiant> getAllEtudiants() {
		 Vector<Etudiant> result = new Vector<Etudiant>();
			try {
			PreparedStatement stmt=cnx.prepareStatement("select * from Etudiant");
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
			Etudiant p = new Etudiant (resultSet.getInt("numero"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getInt("numTel"))	;
			result.add(p);
			}

			stmt.executeUpdate();
				}
				catch(Exception e)
				{
				
				}
			return result;
	 }
	 public void deleteEtudiant(int num) {
		 try {
				PreparedStatement stmt=cnx.prepareStatement("Delete from Etudiant where numero=?");
				stmt.setInt(1, num);
				stmt.executeUpdate();
					}
					catch(Exception e)
					{
					
					}
	 }

	 public boolean verif ( String user, String mp) {
		 Compte c = null;
		 boolean verif = false ; 
		 try{
				PreparedStatement stmt=cnx.prepareStatement("select * from compte where user = ? and mp= ?");
				stmt.setString(1, user);
				stmt.setString(2, mp);
				ResultSet rst= stmt.executeQuery();
				if(rst.next())
				{
					verif = true;
					
				}		 
	 }
		 catch(Exception e) {
			 
		 }
		 return verif;

	}
}
	

