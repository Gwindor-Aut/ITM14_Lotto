package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.Tipp;

public class TippDAO extends GenericSqlDAO<Tipp, Integer>{

	@Override
	public Integer create(Tipp newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO TIPPS (numbers, isQuickTipp, date, fk_userid, fk_drawid) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newInstance.numbers);
			stmt.setBoolean(2, newInstance.isQuicktipp);
			stmt.setDate(3, newInstance.date);
			stmt.setInt(4, newInstance.fk_userId);
			stmt.setInt(5, newInstance.fk_drawId);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Tipp cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public Tipp read(Integer id) {
		PreparedStatement stmt;
		Tipp t = new Tipp();
		
		t.id = -1;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM TIPPS WHERE ID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			t.id = rs.getInt("Id");
			t.numbers = rs.getString("numbers");
			t.isQuicktipp = rs.getBoolean("isQuickTipp");
			t.date = rs.getDate("date");
			t.fk_userId = rs.getInt("fk_userid");
			t.fk_drawId = rs.getInt("fk_drawid");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read Accounting with id " + id);
		}
		
		return t;
	}

	@Override
	public void update(Tipp transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE TIPPS SET numbers = ?, isQuickTipp = ?, date = ?, fk_userid = ?, fk_drawid = ? WHERE ID = ?");
			stmt.setString(1, transientObject.numbers);
			stmt.setBoolean(2, transientObject.isQuicktipp);
			stmt.setDate(3, transientObject.date);
			stmt.setInt(4, transientObject.fk_userId);
			stmt.setInt(5, transientObject.fk_drawId);
			stmt.setInt(6, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Tipp not found or Tipp not unique: " + transientObject.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update Tipp: " + transientObject.toString());
		}
	}

	@Override
	public void delete(Tipp persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM TIPPS WHERE ID = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Tipp not found or Tipp not unique: " + persistentObject.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("Tipp cannot be deleted");
		}
	}

}
