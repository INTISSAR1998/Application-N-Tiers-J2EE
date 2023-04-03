package repository;
import java.sql.*;

import model.User;
public class UsersManagement {
	private Connection cnx;
	public UsersManagement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstapp";
			cnx = (Connection) DriverManager.getConnection(url,"root","12345678");
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	public void addUser(User u) {
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into user values (?,?,?,?,?)");
			stmt.setInt(1, 0);
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setInt(5, u.getRole());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		
	}
	
	
	
	
	
	
	
	
	

}
