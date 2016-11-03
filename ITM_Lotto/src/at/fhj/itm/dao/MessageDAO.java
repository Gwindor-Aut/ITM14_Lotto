package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.Message;

public class MessageDAO extends GenericSqlDAO<Message, Integer>{

	@Override
	public Integer create(Message newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO MESSAGES (text, isRead, date, fk_userid) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newInstance.text);
			stmt.setBoolean(2, newInstance.isRead);
			stmt.setDate(3, newInstance.date);
			stmt.setInt(4, newInstance.fk_userId);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Message cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public Message read(Integer id) {
		PreparedStatement stmt;
		Message m = new Message();
		
		m.id = -1;
		m.text = "undefined";
		m.isRead = false;
		m.date = null;
		m.fk_userId = -1;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM MESSAGES WHERE ID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			m.id = rs.getInt("Id");
			m.text = rs.getString("text");
			m.isRead = rs.getBoolean("isRead");
			m.date = rs.getDate("date");
			m.fk_userId = rs.getInt("fk_userid");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read Message with id " + id);
		}
		
		return m;
	}

	@Override
	public void update(Message transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE MESSAGES SET text = ?, isRead = ?, date = ?, fk_userid = ? WHERE ID = ?");
			stmt.setString(1, transientObject.text);
			stmt.setBoolean(2, transientObject.isRead);
			stmt.setDate(3, transientObject.date);
			stmt.setInt(4, transientObject.fk_userId);
			stmt.setInt(5, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Message not found or Message not unique: " + transientObject.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update Message: " + transientObject.toString());
		}
	}

	@Override
	public void delete(Message persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM MESSAGES WHERE ID = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Message not found or Message not unique: " + persistentObject.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("Message cannot be deleted");
		}
	}

}
