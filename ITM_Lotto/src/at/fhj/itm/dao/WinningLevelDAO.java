package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.WinningLevel;

public class WinningLevelDAO extends GenericSqlDAO<WinningLevel, Integer>{

	@Override
	public Integer create(WinningLevel newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO WINNINGLEVELS (date, six, five, four, three) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, newInstance.date);
			stmt.setInt(2, newInstance.six);
			stmt.setInt(3, newInstance.five);
			stmt.setInt(4, newInstance.four);
			stmt.setInt(5, newInstance.three);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("WinningLevel cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public WinningLevel read(Integer id) {
		PreparedStatement stmt;
		WinningLevel wl = new WinningLevel();
		
		wl.id = -1;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM WINNINGLEVELS WHERE ID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			wl.id = rs.getInt("Id");
			wl.date = rs.getDate("date");
			wl.six = rs.getInt("six");
			wl.five = rs.getInt("five");
			wl.four = rs.getInt("four");
			wl.three = rs.getInt("three");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read WinningLevel with id " + id);
		}
		
		return wl;
	}

	@Override
	public void update(WinningLevel transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE WINNINGLEVELS SET date = ?, six = ?, five = ?, four = ?, three = ? WHERE ID = ?");
			stmt.setDate(1, transientObject.date);
			stmt.setInt(2, transientObject.six);
			stmt.setInt(3, transientObject.five);
			stmt.setInt(4, transientObject.four);
			stmt.setInt(5, transientObject.three);
			stmt.setInt(6, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: WinningLevel not found or WinningLevel not unique: " + transientObject.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update WinningLevel: " + transientObject.toString());
		}
	}

	@Override
	public void delete(WinningLevel persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM WINNINGLEVELS WHERE ID = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: WinningLevel not found or WinningLevel not unique: " + persistentObject.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("WinningLevel cannot be deleted");
		}
	}

}
