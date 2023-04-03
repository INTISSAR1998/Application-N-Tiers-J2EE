package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Student;;

public class StudentDao {

	public static Connection getConnection(){ 
		Connection con=null; 
		try{ Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/etablissement","root",""); 
		}catch(Exception e){System.out.println(e);} 
		return con;
	}	
	
	public static int save(Student s){
		int status=0; 
		try{ Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement( "insert into Student(NumInscription,nom,prenom,datenaissance,adresse,email) values(?,?,?,?,?,?)"); 
			ps.setInt(1,s.getNumInscription()); 
			ps.setString(2,s.getNom()); 
			ps.setString(3,s.getPrenom()); 
			ps.setDate(4,s.getDatenaissance()); 
			ps.setString(5,s.getAdresse());
			ps.setString(6,s.getEmail());
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);} 
		return status; 
	} 
	
	public static int update(Student s){
		int status=0;
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement( "update Student set nom=?,prenom=?,datenaissance=?,adresse=?,email=? where NumInscription=?"); 
			ps.setString(1,s.getNom()); 
			ps.setString(2,s.getPrenom()); 
			ps.setDate(3,s.getDatenaissance()); 
			ps.setString(4,s.getAdresse()); 
			ps.setString(5,s.getEmail()); 
			ps.setInt(6,s.getNumInscription()); 
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);}
		return status; 
	}
	
	public static int delete(Student s){ 
		int status=0; 
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Student where NumInscription=?"); 
			ps.setInt(1,s.getNumInscription()); 
			status=ps.executeUpdate(); 
			}catch(Exception e){System.out.println(e);}
		return status;
	} 
	
	public static List<Student> getAllRecords(){
		List<Student> list=new ArrayList<Student>();
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Student"); 
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){ 
				Student s=new Student();
				s.setNumInscription(rs.getInt("NumInscription")); 
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setDatenaissance(rs.getDate("datenaissance"));
				s.setAdresse(rs.getString("adresse"));
				s.setEmail(rs.getString("email"));
				list.add(s); } 
			}catch(Exception e){System.out.println(e);}
		return list; 
	} 
	
	public static Student getRecordById(int NumInscription){
		Student s=null; 
		try{ 
			Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from Student where NumInscription=?"); 
			ps.setInt(1,NumInscription);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				s=new Student(); 
				s.setNumInscription(rs.getInt("NumInscription")); 
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setDatenaissance(rs.getDate("datenaissance"));
				s.setAdresse(rs.getString("adresse"));
				s.setEmail(rs.getString("email")); } 
			}catch(Exception e){System.out.println(e);} 
		return s; 
	}
	
}
