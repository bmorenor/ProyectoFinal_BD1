package co.edu.unbosque.model.persistence;


import java.sql.*;
import co.edu.unbosque.model.Cliente;

public class ClienteDAO {
	
	private Cliente cliente;
	private PostgresBD bd;
	 private Statement statement;
	public ClienteDAO() {
		bd = new PostgresBD();
	}
	public boolean registrarCliente (Cliente cliente) {
		boolean registrar = false;
		bd.connectDatabase();
		
		try {
			statement = bd.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO usuario (rol_usuario , direccion, nombres,apellidos,correo,documento,contrasenia,estado)"
					+ " VALUES"+"("+"1,'"+cliente.getDireccion()+"',"
					+"'"+cliente.getNombres()+"',"
					+"'"+cliente.getApellidos()+"',"
					+"'"+cliente.getCorreo()+"',"
					+"'"+cliente.getDocumentoIdentidad()+"',"
					+"'"+cliente.getContrasenia()+"',"
					+"'A'"+")");
			
			registrar =true;
			statement.close();
			bd.cierraConexion();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;
		
	}

}
