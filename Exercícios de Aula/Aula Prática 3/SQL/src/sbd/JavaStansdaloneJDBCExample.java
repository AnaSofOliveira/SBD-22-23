package sbd;

import java.sql.*;

public class JavaStansdaloneJDBCExample {

	   static final String DB_URL = "jdbc:mysql://localhost:3306/aula_pratica_2";
	   static final String USER = "root";
	   static final String PASS = "password";
	   static final String QUERY = "SELECT numero,"
	   		+ "    nome,"
	   		+ "    genero,"
	   		+ "    nascido,"
	   		+ "    telemovel,"
	   		+ "    email FROM aula_pratica_2.aluno;";

	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	            System.out.print("numero: " + rs.getInt("numero"));
	            System.out.print(", nome: " + rs.getString("nome"));
	            System.out.print(", genero: " + rs.getString("genero"));
	            System.out.print(", nascido: " + rs.getDate("nascido"));
	            System.out.print(", telemovel: " + rs.getString("telemovel"));
	            System.out.print(", email: " + rs.getString("email"));
	            System.out.println();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }

}



