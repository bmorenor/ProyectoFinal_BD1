package co.edu.unbosque.model.persistence;

import java.sql.*;

public class PostgresBD {
	
	String bd = "TrabajoFinal";
	String host = "192.168.10.15";
	String usuario = "postgres";
	String url = "jdbc:postgresql://192.168.10.15/TrabajoFinal";
	String contrasena = "12345";
	
    private Connection connection = null;
	 public void connectDatabase() {
	        try {
	            // We register the PostgreSQL driver
	            // Registramos el driver de PostgresSQL
	            try { 
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }
	
	            // Database connect
	            // Conectamos con la base de datos
	            connection = DriverManager.getConnection(
	                    url,usuario, contrasena);
	            if (connection != null) {
	                System.out.println("Connection OK");
	            } else {
	                System.out.println("Connection Failed");
	            }
	    
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }
	    }
	 
	 public void cierraConexion() {
		    try {
		    	connection.close();
		    } catch (SQLException sqle) {
		     System.out.println(sqle);
		    }
		}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
