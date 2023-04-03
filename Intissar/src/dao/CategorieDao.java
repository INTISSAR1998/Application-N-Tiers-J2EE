package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Categorie;

public class CategorieDao {
	public static Connection getConnection(){  
		 Connection con=null;       
		 try{          
			 Class.forName("com.mysql.jdbc.Driver");       
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paniertp","root","");    
			 }catch(Exception e){System.out.println(e);}       
		 return con;   
	 }  
	 public static int save(Categorie g){  
			 int status=0;    
			 try{         
				 Connection con=getConnection();    
				 PreparedStatement ps=con.prepareStatement(   
						 "insert into catégorie(libellé,description) values(?,?)");       
				 		 ps.setString(1,g.getLibellé());         
				 		 ps.setString(2,g.getDescription());      
				 		 status=ps.executeUpdate(); 
			  }catch(Exception e){System.out.println(e);}
			 return status;  
	  }
	 
		 
	 public static int update(Categorie g){    
		 int status=0;      
		 try{          
			 Connection con=getConnection();      
			 PreparedStatement ps=con.prepareStatement("update catégorie set libellé=?,description=? where id=?");     
			 ps.setString(1,g.getLibellé());        
			 ps.setString(2,g.getDescription());      
			 status=ps.executeUpdate(); 
		 }catch(Exception e){System.out.println(e);} 
		 return status;   
	  }
	 public static int delete(Categorie g){   
		 int status=0;   
		 try{  
			 Connection con=getConnection();   
			 PreparedStatement ps=con.prepareStatement("delete from catégorie where id=?");  
			 ps.setInt(1,g.getId());  
			 status=ps.executeUpdate();  
			 }catch(Exception e){System.out.println(e);}       
		 return status;  
	  } 
	 public static List<Categorie> getAllRecords(){   
		 List<Categorie> list=new ArrayList<Categorie>();   
		 try{     
			 Connection con=getConnection();    
			 PreparedStatement ps=con.prepareStatement("select * from catégorie");  
			 ResultSet rs=ps.executeQuery();      
			 while(rs.next()){         
				 Categorie g=new Categorie();     
				 g.setId(rs.getInt("id"));    
				 g.setLibellé(rs.getString("libellé"));     
				 g.setDescription(rs.getString("description"));      
				 list.add(g);         
			 }    
	 	}catch(Exception e){System.out.println(e);}   
		 return list; 
	  }
	 
	 public static Categorie getRecordById(int id){    
		 Categorie g=null;      
		 try{       
			 Connection con=getConnection();     
			 PreparedStatement ps=con.prepareStatement("select * from catégorie where id=?");      
			 ps.setInt(1,id);        
			 ResultSet rs=ps.executeQuery();      
			 while(rs.next()){           
				 g=new Categorie();             
				 g.setId(rs.getInt("id"));     
				 g.setLibellé(rs.getString("libellé"));     
				 g.setDescription(rs.getString("description"));   
				 }  
			 }catch(Exception e){System.out.println(e);} 
		 return g;  
		} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
