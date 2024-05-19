package Library_Management_System;

/**
 * Manages the database connection for the library management system.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static final String URL = "jdbc:mysql://localhost:3306/library_management";
	public static final String USER = "root";
	public static final String PASSWORD = "Shubham@410504";
	
	/**
     * Gets the database connection.
     *
     * @return the database connection
     * @throws SQLException if a database access error occurs
     */
	
	public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error occurd while getting the connection : "+e);
		}
		return con;
	}
}
