package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.User;

public class UserDAO extends GenericSqlDAO<User, Integer>{

	@Override
	public Integer create(User newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newInstance.username);
			stmt.setString(2, newInstance.password);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("User cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public User read(Integer id) {
		PreparedStatement stmt;
		User u = new User();
		
		u.id = -1;
		u.username = "undefined";
		u.password = "undefined";
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			u.id = rs.getInt("Id");
			u.username = rs.getString("username");
			u.password = rs.getString("password");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read User with id " + id);
		}
		
		return u;
	}

	@Override
	public void update(User transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE users SET username = ?, password = ? WHERE id = ?");
			stmt.setString(1, transientObject.username);
			stmt.setString(2, transientObject.password);
			stmt.setInt(3, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: User not found or User not unique: " + transientObject.username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update User: " + transientObject.username);
		}
		
	}

	@Override
	public void delete(User persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM users WHERE id = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: User not found or User not unique: " + persistentObject.username);
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("Driver cannot be deleted");
		}
	}

}
