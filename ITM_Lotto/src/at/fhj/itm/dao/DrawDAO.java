package at.fhj.itm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.fhj.itm.model.Draw;

public class DrawDAO extends GenericSqlDAO<Draw, Integer>{

	@Override
	public Integer create(Draw newInstance) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO draws (pot, numbers, date, jackpotLevel, priceOfTipp, taxrate, ownerrate, fk_winningLevelid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newInstance.pot);
			stmt.setString(2, newInstance.numbers);
			stmt.setDate(3, newInstance.date);
			stmt.setInt(4, newInstance.jackpotLevel);
			stmt.setInt(5, newInstance.priceOfTipp);
			stmt.setInt(6, newInstance.taxRate);
			stmt.setInt(7, newInstance.ownerRate);
			stmt.setInt(8, newInstance.fk_winningLevelId);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			newInstance.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Draw cannot be created");
		}
		return newInstance.id;
	}

	@Override
	public Draw read(Integer id) {
		PreparedStatement stmt;
		Draw d = new Draw();
		
		d.id = -1;
		d.pot = -1;
		d.numbers = "undefined";
		d.date = null;
		d.jackpotLevel = -1;
		d.priceOfTipp = 1;
		d.taxRate = -1;
		d.ownerRate = -1;
		d.fk_winningLevelId = -1;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM draws WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			//Mapping
			d.id = rs.getInt("Id");
			d.pot = rs.getInt("pot");
			d.numbers = rs.getString("numbers");
			d.date = rs.getDate("date");
			d.jackpotLevel = rs.getInt("jackpotLevel");
			d.priceOfTipp = rs.getInt("priceOfTipp");
			d.taxRate = rs.getInt("taxrate");
			d.ownerRate = rs.getInt("ownerrate");
			d.fk_winningLevelId = rs.getInt("fk_winningLevelid");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot read Draw with id " + id);
		}
		
		return d;
	}

	@Override
	public void update(Draw transientObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE draws SET pot = ?, numbers = ?, date = ?, jackpotLevel = ?, priceOfTipp = ?, taxate = ?, ownerrate = ?, fk_winningLevelid = ? WHERE id = ?");
			stmt.setInt(1, transientObject.pot);
			stmt.setString(2, transientObject.numbers);
			stmt.setDate(3, transientObject.date);
			stmt.setInt(4, transientObject.jackpotLevel);
			stmt.setInt(5, transientObject.priceOfTipp);
			stmt.setInt(6, transientObject.taxRate);
			stmt.setInt(7, transientObject.ownerRate);
			stmt.setInt(8, transientObject.fk_winningLevelId);
			stmt.setInt(9, transientObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Draw not found or Draw not unique: " + transientObject.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot update Draw: " + transientObject.toString());
		}
		
	}

	@Override
	public void delete(Draw persistentObject) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM draws WHERE id = ?");
			stmt.setInt(1, persistentObject.id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows != 1){
				System.out.println("Something strange is going on: Draw not found or Draw not unique: " + persistentObject.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println("Draw cannot be deleted");
		}
	}

}
