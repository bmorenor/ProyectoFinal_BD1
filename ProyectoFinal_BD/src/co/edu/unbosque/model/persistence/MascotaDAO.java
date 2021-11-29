package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import co.edu.unbosque.model.Cliente_Telefono;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.Mascota_Color;
import co.edu.unbosque.model.Mascota_especie;
import co.edu.unbosque.model.Mascota_Raza;
import co.edu.unbosque.model.Usuario;

public class MascotaDAO {
	public static int id;
	private Mascota mascota;
	private Mascota_Color mascota_Color;
	private Mascota_especie mascota_especie;
	private Mascota_Raza mascota_raza;
	private UsuarioDAO usuario;
	private PostgresBD bd;
	private Statement statement;
	
	public MascotaDAO() {
		bd = new PostgresBD();
	}
	public boolean registrarDatosM( Mascota_Color color, Mascota_especie especie, Mascota_Raza raza) {
		boolean registrar = false;
		bd.connectDatabase();

		try {
			statement = bd.getConnection().createStatement();
			if(verificarColor(color.getColor())) {
				
				statement.executeUpdate(
						"INSERT INTO color (Tipo_color)"
								+ " VALUES" + "('"+ color.getColor()+ ")");
			}
			if(verificarEspecie(especie.getEspecie())) {
			
				statement.executeUpdate(
						"INSERT INTO especie (tipo_especie)"
								+ " VALUES" + "('"+especie.getEspecie()+"')");
			}
			
			if(verificarRaza(raza.getTipo_raza())) {
				
				statement.executeUpdate(
						"INSERT INTO raza (tipo_raza)"
								+ " VALUES" + "('"+raza.getTipo_raza()+"')");
			}
			
		


			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;

	}
	public boolean registrarMascota(Mascota mascota) {
		boolean registrar = false;
		bd.connectDatabase();
		
		int color=0;
		int raza=0;
		int especie = 0;

		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select id_color from color where tipo_color = '" + mascota.getColor() + "'");
			ResultSet res = consulta.executeQuery();
			
			if (res.next()) {
				color = res.getInt("id_color");

			}
			PreparedStatement consulta2 = bd.getConnection()
					.prepareStatement("select id_raza from raza where tipo_raza = '" + mascota.getRaza() + "'");
			ResultSet res2 = consulta2.executeQuery();
			
			if (res2.next()) {
				raza = res.getInt("id_raza");

			}
			
			PreparedStatement consulta3 = bd.getConnection()
					.prepareStatement("select id_especie from especie where tipo_especie = '" + mascota.getEspecie() + "'");
			ResultSet res3 = consulta3.executeQuery();
			
			if (res3.next()) {
				especie = res.getInt("id_especie");

			}

			
			
			statement = bd.getConnection().createStatement();
			statement.executeUpdate(
					"INSERT INTO mascota (peso,nombre,anno_nacimiento,sexo,color,raza,especie,id_usuario,estado)"
							+ " VALUES"  + "(" + "'" + mascota.getPeso() + "'," + "'" + mascota.getAnno_nacimiento()
							+ "'," + "'" + mascota.getSexo() + "'," + "" + color + "," + ""
							+ raza + "," + "" + especie + "," + ""
							+ UsuarioDAO.id + ","
							+ "'A'" + ")");
			
	

			res.close();
			consulta.close();
			res2.close();
			consulta2.close();
			res3.close();
			consulta3.close();
			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;

	}
	public boolean verificarRaza(String raza) {
		boolean validar = false;
		bd.connectDatabase();
		String raza1="";

		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select tipo_raza from raza where tipo_raza = '" + raza + "'");
			ResultSet res = consulta.executeQuery();
			
			if (res.next()) {
				raza1 = res.getString("tipo_raza");

			}
			if(raza1.equals(raza)) {
				validar =false;
				
			}else {
				validar = true;
			}

	

			res.close();
			consulta.close();

			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return validar;
		
	}
	public boolean verificarEspecie(String especie) {
		boolean validar = false;
		bd.connectDatabase();
		String especie1="";

		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select tipo_especie from especie where tipo_especie = '" + especie + "'");
			ResultSet res = consulta.executeQuery();
			
			if (res.next()) {
				especie1 = res.getString("tipo_especie");

			}
			if(especie1.equals(especie)) {
				validar =false;
				
			}else {
				validar = true;
			}

	

			res.close();
			consulta.close();

			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return validar;
		
	}
	public boolean verificarColor(String color) {
		boolean validar = false;
		bd.connectDatabase();
		String color1="";

		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select tipo_color from color where tipo_color = '" + color + "'");
			ResultSet res = consulta.executeQuery();
			
			if (res.next()) {
				color1 = res.getString("tipo_especie");

			}
			if(color1.equals(color)) {
				validar =false;
				
			}else {
				validar = true;
			}

	

			res.close();
			consulta.close();

			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return validar;
		
	}

}
