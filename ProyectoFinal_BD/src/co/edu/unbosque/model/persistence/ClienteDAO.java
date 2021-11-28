package co.edu.unbosque.model.persistence;

import java.sql.*;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Cliente_Telefono;

public class ClienteDAO {
	public static int id;
	private Cliente cliente;
	private Cliente_Telefono cliente_Telefono;
	private PostgresBD bd;
	private Statement statement;

	public ClienteDAO() {
		bd = new PostgresBD();
	}

	public boolean registrarCliente(Cliente cliente, Cliente_Telefono telefono) {
		boolean registrar = false;
		bd.connectDatabase();

		try {
			statement = bd.getConnection().createStatement();
			statement.executeUpdate(
					"INSERT INTO usuario (rol_usuario , direccion, nombres,apellidos,correo,documento,nombre_usuario,contrasenia,estado)"
							+ " VALUES" + "(" + "1,'" + cliente.getDireccion() + "'," + "'" + cliente.getNombres()
							+ "'," + "'" + cliente.getApellidos() + "'," + "'" + cliente.getCorreo() + "'," + "'"
							+ cliente.getDocumentoIdentidad() + "'," + "'" + cliente.getUsuario() + "'," + "'"
							+ cliente.getContrasenia() + "'," + "'A'" + ")");

			int id_usuario = ultimoRegistro();
			String tel = telefono.getNum_telefono();
			String[] parts = tel.split(",");
			for (int i = 0; i < parts.length; i++) {
				String part = tel.split(",")[i];
				statement.executeUpdate("INSERT INTO telefono (numero_telefono , id_usuario ,estado)" + " VALUES" + "("
						+ "'" + part + "'," + "'" + id_usuario + "'," + "'A'" + ")");
			}

			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;

	}

	public int ultimoRegistro() {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select id_usuario from usuario\r\n" + "		order by id_usuario desc\r\n" + "		limit 1");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("id_usuario");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
//	public boolean verificarNumeros(Cliente_Telefono telefono) {
//		bd.connectDatabase();
//			boolean verificar = true;
//			String tel = telefono.getNum_telefono();
//			String telefon = null;
//			String[] parts = tel.split(",");
//			System.out.println(parts.length);
//				
//				try {
//					
//					for(int i=0;i < parts.length;i++) {
//						String part = tel.split(",")[i];
//				
//					PreparedStatement consulta = bd.getConnection().prepareStatement("select numero_telefono from telefono where numero_telefono = '"+part+"'");
//					ResultSet res = consulta.executeQuery();
//					
//					
//					if(res.next()) {
//						telefon = res.getString("numero_telefono");
//				
//					
//					}
//				
//					if(telefon.equals(null)) {
//						verificar = true;
//					}else {
//						if(telefon.equals(part)) {
//							verificar = false;
//						
//						}else {
//							verificar = true;
//							
//						}
//			
//					}
//					res.close();
//					consulta.close();
//					}
//					
//				}catch (Exception e) {
//					e.getStackTrace();
//				
//				
//				}
//				
//			
//
//		return verificar;
//	}

	public boolean verificarNumeros(Cliente_Telefono telefono) {
		bd.connectDatabase();
		boolean verificar = true;
		String tel = telefono.getNum_telefono();
		String telefon = null;
		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select numero_telefono from telefono where numero_telefono = '" + tel + "'");
			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				telefon = res.getString("numero_telefono");

			}

			if (telefon.equals(telefono.getNum_telefono())) {
				verificar = false;
				return verificar;
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return verificar;

	}

	public boolean verificarUsuario(Cliente cliente) {
		bd.connectDatabase();
		boolean verificar = true;
		String usuario = "";
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement("select nombre_usuario from usuario\r\n"
					+ "		 where nombre_usuario = '" + cliente.getUsuario() + "'");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				usuario = res.getString("nombre_usuario");
				System.out.println(usuario);
			}
			if (usuario.equals(cliente.getUsuario())) {
				verificar = false;
				return verificar;
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return verificar;

	}


	public boolean verificarUsuarioInicio(String contrasenia1, String usuario1) {
		bd.connectDatabase();
		String usuario = "";
		String contrasenia = "";
		boolean verificar = false;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement("select nombre_usuario,contrasenia,id_usuario from usuario\r\n"
					+ " where nombre_usuario = '" + usuario1 + "'"
					+ " and contrasenia = '"+contrasenia1+"'");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				usuario = res.getString("nombre_usuario");
				contrasenia = res.getString("contrasenia");
				id = res.getInt("id_usuario");
			}
			if (usuario.equals(usuario1) && contrasenia.equals(contrasenia1) ) {
				verificar = true;
				return verificar;
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();
		}

		return verificar;
	}

}
