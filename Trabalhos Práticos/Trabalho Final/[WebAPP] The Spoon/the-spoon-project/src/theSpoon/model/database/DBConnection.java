package theSpoon.model.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static final String dbURL = "jdbc:mysql://localhost:3306/the_spoon?useSSL=false&allowPublicKeyRetrieval=true";
	public static final String dbUsername = "root";
	public static final String dbPassword = "password";
	
	public static Connection connection = getConnection(); 
	
	public static Connection getConnection() {

		try {
			
			// Carregar Driver MySQL DVBC
			System.out.println("Start getConnection");
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			
			if(connection != null) {
				System.out.println("Connected");
				return connection;
			}else {
				System.out.println("Connection Issue");
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("Exception in DBConnection ==> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
		
	public static void main(String[] args) {
		System.out.println(DBConnection.connection);
	}
	

}
