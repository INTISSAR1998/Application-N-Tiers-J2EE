package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Group;;

public class GroupDao {
	public static Connection getConnection(){ 
		Connection con=null; 
		try{ Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/etablissement","root",""); 
		}catch(Exception e){System.out.println(e);} 
		return con;
	}	
	
	public static int save(Group g){
		int status=0; 
		try{ Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement( "insert into Group(ID,libelle,niveau,Description,Nombre) values(?,?,?,?,?)"); 
			ps.setInt(1,g.getID()); 
			ps.setString(2,g.getLibelle()); 
			ps.setString(3,g.getNiveau()); 
			ps.setString(4,g.getDescription()); 
			ps.setInt(5,g.getNombre());
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);} 
		return status; 
	} 
	
	public static int update(Group g){
		int status=0;
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement( "update Group set libelle=?,niveau=?,Description=?,Nombre=? where ID=?"); 
			ps.setString(1,g.getLibelle()); 
			ps.setString(2,g.getNiveau()); 
			ps.setString(3,g.getDescription()); 
			ps.setInt(4,g.getNombre()); 
			ps.setInt(5,g.getID());
			status=ps.executeUpdate(); 
		}catch(Exception e){System.out.println(e);}
		return status; 
	}
	
	public static int delete(Group g){ 
		int status=0; 
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Group where ID=?"); 
			ps.setInt(1,g.getID()); 
			status=ps.executeUpdate(); 
			}catch(Exception e){System.out.println(e);}
		return status;
	} 
	
	public static List<Group> getAllRecords(){
		List<Group> list=new ArrayList<Group>();
		try{ 
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Group"); 
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){ 
				Group g=new Group();
				g.setID(rs.getInt("ID")); 
				g.setLibelle(rs.getString("libelle"));
				g.setNiveau(rs.getString("niveau"));
				g.setDescription(rs.getString("Description"));
				g.setNombre(rs.getInt("Nombre"));
				list.add(g); } 
			}catch(Exception e){System.out.println(e);}
		return list; 
	} 
	
	public static Group getRecordById(int ID){
		Group g=null; 
		try{ 
			Connection con=getConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from Group where ID=?"); 
			ps.setInt(1,ID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				g=new Group(); 
				g.setID(rs.getInt("ID")); 
				g.setLibelle(rs.getString("libelle"));
				g.setNiveau(rs.getString("niveau"));
				g.setDescription(rs.getString("Description"));
				g.setNombre(rs.getInt("Nombre"));} 
			}catch(Exception e){System.out.println(e);} 
		return g; 
	}
}
