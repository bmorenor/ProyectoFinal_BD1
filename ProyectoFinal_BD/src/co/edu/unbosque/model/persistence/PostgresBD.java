package co.edu.unbosque.model.persistence;

import java.sql.*;

public class PostgresBD {
	 public void connectDatabase() {
	        try {
	            // We register the PostgreSQL driver
	            // Registramos el driver de PostgresSQL
	            try { 
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }
	            Connection connection = null;
	            // Database connect
	            // Conectamos con la base de datos
	            connection = DriverManager.getConnection(
	                    "jdbc:postgresql://192.168.0.26:5432/customerdb",
	                    "xulescode", "xulescode");
	 
	            boolean valid = connection.isValid(50000);
	            System.out.println(valid ? "TEST OK" : "TEST FAIL");
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }
	    } 
}
