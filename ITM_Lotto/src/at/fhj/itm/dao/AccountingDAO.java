package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.Accounting;

public class AccountingDAO extends GenericSqlDAO<Accounting, Integer>{

	@Override
	public Integer create(Accounting newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO ACCOUNTINGS (balance, diffBalance, description, date, fk_userid) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, newInstance.balance);
			stmt.setDouble(2, newInstance.diffBalance);
			stmt.setString(3, newInstance.description);
			stmt.setDate(4, newInstance.date);
			stmt.setInt(5, newInstance.fk_userId);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Accounting cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public Accounting read(Integer id) {
		PreparedStatement stmt;
		Accounting a = new Accounting();
		
		a.id = -1;
		a.balance = -1;
		a.diffBalance = -1;
		a.description = "undefined";
		a.date = null;
		a.fk_userId = -1;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM ACCOUNTINGS WHERE ID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			a.id = rs.getInt("Id");
			a.balance = rs.getDouble("balance");
			a.diffBalance = rs.getDouble("diffBalance");
			a.description = rs.getString("description");
			a.date = rs.getDate("date");
			a.fk_userId = rs.getInt("fk_userid");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read Accounting with id " + id);
		}
		
		return a;
	}

	@Override
	public void update(Accounting transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE ACCOUNTINGS SET balance = ?, diffBalance = ?, description = ?, date = ?, fk_userid = ? WHERE ID = ?");
			stmt.setDouble(1, transientObject.balance);
			stmt.setDouble(2, transientObject.diffBalance);
			stmt.setString(3, transientObject.description);
			stmt.setDate(4, transientObject.date);
			stmt.setInt(5, transientObject.fk_userId);
			stmt.setInt(6, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Account not found or Accounting not unique: " + transientObject.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update Accounting: " + transientObject.toString());
		}
	}

	@Override
	public void delete(Accounting persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM ACCOUNTINGS WHERE ID = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Accounting not found or Accounting not unique: " + persistentObject.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("Accounting cannot be deleted");
		}
		
	}

}
