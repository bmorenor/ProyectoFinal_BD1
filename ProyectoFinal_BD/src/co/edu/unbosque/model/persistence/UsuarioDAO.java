package co.edu.unbosque.model.persistence;

import java.sql.*;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente_Telefono;
import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {
	public static int id;
	public static int idAdmin;
	private Usuario usuario;
	private Cliente_Telefono cliente_Telefono;
	private PostgresBD bd;
	private Statement statement;

	public UsuarioDAO() {
		bd = new PostgresBD();
	}

	public boolean registrarCliente(Usuario usuario, Cliente_Telefono telefono) {
		boolean registrar = false;
		bd.connectDatabase();

		try {
			statement = bd.getConnection().createStatement();
			statement.executeUpdate(
					"INSERT INTO usuario (rol_usuario , direccion, nombres,apellidos,correo,documento,nombre_usuario,contrasenia,estado)"
							+ " VALUES" + "(" + "1,'" + usuario.getDireccion() + "'," + "'" + usuario.getNombres()
							+ "'," + "'" + usuario.getApellidos() + "'," + "'" + usuario.getCorreo() + "'," + "'"
							+ usuario.getDocumentoIdentidad() + "'," + "'" + usuario.getUsuario() + "'," + "'"
							+ usuario.getContrasenia() + "'," + "'A'" + ")");

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

	public boolean verificarUsuario(Usuario cliente) {
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
		String usuario2 = "";
		String contrasenia = "";
		int rol =0;
		int rol1=1;
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
		
			if (usuario.equals(usuario1) && contrasenia.equals(contrasenia1)) {
				verificar = true;
		
			}else {
				verificar = false;
			}
			PreparedStatement consulta2 = bd.getConnection().prepareStatement("select a.id_rol, b.nombre_usuario from rol a,usuario b where a.id_rol =b.rol_usuario\r\n"
					+ " and b.rol_usuario = " + 1 + ""
					+ " and b.nombre_usuario = '"+usuario1+"'");
			ResultSet res2 = consulta2.executeQuery();
			if (res2.next()) {
				usuario2 = res.getString("nombre_usuario");
				rol = res.getInt("id_rol");
			
			}
			if(usuario1.equals(usuario2)
					&& rol1==rol) {
				verificar = true;
			}else {
				verificar = false;
			}

			res.close();
			consulta.close();
			res2.close();
			consulta2.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();
		}

		return verificar;
	}

	public boolean verificarAdminInicio(String contrasenia1, String usuario1) {
		// TODO Auto-generated method stub
		bd.connectDatabase();
		String usuario = "";
		String usuario2 = "";
		String contrasenia = "";
		int rol =0;
		int rol1=2;
		boolean verificar = false;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement("select nombre_usuario,contrasenia,id_usuario from usuario\r\n"
					+ " where nombre_usuario = '" + usuario1 + "'"
					+ " and contrasenia = '"+contrasenia1+"'");
			
	

			ResultSet res = consulta.executeQuery();
		

			if (res.next()) {
				usuario = res.getString("nombre_usuario");
				contrasenia = res.getString("contrasenia");
				idAdmin = res.getInt("id_usuario");
			}
		
			if (usuario.equals(usuario1) && contrasenia.equals(contrasenia1)) {
				verificar = true;
				
			}else {
				verificar = false;
			}
			PreparedStatement consulta2 = bd.getConnection().prepareStatement("select a.id_rol, b.nombre_usuario from rol a,usuario b where a.id_rol =b.rol_usuario\r\n"
					+ " and b.rol_usuario = " + 2 + ""
					+ " and b.nombre_usuario = '"+usuario1+"'");
			ResultSet res2 = consulta2.executeQuery();
			if (res2.next()) {
				
				rol = res.getInt("id_rol");
				usuario2 = res.getString("nombre_usuario");
			}
			if(usuario1.equals(usuario2)
					&& rol1==rol) {
				verificar = true;
			}else {
				verificar = false;
			}
			
			res.close();
			consulta.close();
			res2.close();
			consulta2.close();
			bd.cierraConexion();
		

		} catch (Exception e) {
			e.getStackTrace();
		
		}

		return verificar;
	
	}
	public ArrayList<Usuario> listaUsuarios(){
		bd.connectDatabase();
		ArrayList<Usuario>miUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select * from usuario");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Usuario usuario =  new Usuario();
				usuario.setId_usuario(res.getInt("id_usuario"));
				usuario.setUsuario(res.getString("nombre_usuario"));
				usuario.setContrasenia(res.getString("contrasenia"));
				usuario.setNombres(res.getString("nombres"));
				usuario.setApellidos(res.getString("apellidos"));
				usuario.setCorreo(res.getString("correo"));
				usuario.setDocumentoIdentidad(res.getString("documento"));
				usuario.setDireccion(res.getString("direccion"));
				usuario.setEstado(res.getString("estado"));
				
				
				miUsuario.add(usuario);
			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miUsuario;
	}

}
