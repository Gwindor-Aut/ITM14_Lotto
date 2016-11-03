package at.fhj.itm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;


public class ConnectionFactory {

	private static final String DB_PROPFILE = "db.properties";

	private static String db_username = "";
	private static String db_password = "";
	private static String jdbc_driver = "";
	private static String jdbc_url = "";


	static {
		Properties props = new Properties();
		try(InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream(DB_PROPFILE)){
			props.load(in);

			//Reads the properties
			db_username = props.getProperty("db.user");
			db_password = props.getProperty("db.password");
			jdbc_driver = props.getProperty("jdbc.driver");
			jdbc_url = props.getProperty("jdbc.url");

		} catch(IOException e){
			e.printStackTrace();
			System.err.println(DB_PROPFILE + " not found");
			System.exit(1);
		}

		//Test if DB-Driver exists
		try {
			Class.forName(jdbc_driver);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			System.err.println("jdbc.driver can't be loaded");
			System.exit(3);
		}

	}

	public static Connection getConnection(){
		Connection theConnection = null;

		try {
			theConnection = DriverManager.getConnection(jdbc_url, db_username, db_password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return theConnection;
	}
	
}