package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Produit;

public class ProduitDao {
	 public static Connection getConnection(){  
		 Connection con=null;       
		 try{          
			 Class.forName("com.mysql.jdbc.Driver");       
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paniertp","root","");    
			 }catch(Exception e){System.out.println(e);}       
		 return con;   
	 }  
	 public static int save(Produit p){  
			 int status=0;    
			 try{         
				 Connection con=getConnection();    
				 PreparedStatement ps=con.prepareStatement(   
						 "insert into produit(libellé,prix) values(?,?)");       
				 		 ps.setString(1,p.getLibellé());         
				 		 ps.setDouble(2,p.getPrix());      
				 		 status=ps.executeUpdate(); 
			  }catch(Exception e){System.out.println(e);}
			 return status;  
	  }
	 
		 
	 public static int update(Produit p){    
		 int status=0;      
		 try{          
			 Connection con=getConnection();      
			 PreparedStatement ps=con.prepareStatement("update produit set libellé=?,prix=? where id=?");     
			 ps.setString(1,p.getLibellé());        
			 ps.setDouble(2,p.getPrix());      
			 status=ps.executeUpdate(); 
		 }catch(Exception e){System.out.println(e);} 
		 return status;   
	  }
	 public static int delete(Produit p){   
		 int status=0;   
		 try{  
			 Connection con=getConnection();   
			 PreparedStatement ps=con.prepareStatement("delete from produit where id=?");  
			 ps.setInt(1,p.getId());  
			 status=ps.executeUpdate();  
			 }catch(Exception e){System.out.println(e);}       
		 return status;  
	  } 
	 public static List<Produit> getAllRecords(){   
		 List<Produit> list=new ArrayList<Produit>();   
		 try{     
			 Connection con=getConnection();    
			 PreparedStatement ps=con.prepareStatement("select * from produit");  
			 ResultSet rs=ps.executeQuery();      
			 while(rs.next()){         
				 Produit p=new Produit();     
				 p.setId(rs.getInt("id"));    
				 p.setLibellé(rs.getString("libellé"));     
				 p.setPrix(rs.getDouble("prix"));      
				 list.add(p);         
			 }    
	 	}catch(Exception e){System.out.println(e);}   
		 return list; 
	  }
	 
	 public static Produit getRecordById(int id){    
		 Produit p=null;      
		 try{       
			 Connection con=getConnection();     
			 PreparedStatement ps=con.prepareStatement("select * from produit where id=?");      
			 ps.setInt(1,id);        
			 ResultSet rs=ps.executeQuery();      
			 while(rs.next()){           
				 p=new Produit();             
				 p.setId(rs.getInt("id"));     
				 p.setLibellé(rs.getString("libellé"));     
				 p.setPrix(rs.getDouble("prix"));   
				 }  
			 }catch(Exception e){System.out.println(e);} 
		 return p;  
		} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
