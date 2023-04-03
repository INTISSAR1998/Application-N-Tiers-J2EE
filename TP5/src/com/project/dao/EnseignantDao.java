package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Enseignant;

public class EnseignantDao {

	public static Connection getConnection(){ 
		Connection con=null; 
		try{ Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/etablissement","root",""); 
		}catch(Exception e){System.out.println(e);} 
		return con;
	}	
	
	public static int save(Enseignant es){
		int status=0; 
		try{ Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement( "insert into enseignant(id,nom,prenom,adresse,email,datenaissance) values(?,?,?,?,?,?)"); 
			ps.setInt(1,es.getId()); 
			ps.setString(2,es.getNom()); 
			ps.setString(3,es.getPrenom());  
			ps.setString(4,es.getAdresse());
			ps.setString(5,es.getEmail());
			ps.setDate(6,es.getDatenaissance());
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);} 
		return status; 
	} 
	
	public static int update(Enseignant es){
		int status=0;
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement( "update enseignant set nom=?,prenom=?,adresse=?,email=?,datenaissance=? where id=?"); 
			ps.setString(1,es.getNom()); 
			ps.setString(2,es.getPrenom());  
			ps.setString(3,es.getAdresse()); 
			ps.setString(4,es.getEmail()); 
			ps.setDate(5,es.getDatenaissance());
			ps.setInt(6,es.getId()); 
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);}
		return status; 
	}
	
	public static int delete(Enseignant es){ 
		int status=0; 
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from enseignant where id=?"); 
			ps.setInt(1,es.getId()); 
			status=ps.executeUpdate(); 
			}catch(Exception e){System.out.println(e);}
		return status;
	} 
	
	public static List<Enseignant> getAllRecords(){
		List<Enseignant> list=new ArrayList<Enseignant>();
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from enseignant"); 
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){ 
				Enseignant es=new Enseignant();
				es.setID(rs.getInt("id")); 
				es.setNom(rs.getString("nom"));
				es.setPrenom(rs.getString("prenom"));
				es.setAdresse(rs.getString("adresse"));
				es.setEmail(rs.getString("email"));
				es.setDatenaissance(rs.getDate("datenaissance"));
				list.add(es); } 
			}catch(Exception e){System.out.println(e);}
		return list; 
	} 
	
	public static Enseignant getRecordById(int ID){
		Enseignant s=null; 
		try{ 
			Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from enseignant where id=?"); 
			ps.setInt(1,ID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				s=new Enseignant(); 
				s.setID(rs.getInt("id")); 
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setAdresse(rs.getString("adresse"));
				s.setEmail(rs.getString("email"));
				s.setDatenaissance(rs.getDate("datenaissance"));} 
			}catch(Exception e){System.out.println(e);} 
		return s; 
	}

}
