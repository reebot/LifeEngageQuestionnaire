package com.cts.lifeengage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FNADbUtil {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		  String driver ="com.mysql.jdbc.Driver";
	        String url ="jdbc:mysql://localhost:3306/mfrp";
	        String user ="root"; 
	        String password ="root";
	        
	        Class.forName(driver);
	        connection = DriverManager.getConnection(url, user, password);
	        return connection;
	}
	

}
