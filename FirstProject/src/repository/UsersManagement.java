package repository;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import model.User;

public class UsersManagement {
	
	Connection cnx;
	

	public UsersManagement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstdatabase";
			cnx = (Connection) DriverManager.getConnection(url,"root","12345678");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void addUser(User u)
	{
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into user values (?,?,?,?)");
			stmt.setInt(1, 0);
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public User getUser(String username, String password) {
		User u = null;
		try {
			PreparedStatement stmt = cnx.prepareStatement("select * from user where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			if(result.next()==true) {
				u = new User(result.getInt(1),
				result.getString(2),
				result.getString(3),
				result.getString(4)
				);
			}	
		}
		catch (Exception e) {
			e.getMessage();
		}
		return u;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
